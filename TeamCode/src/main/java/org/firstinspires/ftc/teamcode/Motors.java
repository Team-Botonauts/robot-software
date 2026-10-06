package org.firstinspires.ftc.teamcode;

// import libraries
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;


public class Motors {
    // declare motors
    private DcMotor bottomLeft;
    private DcMotor bottomRight;
    private DcMotor topLeft;
    private DcMotor topRight;

    // declare other objects
    OpMode main;
    HardwareMap hardwareMap;
    Telemetry telemetry;
    ElapsedTime runtime = new ElapsedTime();
    Sensing Sensing;

    PID rotatePID;

    // initialise module
    public Motors(OpMode Main, Sensing Sensing) {
        this.main = Main;
        this.telemetry = main.telemetry;
        this.hardwareMap = main.hardwareMap;
        this.Sensing = Sensing;

        this.rotatePID = new PID(0.025, 0.0002, 0.001);//0.0005, 0.0003);


        // setup drive motors
        this.topRight = setupDriveMotor("topRight", DcMotor.Direction.REVERSE);
        this.topLeft = setupDriveMotor("topLeft", DcMotor.Direction.REVERSE);
        this.bottomLeft = setupDriveMotor("bottomLeft", DcMotor.Direction.REVERSE);
        this.bottomRight = setupDriveMotor("bottomRight", DcMotor.Direction.FORWARD);

    }

    // This function normalizes the angle so it returns a value between -180° and 180° instead of 0° to 360°.
    public double angleWrap(double degrees) {

        while (degrees > 180) {
            degrees -= 2 * 180;
        }
        while (degrees < -180) {
            degrees += 2 * 180;
        }

        // keep in mind that the result is in radians
        return degrees;
    }


    // SETUP FUNCTIONS //

    // setup a drive motor
    private DcMotor setupDriveMotor(String deviceName, DcMotor.Direction direction) {
        DcMotor motor = hardwareMap.get(DcMotor.class, deviceName);
        motor.setDirection(direction);
        return motor;
    }


    // DRIVETRAIN FUNCTIONS //

    // assign each motor a power setting
    public void driveWithPower(double bottomLeftPower, double bottomRightPower, double topLeftPower, double topRightPower) {
        this.bottomLeft.setPower(bottomLeftPower);
        this.bottomRight.setPower(bottomRightPower);
        this.topLeft.setPower(topLeftPower);
        this.topRight.setPower(topRightPower);
    }

    // move robot with with vectors and a rotation, relative to the arena
    public void driveWithDirections(double y, double x, double theta, double currentAngle) {
        // rotate the directions relative to the robot
        double x_rotated = x * Math.cos(currentAngle) - y * Math.sin(currentAngle);
        double y_rotated = x * Math.sin(currentAngle) + y * Math.cos(currentAngle);
        // apply to motors
        driveRelativeToRobot(x_rotated, y_rotated, theta);
    }

    // move robot with vectors and a rotation, relative to the robot
    public void driveRelativeToRobot(double x_rotated, double y_rotated, double theta) {
        double bottomLeftPower = x_rotated - y_rotated + theta;
        double bottomRightPower = x_rotated + y_rotated - theta;
        double topLeftPower = x_rotated + y_rotated + theta;
        double topRightPower = x_rotated - y_rotated - theta;

        this.driveWithPower(bottomLeftPower, bottomRightPower, topLeftPower, topRightPower);
    }

    // rotate to an angle relative to the arena - doesn't work yet!
    public void rotateToAngleByProportional(double angle) {
        double differenceInAngles = angleWrap(angle + Sensing.yaw);

        telemetry.addData("error", differenceInAngles);

        //  if (Math.abs(differenceInAngles) < 0.005) {driveRelativeToRobot(0, 0, 0);return;}

        double theta = rotatePID.update(differenceInAngles);

        telemetry.addData("theta", theta);

        driveRelativeToRobot(0, 0, theta);
    }
}