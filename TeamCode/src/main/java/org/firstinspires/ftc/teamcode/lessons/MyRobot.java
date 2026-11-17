package org.firstinspires.ftc.teamcode.lessons;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// Imports you will probably need. Delete the // in front of each one when you use it.
// (Or type the class name and press Alt+Enter, or Option+Return on a Mac: Android Studio adds the import for you.)
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.TouchSensor;
// import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
// import com.qualcomm.robotcore.util.ElapsedTime;

/*
 * LESSON 18 - YOUR robot class.
 *
 * This file is almost empty on purpose. You decide what goes in it.
 * It describes YOUR robot: its devices (fields) and its skills (methods).
 * Lesson 18, Part 2 has a checklist. RobotHardware.java (Lessons 15 and 16) is a good example.
 *
 * Like RobotHardware, this file has no @TeleOp or @Autonomous. It isn't a program you run.
 * Your Grand Challenge program builds one of these and tells it what to do.
 */
public class MyRobot {
    // The program that is using this robot. It gives you hardwareMap, telemetry, and opModeIsActive().
    private final LinearOpMode opMode;

    // ---------- 1. DEVICES: one private field for each device in YOUR configuration ----------


    public MyRobot(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    /** 2. INIT: find every device with opMode.hardwareMap.get(...), using YOUR configuration's names. */
    public void init() {

    }

    // ---------- 3. SKILLS: one method for each thing your robot can do ----------
    @TeleOp(name = "M06 Drive It Yourself", group = "Missions")
    public class M06_DriveItYourself extends LinearOpMode {

        @Override
        public void runOpMode() {
            DcMotor ULDrive = hardwareMap.get(DcMotor.class, "UL_drive");
            DcMotor URDrive = hardwareMap.get(DcMotor.class, "UR_drive");
            DcMotor BLDrive = hardwareMap.get(DcMotor.class, "BL_drive");
            DcMotor BRDrive = hardwareMap.get(DcMotor.class, "BR_drive");
            URDrive.setDirection(DcMotor.Direction.REVERSE);
            BLDrive.setDirection(DcMotor.Direction.REVERSE);

            double maxSpeed = 0.6;

            waitForStart();

            // Everything inside this loop runs over and over, many times a second, until STOP.
            while (opModeIsActive()) {
                // Pushing a stick UP gives a NEGATIVE number, so we flip it with a minus sign.
                double ULPower = (-gamepad1.left_stick_y + gamepad1.left_stick_x) * maxSpeed;
                double URPower = (-gamepad1.left_stick_y + gamepad1.left_stick_x) * maxSpeed;
                double BLPower = (-gamepad1.left_stick_y - gamepad1.left_stick_x) * maxSpeed;
                double BRPower = (-gamepad1.left_stick_y - gamepad1.left_stick_x) * maxSpeed;

                ULDrive.setPower(ULPower);
                URDrive.setPower(URPower);
                BLDrive.setPower(BLPower);
                BRDrive.setPower(BRPower);

                telemetry.addData("front left power", ULPower);
                telemetry.addData("front right power", URPower);
                telemetry.addData("back left power", BLPower);
                telemetry.addData("back right power", BRPower);
                telemetry.update();
            }
        }
    }
}
