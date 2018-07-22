package frc.team1523.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.JoystickDrive;

public class Drive extends Subsystem {

    private WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.DRIVE_TALON_LEFT_MASTER);
    private WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.DRIVE_TALON_LEFT_SLAVE);
    private WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.DRIVE_TALON_LEFT_SLAVE);
    private WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.DRIVE_TALON_RIGHT_SLAVE);

    private DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

    /**
     * Class that handles the drive mechanisms
     */
    public Drive() {
        //For mecanum drive one of the sides has to be inverted for it to drive straight it will not always be thr left side
        leftSlave.follow(leftMaster);

        rightSlave.follow(rightMaster);
        rightMaster.setInverted(true);
        rightSlave.setInverted(true);
    }

    /**
     * Use joystick object to control mecanum drive system
     *
     * @param stick Joystick Object
     */
    public void drive(Joystick stick) {
        this.drive(stick.getY(), -stick.getZ(), true);
    }

    /**
     * Raw control inputs to drive train
     *
     * @param speed    Forward speed
     * @param rotation Turn speed
     * @param square   Whether or not to square input values
     */
    public void drive(double speed, double rotation, boolean square) {
        drive.arcadeDrive(speed, rotation, square);
    }


    /**
     * By default drive with the joystick
     */
    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
}
