package org.firstinspires.ftc.teamcode.lessons;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/*
 * LESSON 06 - Arcade Drive
 * Big idea: EXPRESSIONS. Combine variables with math to get the behavior you want.
 *
 * Left stick up/down = drive forward/back. Right stick left/right = turn.
 *   leftPower  = drive + turn
 *   rightPower = drive - turn
 * Try it on paper: what happens when drive = 1 and turn = 0? drive = 0 and turn = 1?
 *
 * ROBOT CONFIGURATION NEEDED: "left_drive" and "right_drive" (DC motors)
 */

@TeleOp(name = "L06 Arcade Drive", group = "Lessons")
 // Hides this ORIGINAL from the menu. Delete this line in YOUR copy so your copy shows up.
public class L06_ArcadeDrive extends LinearOpMode {

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
