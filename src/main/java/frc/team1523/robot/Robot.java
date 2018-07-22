package frc.team1523.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.subsystems.Drive;


public class Robot extends IterativeRobot {
    public static OI oi;
    public static Drive drive;
    public static PowerDistributionPanel pdp;
    public static AHRS ahrs ;

    @Override
    public void robotInit() {
        oi = new OI();
        drive = new Drive();
        pdp = new PowerDistributionPanel(RobotMap.PDP_ID);
        ahrs = new AHRS(SPI.Port.kMXP);

        SmartDashboard.putData(pdp);
        SmartDashboard.putData(ahrs);
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
    }
}