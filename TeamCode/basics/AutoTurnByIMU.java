


package org.firstinspires.ftc.teamcode.basics;


import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@Autonomous(name="Ksusha: Auto Tern IMU", group="Robot")
public class AutoTurnByIMU extends LinearOpMode {


    /* Declare OpMode members. */
    private DcMotor leftBack;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private DcMotor rightFront;
    private IMU imu;


    @Override
    public void runOpMode() {


        // Initialize the drive system variables.
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        RevHubOrientationOnRobot.UsbFacingDirection usbDirection = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(orientationOnRobot));


        imu.resetYaw();


        waitForStart();
        //по часовой
        leftBack.setPower(0.3);
        leftFront.setPower(0.3);
        rightBack.setPower(-0.3);
        rightFront.setPower(-0.3);

        while (opModeIsActive() && getHeading() > -90)   {
            telemetry.addData("по часовой<", getHeading());
            telemetry.update();
        }
        leftBack.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);
        sleep(3000);



        //против часовой
        leftBack.setPower(-0.3);
        leftFront.setPower(-0.3);
        rightBack.setPower(0.3);
        rightFront.setPower(0.3);

        while (opModeIsActive() && getHeading() < 0) {
            telemetry.addData("против часовой>", getHeading());
            telemetry.update();
        }

        leftBack.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);

    }

    public double getHeading() {
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
      return orientation.getYaw(AngleUnit.DEGREES);
    }

}
