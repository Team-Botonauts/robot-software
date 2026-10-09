package org.firstinspires.ftc.teamcode;

// import libraries

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class InitialTest extends OpMode { // Linear or Iterative OpMode?


    @Override
    public void init() {

    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {

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
