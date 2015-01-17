package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroSubsystem extends Subsystem {
    
    Gyro gyro;
    
    public GyroSubsystem() {
		gyro = new Gyro(RobotMap.GYRO_PORT);
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
    
    public void log() {
    		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
    		SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
    		SmartDashboard.putData("Gyro", gyro);
    }
}

