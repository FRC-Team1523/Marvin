package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.IntakeCommand;

import static frc.team1523.robot.RobotMap.INTAKE_MOTOR_1;
import static frc.team1523.robot.RobotMap.INTAKE_MOTOR_2;

public class Intake extends Subsystem {
    private Spark intakeMotor1 = new Spark(INTAKE_MOTOR_1);
    private Spark intakeMotor2 = new Spark(INTAKE_MOTOR_2);

    public Intake() {
        intakeMotor2.setInverted(true);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new IntakeCommand());
    }

    public void setSpeed(double value) {
        intakeMotor1.set(value);
        intakeMotor2.set(value);
    }

    public void setLeft(double value) {
        intakeMotor1.set(value);
    }

    public void setRight(double value) {
        intakeMotor2.set(value);
    }
}
