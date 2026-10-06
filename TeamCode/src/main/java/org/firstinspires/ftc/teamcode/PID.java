package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PID {

    double Kp;
    double Ki;
    double Kd;


    double integralSum = 0;

    double lastError = 0;

    ElapsedTime timer = new ElapsedTime();


    public PID(double p, double i, double d){
        Kp = p;
        Ki = i;
        Kd = d;
    }


    public double update(double error) {


        // calculate the error
        // double error = reference - state;

        // rate of change of the error
        double derivative = (error - lastError) / timer.seconds();

        // sum of all error over time
        integralSum = integralSum + (error * timer.seconds());

        double out = (Kp * error) + (Ki * integralSum) + (Kd * derivative);



        lastError = error;

        // reset the timer for next time
        timer.reset();

        return out;

    }
}