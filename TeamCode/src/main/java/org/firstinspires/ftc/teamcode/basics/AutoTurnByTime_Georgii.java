package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name=" Georgii Auto Turn By Time", group="Robot")
public class AutoTurnByTime_Georgii extends LinearOpMode {

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

       waitForStart();

       leftFront.setPower(0.25);
       rightFront.setPower(-0.25);
       leftBack.setPower(0.25);
       rightBack.setPower(-0.25);
       sleep(3000);

       leftFront.setPower(-0.25);
       rightFront.setPower(0.25);
       leftBack.setPower(-0.25);
       rightBack.setPower(0.25);
       sleep(3000);

   }
}
