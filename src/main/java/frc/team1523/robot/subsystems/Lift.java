package frc.team1523.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.team1523.robot.Robot;
import frc.team1523.robot.commands.LiftControl;

public class Lift extends PIDSubsystem {
    private WPI_TalonSRX liftMaster = new WPI_TalonSRX(2);
    private WPI_TalonSRX liftFollow1 = new WPI_TalonSRX(3);
    private WPI_TalonSRX liftFollow2 = new WPI_TalonSRX(4);

    public Lift() {
        super(0.022, 0.0, 0.0);
        setAbsoluteTolerance(0.005);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(-.12, .5);
        liftFollow1.follow(liftMaster);
        liftFollow2.follow(liftMaster);
    }

    /**
     * By default drive with the gamepad
     */
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new LiftControl());
    }

    @Override
    protected double returnPIDInput() {
        // Encoders
        return Robot.encoders.liftEncoder.get();
    }

    @Override
    protected void usePIDOutput(double output) {
        liftMaster.set(output);
    }
}
