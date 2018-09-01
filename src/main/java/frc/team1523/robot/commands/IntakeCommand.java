package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

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
                Robot.intake.setSpeed(squared(speed));
            } else {
                Robot.intake.setSpeed(0);
            }
        }
    }

    private double squared(double input) {
        // Make sure to keep the sign so the direction you input is not changed by squaring it
        if (input > 0) {
            return input * input;
        } else {
            return -(input * input);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}