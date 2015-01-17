package org.usfirst.frc.team3506.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team3506.robot.RobotMap.*;

/**
 *
 */
public class Solenoid1Subsystem extends Subsystem
{

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	DoubleSolenoid solenoid1;

	public Solenoid1Subsystem()
	{
		solenoid1 = new DoubleSolenoid(PCM_ID_NUMBER, SOLENOID_1_FORWARD,
				SOLENOID_1_REVERSE);
	}
	public void solenoidForward()
	{
		solenoid1.set(Value.kForward);
	}
	
	public void solenoidReverse()
	{
		solenoid1.set(Value.kReverse);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
