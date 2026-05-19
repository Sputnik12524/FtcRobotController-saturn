package org.firstinspires.ftc.teamcode.modules;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Intake {
    private DcMotor intake;
    private Servo middleServo;
    LinearOpMode opMode;
    public ElapsedTime time;
IntakeState state = IntakeState.STOP;
    public Intake(LinearOpMode opMode) {
        this.opMode = opMode;
        intake = opMode.hardwareMap.get(DcMotor.class, "intake");
time = new ElapsedTime();
time.reset();
        middleServo = opMode.hardwareMap.get(Servo.class, "middleServo");
        intake.setDirection(DcMotor.Direction.REVERSE);
    }

    public void rotateIn(double power) {

        intake.setPower(power);

    }

    public void rotateOut(double power) {

        intake.setPower(-power);
    }

    public void rotateStop(double power) {

        intake.setPower(0);
    }

    enum IntakeState {
        STOP, FRONT, BACK

    }
    public void intakeFSM() {
     switch (state){
         case STOP:
             intake.setPower(0);
             break;
         case BACK:
             intake.setPower(-1);
             break;
         case FRONT:
             intake.setPower(1);
             break;
     }

    }
    public void setState(IntakeState state)  {

        intake.setPower(0);

        if ( time.milliseconds () > 3000) {
            setState(IntakeState.FRONT);
        }
    }
}
