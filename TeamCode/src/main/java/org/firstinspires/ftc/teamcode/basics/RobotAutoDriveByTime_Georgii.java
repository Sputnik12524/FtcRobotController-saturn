package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Georgii Auto Drive By Time", group="Robot")
public class RobotAutoDriveByTime_Georgii extends LinearOpMode {

   private DcMotor         leftBack;
   private DcMotor         rightBack;
   private DcMotor         leftFront;
   private DcMotor         rightFront;

   @Override
   public void runOpMode() {

       leftBack  = hardwareMap.get(DcMotor.class, "leftBack_Gosha");
       rightBack = hardwareMap.get(DcMotor.class, "rightBack_Gosha");
       leftFront  = hardwareMap.get(DcMotor.class, "leftFront_Gosha");
       rightFront  = hardwareMap.get(DcMotor.class, "rightFront_Gosha");

       leftBack.setDirection(DcMotor.Direction.REVERSE);
       leftFront.setDirection(DcMotor.Direction.REVERSE);
       rightBack.setDirection(DcMotor.Direction.FORWARD);
       rightFront.setDirection(DcMotor.Direction.FORWARD);

       waitForStart();

       leftBack.setPower(0.5);
       rightBack.setPower(0.5);
       leftFront.setPower(0.5);
       rightFront.setPower(0.5);
       sleep(2000);

       leftBack.setPower(-0.5);
       rightBack.setPower(-0.5);
       leftFront.setPower(-0.5);
       rightFront.setPower(-0.5);
       sleep(2000);

       leftBack.setPower(0);
       rightBack.setPower(0);
       leftFront.setPower(0);
       rightFront.setPower(0);
   }
}