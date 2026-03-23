package org.firstinspires.ftc.teamcode.MINSK;




import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.VoltageSensor;


@Autonomous(name = " Auto 3 Artifacts pid", group = "Robot")
@Config
public class Auto3pid extends LinearOpMode {
    public static PIDFCoefficients MOTOR_PID = new PIDFCoefficients(10, 0, 9, 17);

    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotorEx motorShooter;
    private CRServo leftServo;
    private CRServo rightServo;
    private DcMotor inteke;

    private VoltageSensor batteryVoltageSensor;

    public static double LongLAUNCH =  -1110;




    static final double PULSES = 537.7;
    static final double WHEEL_DIAMETR = 9.6;
    static final double PULSES_PER_CM = PULSES / (Math.PI * WHEEL_DIAMETR);
    static final double SPEED = 0.55;




    @Override
    public void runOpMode() {




        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        motorShooter = hardwareMap.get(DcMotorEx.class, "shooter");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");
        inteke = hardwareMap.get(DcMotor.class, "intake");





        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftServo.setDirection(CRServo.Direction.REVERSE);
        motorShooter.setDirection(DcMotorEx.Direction.REVERSE);
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




        telemetry.addData("start", leftFront.getCurrentPosition());
        telemetry.addData("start", rightFront.getCurrentPosition());
        telemetry.addData("start", leftBack.getCurrentPosition());
        telemetry.addData("start", rightBack.getCurrentPosition());
        telemetry.update();


        motorShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        batteryVoltageSensor = hardwareMap.voltageSensor.iterator().next();
        setPIDFCoefficients(motorShooter, MOTOR_PID);

        waitForStart();


        driveBack(SPEED,25);



        motorShooter.setVelocity(LongLAUNCH);
        sleep(8000);




        //первый шар
        leftServo.setPower(-1);
        sleep(7000);


        //второй шар
        rightServo.setPower(-1);
        sleep(5000);


        //захват
        sleep(1500);
        inteke.setPower(1);
        sleep(4500);
        inteke.setPower(0);


        //третий шар
        rightServo.setPower(-1);
        sleep(3000);


        //стоп
        rightServo.setPower(0);
        leftServo.setPower(0);
        sleep(4000);
        motorShooter.setVelocity(0);

        telemetry.addLine("hi from fta");
    }


    public void  driveBack(double power, double distance) {


        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        leftFront.setPower(-power);
        rightFront.setPower(-power);
        leftBack.setPower(-power);
        rightBack.setPower(-power);


        while (opModeIsActive() && leftBack.getCurrentPosition() > -distance * PULSES_PER_CM) ;


        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);


    }
    private void setPIDFCoefficients (DcMotorEx motor, PIDFCoefficients coefficients){
        motor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(
                coefficients.p, coefficients.i, coefficients.d, coefficients.f * 12 / batteryVoltageSensor.getVoltage()
        ));

    }
}