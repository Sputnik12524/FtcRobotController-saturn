package org.firstinspires.ftc.teamcode.basics;




import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name = "Zhenya Auto 3 Artifacts", group = "Robot")
@Config
public class Auto3Artifacts extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor shooter;
    private CRServo leftServo;
    private CRServo rightServo;
    private DcMotor inteke;
    public static double LAUNCH = 0.5;




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
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");
        inteke = hardwareMap.get(DcMotor.class, "intake");




        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftServo.setDirection(CRServo.Direction.REVERSE);
        shooter.setDirection(DcMotor.Direction.REVERSE);
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




        waitForStart();


        driveBack(SPEED,35);


        shooter.setPower(LAUNCH);
        sleep(8000);




        //первый шар
        leftServo.setPower(-1);
        sleep(5000);


        //второй шар
        rightServo.setPower(-1);
        sleep(3000);


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
        shooter.setPower(0);
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


}