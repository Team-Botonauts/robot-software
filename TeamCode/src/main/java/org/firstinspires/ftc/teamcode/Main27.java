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
        //Sensing.updateIMU();
        //Motors.rotateToAngleByProportional(-175);
        telemetry.addData("Running", Motors.angleWrapDeg(Sensing.yaw - 90));

        if (Motors.angleWrapDeg(Sensing.yaw) > 1 || Motors.angleWrapDeg(Sensing.yaw) < -1) {
            Motors.rotateToAngleByProportional(0);
        }
        else {
            //Motors.driveWithPower(0,0,0,0);
            Motors.driveWithDirections(0.5, 0.5, 0.01, Sensing.yaw);
        }

        Sensing.updateIMU();
    }

    @Override
    public void stop() {

    }

}
