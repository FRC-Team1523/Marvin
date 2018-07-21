package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class JoystickDrive extends Command {
    public JoystickDrive() {
        requires(Robot.drive);
    }

    @Override
    protected void execute() {
        Robot.drive.drive(Robot.oi.joystick);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
