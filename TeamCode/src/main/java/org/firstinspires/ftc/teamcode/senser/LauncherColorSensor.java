package org.firstinspires.ftc.teamcode.senser;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class LauncherColorSensor extends LinearOpMode {
    LauncherColorSensor colorSensor;
    public void runOpMode() {
        colorSensor= new LauncherColorSensor();
        colorSensor.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("White", colorSensor.getWhiteLine());
            telemetry.addData("Black, Red, Blue", colorSensor.getCoroledLine());
            telemetry.update();
        }
    }
}


{
}
