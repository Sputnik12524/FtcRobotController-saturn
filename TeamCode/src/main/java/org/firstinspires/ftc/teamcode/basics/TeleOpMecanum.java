


package org.firstinspires.ftc.teamcode.basics;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "Ksusha: TeleOpMecanum", group = "Robot")
public class TeleOpMecanum extends LinearOpMode {


    private DcMotor leftBack;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private DcMotor rightFront;
    private DcMotor motorShooter;
    private CRServo leftServo;
    private CRServo rightServo;
    public static double LAUNCH = 0.6;
    public double multiplier =1;
 boolean xState = false;
 boolean yState = false;



    @Override
    public void runOpMode() {
        double main;
        double rotation;
        double side;

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        motorShooter = hardwareMap.get(DcMotor.class, "shooter");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftServo.setDirection(CRServo.Direction.REVERSE);
        leftServo.setDirection(CRServo.Direction.FORWARD);
        motorShooter.setDirection(CRServo.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
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


            if (gamepad2.y) {
                motorShooter.setPower(LAUNCH);
            } else {
                motorShooter.setPower(0);
            }
            if (gamepad2.x) {
                leftServo.setPower(1);
                rightServo.setPower(1);
            } else {
                rightServo.setPower(0);
                leftServo.setPower(0);
            }

            if (gamepad2.y && motorShooter.getPower() == 0 && !yState ) {
                motorShooter.setPower(LAUNCH);
            } else if (gamepad1.x && motorShooter.getPower() != 0 && !yState) {
            motorShooter.setPower(LAUNCH);

            }
            yState = gamepad2.y;

        }

    }

    public void setPowers( double main, double side, double rotation){
        leftFront.setPower((main - side + rotation) * multiplier);
        leftBack.setPower((main + side - rotation) * multiplier);
        rightFront.setPower((main + side + rotation) * multiplier);
        rightBack.setPower((main - side - rotation) * multiplier);

    }

}

