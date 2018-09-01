package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;
import frc.team1523.robot.Utilities;

import static frc.team1523.robot.Constants.INTAKE_FULL_SPEED;

public class IntakeCommand extends Command {
    public IntakeCommand() {
        requires(Robot.intake);
    }

    /**
     * Called repeatedly as command is running
     */
    @Override
    protected void execute() {
        if (Robot.oi.joystick.getRawButton(1)) {
            Robot.intake.setSpeed(INTAKE_FULL_SPEED);
        } else if (Robot.oi.joystick.getRawButton(2)) {
            Robot.intake.setSpeed(-INTAKE_FULL_SPEED);
        } else {
            double speed = Robot.oi.xbox.getY(GenericHID.Hand.kLeft);
            if (Math.abs(speed) >= 0.03) {
                Robot.intake.setSpeed(Utilities.signedSqrt(speed));
            } else {
                Robot.intake.setSpeed(0);
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}