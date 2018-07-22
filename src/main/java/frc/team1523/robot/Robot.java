package frc.team1523.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.subsystems.Drive;


public class Robot extends IterativeRobot {
    public static OI oi;
    public static Drive drive;
    public static PowerDistributionPanel pdp;

    @Override
    public void robotInit() {
        oi = new OI();
        drive = new Drive();
        pdp = new PowerDistributionPanel(RobotMap.PDP_ID);

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
    }
}