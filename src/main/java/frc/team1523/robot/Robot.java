package frc.team1523.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.subsystems.*;


public class Robot extends IterativeRobot {
    public static OI oi;
    public static Encoders encoders;
    public static Drive drive;
    public static Lift lift;
    public static Grabber grabber;
    public static Intake intake;
    public static PowerDistributionPanel pdp = new PowerDistributionPanel(RobotMap.PDP_ID);
    private static Compressor compressor = new Compressor(1);
    public static AHRS ahrs = new AHRS(SPI.Port.kMXP);

    @Override
    public void robotInit() {
        oi = new OI();
        encoders = new Encoders();
        drive = new Drive();
        lift = new Lift();
        grabber = new Grabber();
        intake = new Intake();

        compressor.setClosedLoopControl(true);

        lift.enable();

        SmartDashboard.putData(pdp);
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("AHRS angle", ahrs.getAngle());
        SmartDashboard.putNumber("AHRS yaw", ahrs.getYaw());
        SmartDashboard.putNumber("Encoder", encoders.liftEncoder.get());
        if (oi.joystick.getRawButtonPressed(8)) {
            lift.setSetpoint(0);
        } else if (oi.joystick.getRawButtonPressed(9)) {
            lift.setSetpoint(2580*.5);
        } else if (oi.joystick.getRawButtonPressed(10)) {
            lift.setSetpoint(2580);
        }
    }
}