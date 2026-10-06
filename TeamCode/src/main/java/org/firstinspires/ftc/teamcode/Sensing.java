package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Sensing {
    // declare sensors
    public IMU imu;

    // declare other objects
    OpMode main;
    HardwareMap hardwareMap;
    Telemetry telemetry;
    ElapsedTime runtime = new ElapsedTime();

    double yaw;
    double pitch;
    double roll;

    public Sensing(OpMode Main) {
        this.main = Main;
        this.telemetry = main.telemetry;
        this.hardwareMap = main.hardwareMap;
        this.imu = hardwareMap.get(IMU.class, "imu");

        initIMU();

        resetIMU();

    }


    // SETUP FUNCTIONS

    public void initIMU() {

        IMU.Parameters myIMUparameters;

        imu.initialize(
                new IMU.Parameters(
                        new RevHubOrientationOnRobot(
                                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                                RevHubOrientationOnRobot.UsbFacingDirection.DOWN
                        )
                )
        );

        resetIMU();

    }

    public void resetIMU() {
        imu.resetYaw();
    }


    // SENSING FUNCTIONS

    public void updateIMU() {

        YawPitchRollAngles robotOrientation;
        robotOrientation = imu.getRobotYawPitchRollAngles();

        yaw = robotOrientation.getYaw(AngleUnit.DEGREES);
        pitch = robotOrientation.getPitch(AngleUnit.DEGREES);
        roll = robotOrientation.getRoll(AngleUnit.DEGREES);

        telemetry.addData("Yaw", yaw);
        telemetry.addData("Pitch", pitch);
        telemetry.addData("Roll", roll);

    }
}
