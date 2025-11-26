package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Georgii Tele Op Rotate", group="Robot")
public class TeleOpRotate extends LinearOpMode {

   private DcMotor         leftBack;
   private DcMotor         rightBack;
   private DcMotor         leftFront;
   private DcMotor         rightFront;

   @Override
   public void runOpMode() {
   double main;
   double rotation;

       leftBack  = hardwareMap.get(DcMotor.class, "leftBack_Gosha");
       rightBack = hardwareMap.get(DcMotor.class, "rightBack_Gosha");
       leftFront  = hardwareMap.get(DcMotor.class, "leftFront_Gosha");
       rightFront  = hardwareMap.get(DcMotor.class, "rightFront_Gosha");

       leftBack.setDirection(DcMotor.Direction.REVERSE);
       leftFront.setDirection(DcMotor.Direction.REVERSE);
       rightBack.setDirection(DcMotor.Direction.FORWARD);
       rightFront.setDirection(DcMotor.Direction.FORWARD);

       waitForStart();

    while (opModeIsActive()) {
        main= -gamepad1.left_stick_y;
        rotation= -gamepad1.right_stick_x;
        leftBack.setPower((main-rotation) *0.5);
        rightBack.setPower((main+rotation) *0.5);
        leftFront.setPower((main-rotation) *0.5);
        rightFront.setPower((main+rotation) *0.5);
        //grupa krovi na rukave
        //gde tvoi cemnadhat' let?
    }
   }
}