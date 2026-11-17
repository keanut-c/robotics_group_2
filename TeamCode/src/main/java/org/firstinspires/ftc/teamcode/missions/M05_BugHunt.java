package org.firstinspires.ftc.teamcode.missions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/*
 * MISSION 5 - Bug Hunt
 * Goal: drive straight ahead and STOP inside the blue box.
 *
 * This program has THREE bugs. Run it, read what the simulator tells you, fix one bug,
 * and run it again. Repeat until the mission is complete.
 *
 * Rule for this mission: the robot must NOT move before START is pressed.
 */

@Autonomous(name = "M05 Bug Hunt", group = "Missions")
public class M05_BugHunt extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Ready to go!");
        telemetry.update();

        waitForStart();

        // Drive forward
        leftDrive.setPower(1);
        rightDrive.setPower(1);
        sleep(1600);

        // Stop
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}
