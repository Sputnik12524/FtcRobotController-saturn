package org.firstinspires.ftc.teamcode.MINSK;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Auto Short Zone", group="Robot")
public class AutoShortZone extends LinearOpMode {


    /* Declare OpMode members. */
    private DcMotor         leftBack   ;
    private DcMotor         rightFront  ;
    private DcMotor         leftFront  ;
    private DcMotor         rightBack  ;


    static final double PULSES=537.7;
    static final double WHEEL_DIAMETR=9.6;
    static final double PULSES_PER_CM=PULSES/(Math.PI*WHEEL_DIAMETR);
    static final double SPEED=0.5;




    @Override
    public void runOpMode() {


        // Initialize the drive system variables.
        leftBack  = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftFront  = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");




        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);


        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        telemetry.addData("Starting at", leftBack.getCurrentPosition());
        telemetry.addData("Starting at", rightFront.getCurrentPosition());
        telemetry.addData("Starting at", leftFront.getCurrentPosition());
        telemetry.addData("Starting at", leftFront.getCurrentPosition());
        telemetry.update();




        waitForStart();


        leftFront.setPower(SPEED);
        rightFront.setPower(SPEED);
        leftBack.setPower(SPEED);
        rightBack.setPower(SPEED);


        while (opModeIsActive() && leftBack.getCurrentPosition() <120 * PULSES_PER_CM){


            telemetry.addData("Starting at", leftBack.getCurrentPosition());
            telemetry.addData("Starting at", rightFront.getCurrentPosition());
            telemetry.addData("Starting at", leftFront.getCurrentPosition());
            telemetry.addData("Starting at", leftFront.getCurrentPosition());
            telemetry.update();
        }


        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);


        sleep(1000);


    }
}
