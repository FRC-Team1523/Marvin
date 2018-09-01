package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;
import frc.team1523.robot.Utilities;

public class LiftControl extends Command {
    public LiftControl(){
        requires(Robot.lift);
    }

    @Override
    protected void execute() {
//        double squared = Utilities.signedSqrt(Robot.oi.xbox.getY(GenericHID.Hand.kLeft));
//        Robot.lift.setSetpoint(Robot.oi.xbox.getY(GenericHID.Hand.kLeft)*2580);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
