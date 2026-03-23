

package org.firstinspires.ftc.teamcode.basics;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.teamcode.shooter.TuningController;

@Config
@TeleOp(name = " Revers intake", group = "Robot")
public class ReverseIntake extends LinearOpMode {

    public static PIDFCoefficients MOTOR_PID = new PIDFCoefficients(10, 0, 9, 17);
    /* Declare OpMode members. */
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private VoltageSensor batteryVoltageSensor;
    public static double LongLAUNCH =  -1380;
    public static double ShortsLAUNCH = - 1150;
    public static double Left = 0.7;
    public static double Right = 1;
    public static double Midle = 0.85;
    public double multiplier = 1;
    boolean xState = false;
    boolean yState = false;
    boolean yState1 = false;
    boolean LongLaunch = false;
    boolean ShortLaunch = false;
    private DcMotor intake;
    private DcMotorEx motorShooter;
    private CRServo leftServo;
    private CRServo rightServo;
    private Servo middleServo;


    @Override
    public void runOpMode() {
        double main;
        double rotation;
        double side;

        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        motorShooter = hardwareMap.get(DcMotorEx.class, "shooter");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");
        middleServo = hardwareMap.get(Servo.class, "middleServo");
        intake = hardwareMap.get(DcMotor.class, "intake");

        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftServo.setDirection(CRServo.Direction.REVERSE);
        rightServo.setDirection(CRServo.Direction.FORWARD);
        motorShooter.setDirection(DcMotorEx.Direction.REVERSE);


        motorShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        batteryVoltageSensor = hardwareMap.voltageSensor.iterator().next();
        setPIDFCoefficients(motorShooter, MOTOR_PID);

        waitForStart();


        while (opModeIsActive())
        {

            double motorVelo = motorShooter.getVelocity();
            telemetry.addData("velocity", motorVelo);

            telemetry.addData("upperBound", TuningController.rpmToTicksPerSecond(TuningController.TESTING_MAX_SPEED * 1.15));
            telemetry.addData("lowerBound", 0);
            telemetry.update();

            if (gamepad2.a) {
                intake.setPower(1);
            } else {
                intake.setPower(0);
            }

            if (gamepad2.dpad_up) {
                intake.setPower(-1);
            } else {
                intake.setPower(0);
            }


            if (gamepad2.y && !yState && !ShortLaunch ) {
                motorShooter.setVelocity(ShortsLAUNCH);
                ShortLaunch= true;
                LongLaunch= false;
            } else if (gamepad1.y && !yState1  && ! LongLaunch ) {
                motorShooter.setVelocity(LongLAUNCH);
                ShortLaunch= false;
                LongLaunch= true;
            } else if ((gamepad1.y && !yState1  && LongLaunch) || ( gamepad2.y && !yState && ShortLaunch))  {
                motorShooter.setVelocity(0);
                ShortLaunch= false;
                LongLaunch= false;
            }

            yState = gamepad2.y;
            yState1 = gamepad1.y;

            if (gamepad2.x) {
                rightServo.setPower(-1);
            } else {
                rightServo.setPower(0);
            }


            if (gamepad2.b) {
                leftServo.setPower(-1);
            } else {
                leftServo.setPower(0);
            }


            if (gamepad2.dpad_right) {
                middleServo.setPosition(Right);
            } else if (gamepad2.dpad_left) {
                middleServo.setPosition(Left);
            }
            if (gamepad2.dpad_down){
                middleServo.setPosition(Midle);
            }

            main = -gamepad1.left_stick_y;
            rotation = (gamepad1.left_trigger - gamepad1.right_trigger);
            side = gamepad1.left_stick_x;
            setPowers(main, side, rotation);


            if (gamepad1.x && multiplier == 1 && !xState) {
                multiplier = 0.5;
            } else if (gamepad1.x && multiplier == 0.5 && !xState) {
                multiplier = 1;
            }




            xState = gamepad1.x;
            telemetry.addLine("hi from fta");

        }
    }

    public void setPowers(double main, double side, double rotation) {
        leftFront.setPower((main + side + rotation) * multiplier);
        leftBack.setPower((main - side + rotation) * multiplier);
        rightFront.setPower((main - side - rotation) * multiplier);
        rightBack.setPower((main + side - rotation) * multiplier);

    }

    private void setPIDFCoefficients(DcMotorEx motor, PIDFCoefficients coefficients) {
        motor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(
                coefficients.p, coefficients.i, coefficients.d, coefficients.f * 12 / batteryVoltageSensor.getVoltage()
        ));
    }
}




