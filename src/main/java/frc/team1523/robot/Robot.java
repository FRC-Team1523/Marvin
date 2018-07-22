package frc.team1523.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.subsystems.Drive;


public class Robot extends IterativeRobot {
    public static OI oi;
    public static Drive drive;
    public static PowerDistributionPanel pdp = new PowerDistributionPanel(RobotMap.PDP_ID);
    public static AHRS ahrs = new AHRS(SPI.Port.kMXP);

    @Override
    public void robotInit() {
        oi = new OI();
        drive = new Drive();

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
    }
}