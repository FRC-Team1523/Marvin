package frc.team1523.robot.commands;

import frc.team1523.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class GrabCommand extends Command {
    public GrabCommand() {
        requires(Robot.grabber);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.xbox.getBButtonPressed()) {
            Robot.grabber.grab();
        } else if (Robot.oi.xbox.getXButtonPressed()) {
            Robot.grabber.release();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.grabber.cleanUp();
    }
}