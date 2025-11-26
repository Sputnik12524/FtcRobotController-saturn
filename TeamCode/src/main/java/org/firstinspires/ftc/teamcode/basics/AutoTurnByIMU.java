/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.basics;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@Autonomous(name = "Zhenya Turn By IMU", group = "Robot")
public class AutoTurnByIMU extends LinearOpMode {


    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor shooter;

    private CRServo leftServo;
    private CRServo rightServo;
    public static double LAUNCH = 0.6;




    static final double PULSES = 537.7;
    static final double WHEEL_DIAMETR = 9.6;
    static final double PULSES_PER_CM = PULSES / (Math.PI * WHEEL_DIAMETR);
    static final double SPEED = 0.5;


    @Override
    public void runOpMode() {


        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");


        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftServo.setDirection(DcMotorSimple.Direction.REVERSE);
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


        leftFront.setPower(-SPEED);
        rightFront.setPower(-SPEED);
        leftBack.setPower(-SPEED);
        rightBack.setPower(-SPEED);


        while (opModeIsActive() && leftBack.getCurrentPosition() > -50 * PULSES_PER_CM) {
            telemetry.addData("вперед", leftFront.getCurrentPosition());
            telemetry.addData("вперед", rightFront.getCurrentPosition());
            telemetry.addData("вперед", leftBack.getCurrentPosition());
            telemetry.addData("вперед", rightBack.getCurrentPosition());
            telemetry.update();
        }
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);






        shooter.setPower(LAUNCH);


        sleep(4000);
        //первый шар
        leftServo.setPower(1);
        rightServo.setPower(1);


        sleep(250);


        leftServo.setPower(0);
        rightServo.setPower(0);


        sleep(4000);


        //второй шар
        leftServo.setPower(1);
        rightServo.setPower(1);


        sleep(180);


        leftServo.setPower(0);
        rightServo.setPower(0);


        shooter.setPower(LAUNCH);


        sleep(4000);


        //третий шар
        leftServo.setPower(1);
        rightServo.setPower(1);


        sleep(250);


        leftServo.setPower(0);
        rightServo.setPower(0);


        sleep(1000);


        //четвёртый шар
        leftServo.setPower(1);
        rightServo.setPower(1);


        sleep(250);


        leftServo.setPower(0);
        rightServo.setPower(0);


        sleep(4000);


        shooter.setPower(0);
    }
}
