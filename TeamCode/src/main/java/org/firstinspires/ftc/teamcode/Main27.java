package org.firstinspires.ftc.teamcode;

// import libraries
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp

public class Main27 extends OpMode { // Linear or Iterative OpMode?

    // declare modules
    private Motors Motors;
    private Sensing Sensing;

    @Override
    public void init() {
        // assign modules
        Sensing = new Sensing(this);
        Motors = new Motors(this, this.Sensing);

    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        Sensing.updateIMU();
        //Motors.rotateToAngleByProportional(-175);Motors.angleWrapDeg(Sensing.yaw - 90)
        telemetry.addData("Sensing Yaw: ",Math.toDegrees((Sensing.yaw)));

        Motors.driveWithDirections(0.2, 0, 0.8, Sensing.yaw);
        //Motors.driveWithPower(-0.2, 0.2,0.2,-0.2);
       // Motors.driveRelativeToRobot(0.2,0, 0);

        //if (Motors.angleWrapDeg(Sensing.yaw) > 1 || Motors.angleWrapDeg(Sensing.yaw) < -1) {
           // Motors.rotateToAngleByProportional(90);
        //}
        //else {
            //Motors.driveWithPower(0,0,0,0);
            //Motors.driveWithDirections(0.5, 0.5, 0.01, Sensing.yaw);
        //}

    }

    @Override
    public void stop() {

    }

}
