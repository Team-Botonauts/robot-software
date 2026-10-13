package org.firstinspires.ftc.teamcode;

// import libraries

import static com.qualcomm.robotcore.hardware.HardwareMap.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.util.Range;
import java.text.SimpleDateFormat;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import java.util.Date;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;



@Autonomous
public class InitialTest extends OpMode { // Linear or Iterative OpMode?


    DcMotor testMotor;


    @Override
    public void init() {
        testMotor = hardwareMap.get(DcMotor.class, "testMotor");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        testMotor.setPower(0);
    }

    @Override
    public void loop() {
        //Sensing.updateIMU();
        //Motors.rotateToAngleByProportional(-175);
        telemetry.addData("Running", "True");
        telemetry.addData("Yay?", "Yay!");
        telemetry.addData("OverWireless", "True");
    }

    @Override
    public void stop() {

    }

}
