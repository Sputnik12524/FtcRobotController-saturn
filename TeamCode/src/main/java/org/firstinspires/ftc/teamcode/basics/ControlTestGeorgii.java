package org.firstinspires.ftc.teamcode.basics;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Georgii control test", group = "Robot")
public class ControlTestGeorgii extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;

    static final double PULSES = 537.7;
    static final double DIAMETR = 9.6;
    static final double CM = PULSES / (Math.PI * DIAMETR);
    static final double SPEEDBack = 0.5;
    static final double SPEEDFovard = 0.8;

    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        driveFovard(SPEEDBack, 10);
        sleep(3000);
        driveBack(SPEEDFovard, 15);
    }

    public void driveBack(double Power, double distant) {
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Back", leftFront.getCurrentPosition());
        telemetry.addData("Back", rightFront.getCurrentPosition());
        telemetry.addData("Back", leftBack.getCurrentPosition());
        telemetry.addData("Back", rightBack.getCurrentPosition());
        telemetry.update();

        leftFront.setPower(-Power);
        rightFront.setPower(-Power);
        leftBack.setPower(-Power);
        rightBack.setPower(-Power);

        while (opModeIsActive() && rightFront.getCurrentPosition() > -distant * CM) ;
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
    }

    public void driveFovard(double power, double distant) {
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Fovard", leftFront.getCurrentPosition());
        telemetry.addData("Fovard", rightFront.getCurrentPosition());
        telemetry.addData("Fovard", leftBack.getCurrentPosition());
        telemetry.addData("Fovard", rightBack.getCurrentPosition());
        telemetry.update();

        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while (opModeIsActive() && rightFront.getCurrentPosition() > distant * CM) ;

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
    }
}
