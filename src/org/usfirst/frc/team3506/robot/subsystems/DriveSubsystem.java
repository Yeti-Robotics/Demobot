/**
 * 
 */
package org.usfirst.frc.team3506.robot.subsystems;

import static org.usfirst.frc.team3506.robot.RobotMap.*;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.commands.UserDriveCommand;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author acampbell
 *
 */
public class DriveSubsystem extends Subsystem {

	RobotDrive mecanumDrive;
	Gyro gyro;

	public DriveSubsystem() {
		gyro = Robot.sensorBase.getGyro();
		mecanumDrive = new RobotDrive(LEFT_FRONT_PORT, LEFT_BACK_PORT,
				RIGHT_FRONT_PORT, RIGHT_BACK_PORT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
	}

	public void userDrive() {
		mecanumDrive.mecanumDrive_Cartesian(Robot.oi.getLeftX(),
				Robot.oi.getLeftY(), Robot.oi.getRightX(),
				gyro.getAngle());
		resetGyro();
	}

	public void rightTurn(double speed) {
			System.out.println("Current angle:\t"+gyro.getAngle());
			mecanumDrive.mecanumDrive_Cartesian(0, 0, speed, gyro.getAngle());
	}
	
	public void leftTurn(double speed) {
			System.out.println("Current angle:\t"+gyro.getAngle());
			mecanumDrive.mecanumDrive_Cartesian(0, 0, -speed, gyro.getAngle());
	}
	
	public void driveStraight(double speed) {
		mecanumDrive.mecanumDrive_Cartesian(0, -speed, 0, gyro.getAngle());
	}
	
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public void stopMotors() {
		mecanumDrive.stopMotor();
	}
	
	public void log() {
		
	}

}
