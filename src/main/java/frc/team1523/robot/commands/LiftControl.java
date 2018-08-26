package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class LiftControl extends Command {
    public LiftControl(){
        requires(Robot.lift);
    }

    @Override
    protected void execute() {
        Robot.lift.setSpeed(Robot.oi.xbox.getY(GenericHID.Hand.kLeft));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
