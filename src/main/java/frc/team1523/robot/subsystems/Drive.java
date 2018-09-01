package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.JoystickDrive;

public class Drive extends Subsystem {

    private Spark left = new Spark(RobotMap.DRIVE_SPARK_LEFT);
    private Spark right = new Spark(RobotMap.DRIVE_SPARK_RIGHT);

    private DifferentialDrive drive = new DifferentialDrive(left, right);

    /**
     * Class that handles the drive mechanisms
     */
    public Drive() {
        SmartDashboard.putData(drive);
    }

    /**
     * Use joystick object to control mecanum drive system
     *
     * @param stick Joystick Object
     */
    public void drive(Joystick stick) {
        this.drive(stick.getY(), stick.getZ(), true);
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
