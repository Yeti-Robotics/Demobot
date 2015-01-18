package org.usfirst.frc.team3506.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static org.usfirst.frc.team3506.robot.RobotMap.*;

/**
 *
 */
public class Solenoid2Subsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	DoubleSolenoid solenoid2;
	DigitalInput limitSwitch;

	public Solenoid2Subsystem() {
		solenoid2 = new DoubleSolenoid(PCM_ID_NUMBER, SOLENOID_2_FORWARD,
				SOLENOID_2_REVERSE);
		limitSwitch = new DigitalInput(LIMIT_SWITCH_1);
	}

	public void solenoidForward() {
		if (!limitSwitch.get()) {
			solenoid2.set(Value.kForward);
		} else {
			solenoid2.set(Value.kReverse);
		}
	}

	public boolean isLimitReached() {
		return limitSwitch.get();
	}
	
	public void solenoidReverse() {
		solenoid2.set(Value.kReverse);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void log() {
		SmartDashboard.putData("Limit Switch:", limitSwitch);
	}
}
