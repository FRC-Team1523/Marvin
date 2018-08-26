package frc.team1523.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import static frc.team1523.robot.RobotMap.*;

public class OI {
    // Define your operator interface variables here
    public Joystick joystick = new Joystick(JOYSTICK_USB_PORT);
    public XboxController xbox = new XboxController(XBOX_USB_PORT);

}
