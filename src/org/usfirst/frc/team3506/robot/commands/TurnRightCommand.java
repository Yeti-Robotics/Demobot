package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnRightCommand extends Command {
	
	Gyro gyro;

	public TurnRightCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
		requires(Robot.gyroSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyroSubsystem.resetGyro();
		gyro = Robot.gyroSubsystem.getGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
			Robot.drive.rightTurn();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double angle = Math.abs(gyro.getAngle());
		return (angle >= RobotMap.TURN_STOP_ANGLE);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stopMotors();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
