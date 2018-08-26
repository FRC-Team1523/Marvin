package frc.team1523.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.JoystickDrive;
import frc.team1523.robot.commands.LiftControl;

public class Lift extends Subsystem {
    private WPI_TalonSRX liftMaster = new WPI_TalonSRX(2);
    private WPI_TalonSRX liftFollow1 = new WPI_TalonSRX(3);
    private WPI_TalonSRX liftFollow2 = new WPI_TalonSRX(4);

    public Lift() {
        liftFollow1.follow(liftMaster);
        liftFollow2.follow(liftMaster);
    }

    public void setSpeed(double speed) {
        liftMaster.set(speed);
    }


    /**
     * By default drive with the gamepad
     */
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new LiftControl());
    }
}
