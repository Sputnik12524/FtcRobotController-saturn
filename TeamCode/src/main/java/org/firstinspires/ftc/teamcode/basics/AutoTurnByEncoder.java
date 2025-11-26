package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name=" Georgii Auto Turn By Encoder", group="Robot")
public class AutoTurnByEncoder extends LinearOpMode {

   private DcMotor leftFront;
   private DcMotor rightFront;
   private DcMotor leftBack;
   private DcMotor rightBack;

   @Override
   public void runOpMode() {

       leftFront= hardwareMap.get(DcMotor.class, "leftFront_Gosha");
       leftBack= hardwareMap.get(DcMotor.class, "leftBack_Gosha");
       rightFront= hardwareMap.get(DcMotor.class, "rightFront_Gosha");
       rightBack= hardwareMap.get(DcMotor.class, "rightBack_Gosha");

       leftBack.setDirection(DcMotor.Direction.REVERSE);
       leftFront.setDirection(DcMotor.Direction.REVERSE);
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

       waitForStart();

       leftFront.setPower(0.5);
       rightFront.setPower(-0.5);
       leftBack.setPower(0.5);
       rightBack.setPower(-0.5);

       while (opModeIsActive()&&leftBack.getCurrentPosition()<2000);

       leftFront.setPower(0);
       rightFront.setPower(0);
       leftBack.setPower(0);
       rightBack.setPower(0);
       sleep(1000);

       leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       leftFront.setPower(-0.5);
       rightFront.setPower(0.5);
       leftBack.setPower(-0.5);
       rightBack.setPower(0.5);

       while (opModeIsActive()&&leftBack.getCurrentPosition()>-3000);

       leftFront.setPower(0);
       rightFront.setPower(0);
       leftBack.setPower(0);
       rightBack.setPower(0);

   }
}
