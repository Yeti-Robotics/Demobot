/**
 * 
 */
package org.usfirst.frc.team3506.robot.subsystems;

import static org.usfirst.frc.team3506.robot.RobotMap.*;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drive.UserDriveCommand;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author acampbell
 *
 */
public class DriveSubsystem extends Subsystem {

	private RobotDrive mecanumDrive;
	private Gyro gyro;

	public DriveSubsystem() {
		gyro = Robot.SensorSubsystem.getGyro();
		mecanumDrive = new RobotDrive(LEFT_FRONT_PORT, LEFT_BACK_PORT, RIGHT_FRONT_PORT,
				RIGHT_BACK_PORT);
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
		mecanumDrive.mecanumDrive_Cartesian(
			(Robot.oi.getGamepadLeftX() * RobotMap.JOYSTICK_NORMAL_MOD),
			-(Robot.oi.getGamepadLeftY() * RobotMap.JOYSTICK_NORMAL_MOD),
			-(Robot.oi.getGamepadRightX() * RobotMap.JOYSTICK_NORMAL_MOD),
			gyro.getAngle());
		resetGyro();
	}
	
	public void userSafeDrive() {
		mecanumDrive.mecanumDrive_Cartesian(
			(Robot.oi.getGamepadLeftX() * RobotMap.JOYSTICK_SAFE_MOD),
			-(Robot.oi.getGamepadLeftY() * RobotMap.JOYSTICK_SAFE_MOD),
			-(Robot.oi.getGamepadRightX() * RobotMap.JOYSTICK_SAFE_MOD),
			gyro.getAngle());\
		resetGyro();
	}

	public void automatedDrive(double x, double y, double rotation) {
		mecanumDrive.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
	}

	public void rightTurn() {
		mecanumDrive.mecanumDrive_Cartesian(0, 0, TURN_RIGHT_SPEED, gyro.getAngle());
	}

	public void leftTurn() {
		mecanumDrive.mecanumDrive_Cartesian(0, 0, TURN_LEFT_SPEED, gyro.getAngle());
	}

	public void driveStraight() {
		mecanumDrive.mecanumDrive_Cartesian(0, FORWARD_SPEED, 0, gyro.getAngle());

		resetGyro();
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
