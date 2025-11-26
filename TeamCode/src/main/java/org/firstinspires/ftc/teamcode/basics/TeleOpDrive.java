


package org.firstinspires.ftc.teamcode.basics;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Ksusha: TeleOp", group="Robot")
public class TeleOpDrive extends LinearOpMode {



   private DcMotor         leftBack   ;
   private DcMotor         leftFront  ;
   private DcMotor         rightBack   ;
   private DcMotor         rightFront  ;






   @Override
   public void runOpMode(){
    double main;


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
    leftFront.setPower(main*0.5);
    leftBack.setPower(main*0.5);
    rightFront.setPower(main*0.5);
    rightBack.setPower(main*0.5);
       }





   }
}

