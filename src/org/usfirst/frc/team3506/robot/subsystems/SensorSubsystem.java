package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SensorSubsystem extends Subsystem {

	Gyro gyro;
	Encoder leftFrontEncoder;
	Encoder extraneousEncoder;
	AnalogInput sonar;

	public SensorSubsystem() {
		gyro = new Gyro(1);
		leftFrontEncoder = new Encoder(RobotMap.LEFT_FRONT_ENC1, RobotMap.LEFT_FRONT_ENC2);
		leftFrontEncoder.setDistancePerPulse(RobotMap.DIST_PER_PULSE); //In feet
		//leftFrontEncoder.setReverseDirection(true);
		extraneousEncoder = new Encoder(3, 4);
		sonar = new AnalogInput(0);
	}

	public void initDefaultCommand() {
		// Nothing to do here
	}

	public Gyro getGyro() {
		return gyro;
	}

	public void resetGyro() {
		gyro.reset();
	}

	public Encoder getLeftFrontEncoder() {
		return leftFrontEncoder;
	}

	public void resetLeftFrontEncoder(){
    	leftFrontEncoder.reset();
    }
	
	public Encoder getExtraneousEncoder(){
		return extraneousEncoder;
	}
	
	
	
	public void resetAll(){
		resetGyro();
		resetLeftFrontEncoder();
	}

	public void log() {
		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
		SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
		SmartDashboard.putData("Gyro", gyro);
		SmartDashboard.putData("Encoder", leftFrontEncoder);
		SmartDashboard.putNumber("Sonar", sonar.getVoltage());
	}
}
