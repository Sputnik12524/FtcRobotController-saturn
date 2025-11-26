package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "Zhenya TeleOp Mecanum", group = "Robot")
public class TeleOpMecanum extends LinearOpMode {

    /* Declare OpMode members. */
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor rightBack;

    public static double LAUNCH = 0.7;

    public double multiplier = 1;
    boolean xState = false;
    boolean yState = false;


    private DcMotor motorShooter;
    private CRServo leftServo;
    private CRServo rightServo;


    @Override
    public void runOpMode() {
        double main;
        double rotation;
        double side;

        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        motorShooter = hardwareMap.get(DcMotor.class, "shooter");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");


        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftServo.setDirection(CRServo.Direction.REVERSE);
        rightServo.setDirection(DcMotorSimple.Direction.FORWARD);
        motorShooter.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();


        while (opModeIsActive()) {

            if (gamepad2.y && !yState && motorShooter.getPower() == 0) {
                motorShooter.setPower(LAUNCH);
            } else if (gamepad2.y && !yState && motorShooter.getPower() != 0) {
                motorShooter.setPower(0);
            }
            yState = gamepad2.y;



            if (gamepad2.x) {
                leftServo.setPower(1);
                rightServo.setPower(1);
            } else {
                leftServo.setPower(0);
                rightServo.setPower(0);
            }


            main = -gamepad1.left_stick_y;
            rotation = (gamepad1.left_trigger - gamepad1.right_trigger);
            side = gamepad1.left_stick_x;
            setPowers(main,side,rotation);


            if (gamepad1.x && multiplier == 1 && !xState) {
                multiplier = 0.5;
            } else if (gamepad1.x && multiplier == 0.5 && !xState) {
                multiplier = 1;
            }
            xState = gamepad1.x;

        }

    }


    public void setPowers(double main, double side, double rotation) {
        leftFront.setPower((main + side + rotation) * multiplier);
        leftBack.setPower((main - side + rotation) * multiplier);
        rightFront.setPower((main - side - rotation) * multiplier);
        rightBack.setPower((main + side - rotation) * multiplier);


    }



}


