package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CatapultSubsystem extends Subsystem {
    DoubleSolenoid catapultPiston;
    Talon catapultTalon;
    
    public CatapultSubsystem() {
    	catapultPiston = new DoubleSolenoid(RobotMap.CATAPULT_SOLENOID[0], RobotMap.CATAPULT_SOLENOID[1]);
    	catapultTalon = new Talon(RobotMap.CATAPULT_TALON_PORT);
    }
	
    public void extendPiston() {
    	catapultPiston.set(Value.kForward);
    }
    
    public void retractPiston() {
    	catapultPiston.set(Value.kReverse);
    }
    
    public void activateRollers() {
    	catapultTalon.set(RobotMap.CATAPULT_ROLLER_SPEED);
    }
    
    public void deactivateRollers() {
    	catapultTalon.set(0.0);
    }
    
    public void initDefaultCommand() {
    }
}

