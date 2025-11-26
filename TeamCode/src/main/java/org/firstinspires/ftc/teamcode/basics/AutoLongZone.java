package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name=" Georgii Auto Long Zone", group="Robot")
public class AutoLongZone extends LinearOpMode {

   private DcMotor leftFront;
   private DcMotor rightFront;
   private DcMotor leftBack;
   private DcMotor rightBack;

   static final double PULSES = 537.7;
   static final double WHEEL_DIAMETR = 9.6;
   static final double PULSES_PER_CM = PULSES/(Math.PI*WHEEL_DIAMETR);
   static final double SPEED = 0.5;

   @Override
   public void runOpMode() {

       leftFront= hardwareMap.get(DcMotor.class, "leftFront");
       leftBack= hardwareMap.get(DcMotor.class, "leftBack");
       rightFront= hardwareMap.get(DcMotor.class, "rightFront");
       rightBack= hardwareMap.get(DcMotor.class, "rightBack");

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

       telemetry.addData("start",leftFront.getCurrentPosition());
       telemetry.addData("start",rightFront.getCurrentPosition());
       telemetry.addData("start",leftBack.getCurrentPosition());
       telemetry.addData("start",rightBack.getCurrentPosition());
       telemetry.update();

       waitForStart();

       telemetry.addData("Start",leftFront.getCurrentPosition());
       telemetry.addData("Start",rightFront.getCurrentPosition());
       telemetry.addData("Start",leftBack.getCurrentPosition());
       telemetry.addData("Start",rightBack.getCurrentPosition());
       telemetry.update();

       leftFront.setPower(SPEED);
       rightFront.setPower(SPEED);
       leftBack.setPower(SPEED);
       rightBack.setPower(SPEED);

       while (opModeIsActive()&&leftBack.getCurrentPosition()<170*PULSES_PER_CM){
           telemetry.addData("вперед",leftFront.getCurrentPosition());
           telemetry.addData("вперед",rightFront.getCurrentPosition());
           telemetry.addData("вперед",leftBack.getCurrentPosition());
           telemetry.addData("вперед",rightBack.getCurrentPosition());
           telemetry.update();
       }

       leftFront.setPower(0);
       rightFront.setPower(0);
       leftBack.setPower(0);
       rightBack.setPower(0);
       sleep(1000);

   }
}