


package org.firstinspires.ftc.teamcode.basics;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Ksusha: Auto Drive By Encodor", group="Robot")
public class AutoDriveByEncoder_Ksusha extends LinearOpMode {


   /* Declare OpMode members. */
   private DcMotor         leftBack   ;
   private DcMotor         leftFront  ;
   private DcMotor         rightBack   ;
   private DcMotor         rightFront  ;






   @Override
   public void runOpMode() {


       // Initialize the drive system variables.
       leftFront  = hardwareMap.get(DcMotor.class, "leftFront_Ksusha");
       leftBack = hardwareMap.get(DcMotor.class, "leftBack_Ksusha");
       rightFront  = hardwareMap.get(DcMotor.class, "rightFront_Ksusha");
       rightBack = hardwareMap.get(DcMotor.class, "rightBack_Ksusha");



       // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
       // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
       // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
       leftFront.setDirection(DcMotor.Direction.REVERSE);
       leftBack.setDirection(DcMotor.Direction.REVERSE);
       rightFront.setDirection(DcMotor.Direction.FORWARD);
       rightBack.setDirection(DcMotor.Direction.FORWARD);

       leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       // Send telemetry message to signify robot waiting;


       // Wait for the game to start (driver presses START)
       waitForStart();
       leftBack.setPower(0.5);
       leftFront.setPower(0.5);
       rightBack.setPower(0.5);
       rightFront.setPower(0.5);

       while (opModeIsActive() && leftBack.getCurrentPosition() < 2000);
       leftBack.setPower(0);
       leftFront.setPower(0);
       rightBack.setPower(0);
       rightFront.setPower(0);

       sleep(1000);

       leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       leftBack.setPower(-0.5);
       leftFront.setPower(-0.5);
       rightBack.setPower(-0.5);
       rightFront.setPower(-0.5);
       while (opModeIsActive() && leftBack.getCurrentPosition() > -3000);
       leftBack.setPower(0);
       leftFront.setPower(0);
       rightBack.setPower(0);
       rightFront.setPower(0);


   }
}

