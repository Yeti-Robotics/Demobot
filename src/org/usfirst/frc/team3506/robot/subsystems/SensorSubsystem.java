package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SensorSubsystem extends Subsystem {

	private Gyro gyro;
	//private Encoder leftFrontEncoder;

	public SensorSubsystem() {
		gyro = new Gyro(RobotMap.GYRO_PORT);
		//leftFrontEncoder = new Encoder(1, 2);
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
	/*
	public Encoder getEncoder() {
		return leftFrontEncoder;
	}

	public void resetEncoder(){
    	leftFrontEncoder.reset();
    }
	*/
	public void resetAll(){
		resetGyro();
		//resetEncoder();
	}

	public void log() {
		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
		SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
		SmartDashboard.putData("Gyro", gyro);
		//SmartDashboard.putData("Encoder", leftFrontEncoder);
	}
}
