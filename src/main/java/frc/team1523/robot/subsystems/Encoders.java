package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Encoders extends Subsystem {
    public Encoder liftEncoder = new Encoder(0, 1);

    @Override
    public void initDefaultCommand() {

    }
}
