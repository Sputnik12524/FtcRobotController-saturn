package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Georgii Tele Op Mecanum", group = "Robot")
public class TeleOpMecanum extends LinearOpMode {

    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor Shooter;
    private CRServo leftServo;
    private CRServo rightServo;
    public static double LAUNCH = 0.6;
    public double multiplier = 1;
    boolean xState = false;
    boolean yState = false;

    @Override
    public void runOpMode() {
        double main;
        double rotation;
        double side;

        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        Shooter = hardwareMap.get(DcMotor.class, "shooter");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");

        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftServo.setDirection(DcMotorSimple.Direction.REVERSE);
        Shooter.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad2.y && !yState && Shooter.getPower() == 0) {
                Shooter.setPower(LAUNCH);
            }
            else if(gamepad2.y && !yState && Shooter.getPower() != 0) {
                Shooter.setPower(0);
            }

            if (gamepad2.x) {
                leftServo.setPower(1);
                rightServo.setPower(1);
            } else {
                leftServo.setPower(0);
                rightServo.setPower(0);
            }

            side = gamepad1.left_stick_x;
            main = -gamepad1.left_stick_y;
            rotation = (gamepad1.left_trigger - gamepad1.right_trigger);
            setPowers(main, side, rotation);

            if (gamepad1.x && multiplier == 1 && !xState) {
                multiplier = 0.5;
            } else if (gamepad1.x && multiplier == 0.5 && !xState) {
                multiplier = 1;
            }
            xState = gamepad1.x;
            yState = gamepad2.y;
        }
    }

    public void setPowers(double main, double side, double rotation) {
        leftBack.setPower((main - side + rotation) * multiplier);
        rightBack.setPower((main + side - rotation) * multiplier);
        leftFront.setPower((main + side + rotation) * multiplier);
        rightFront.setPower((main - side - rotation) * multiplier);
    }

}