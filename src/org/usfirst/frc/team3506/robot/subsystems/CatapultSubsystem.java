package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CatapultSubsystem extends Subsystem {

	DoubleSolenoid piston1;
	Talon catapultTalon;

	public CatapultSubsystem() {
		piston1 = new DoubleSolenoid(RobotMap.CATAPULT_SOLENOID_1_PORT[0],
				RobotMap.CATAPULT_SOLENOID_1_PORT[1]);
		catapultTalon = new Talon(RobotMap.CATAPULT_TALON_PORT);
	}

	public void initDefaultCommand() {

	}
}
