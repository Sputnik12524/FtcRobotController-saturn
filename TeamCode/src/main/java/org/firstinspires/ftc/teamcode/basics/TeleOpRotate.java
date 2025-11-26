package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp (name="Zhenya TeleOp Rotate", group="Robot")
public class TeleOpRotate extends LinearOpMode {

    /* Declare OpMode members. */
    private DcMotor         leftBack   ;
    private DcMotor         rightFront  ;
    private DcMotor         leftFront  ;
    private DcMotor         rightBack  ;



    @Override
    public void runOpMode() {
        double main;
        double rotation;

        leftBack  = hardwareMap.get(DcMotor.class, "leftFront_Zhenya");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront_Zhenya");
        leftFront  = hardwareMap.get(DcMotor.class, "leftBack_Zhenya");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack_Zhenya");


        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);


        waitForStart();

        while (opModeIsActive()) {
            main = -gamepad1.left_stick_y;
            rotation= -gamepad1.right_stick_x;

            leftFront.setPower(main - rotation * 0.5);
            rightFront.setPower(main + rotation * 0.5);
            leftBack.setPower(main - rotation * 0.5);
            rightBack.setPower(main + rotation * 0.5);

        }

    }
}
