


package org.firstinspires.ftc.teamcode.basics;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Ksusha: TeleOpRotate", group="Robot")
public class TeleOpRotate extends LinearOpMode {



   private DcMotor         leftBack   ;
   private DcMotor         leftFront  ;
   private DcMotor         rightBack   ;
   private DcMotor         rightFront  ;






   @Override
   public void runOpMode(){
    double main;
    double rotation;


       leftFront  = hardwareMap.get(DcMotor.class, "leftFront_Ksusha");
       leftBack = hardwareMap.get(DcMotor.class, "leftBack_Ksusha");
       rightFront  = hardwareMap.get(DcMotor.class, "rightFront_Ksusha");
       rightBack = hardwareMap.get(DcMotor.class, "rightBack_Ksusha");



       leftFront.setDirection(DcMotor.Direction.REVERSE);
       leftBack.setDirection(DcMotor.Direction.REVERSE);
       rightFront.setDirection(DcMotor.Direction.FORWARD);
       rightBack.setDirection(DcMotor.Direction.FORWARD);


       waitForStart();
while (opModeIsActive()) {
    main = -gamepad1.left_stick_y;
    rotation=-gamepad1.right_stick_x;
    leftFront.setPower(main+rotation*0.5);
    leftBack.setPower(main+rotation*0.5);
    rightFront.setPower(main-rotation*0.5);
    rightBack.setPower(main-rotation*0.5);
       }





   }
}

