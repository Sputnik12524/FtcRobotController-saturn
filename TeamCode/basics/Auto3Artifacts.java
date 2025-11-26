


package org.firstinspires.ftc.teamcode.basics;


import android.provider.MediaStore;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "Ksusha Auto 3 Artifacts", group = "Robot")
public class Auto3Artifacts extends LinearOpMode {


    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor shooter;
    private CRServo leftServo;
    private CRServo rightServo;
    public static double LAUNCH = 0.6;




    static final double PULSES = 537.7;
    static final double WHEEL_DIAMETR = 9.6;
    static final double PULSES_PER_CM = PULSES / (Math.PI * WHEEL_DIAMETR);
    static final double SPEED = 0.5;


    @Override
    public void runOpMode() {


        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");


        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftServo.setDirection(DcMotorSimple.Direction.REVERSE);
        shooter.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.FORWARD);


        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        telemetry.addData("start", leftFront.getCurrentPosition());
        telemetry.addData("start", rightFront.getCurrentPosition());
        telemetry.addData("start", leftBack.getCurrentPosition());
        telemetry.addData("start", rightBack.getCurrentPosition());
        telemetry.update();


        waitForStart();
 driveBack(SPEED,50);



        shooter.setPower(LAUNCH);


        sleep(4000);
        //первый шар
        leftServo.setPower(1);
        rightServo.setPower(1);


        sleep(250);


        leftServo.setPower(0);
        rightServo.setPower(0);


        sleep(4000);


        //второй шар
        leftServo.setPower(1);
        rightServo.setPower(1);


        sleep(180);


        leftServo.setPower(0);
        rightServo.setPower(0);


        shooter.setPower(LAUNCH);


        sleep(4000);


        //третий шар
        leftServo.setPower(1);
        rightServo.setPower(1);


        sleep(250);


        leftServo.setPower(0);
        rightServo.setPower(0);


        sleep(1000);


        //четвёртый шар
        leftServo.setPower(1);
        rightServo.setPower(1);


        sleep(250);


        leftServo.setPower(0);
        rightServo.setPower(0);


        sleep(4000);


        shooter.setPower(0);
    }

   public void driveBack(double power,double distance){
       leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


       leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       leftFront.setPower(-power);
       rightFront.setPower(-power);
       leftBack.setPower(-power);
       rightBack.setPower(-power);

       while (opModeIsActive() && leftBack.getCurrentPosition() > -distance * PULSES_PER_CM);

       leftFront.setPower(0);
       rightFront.setPower(0);
       leftBack.setPower(0);
       rightBack.setPower(0);



   }




}











