package org.usfirst.frc.team3506.robot.commands.drive;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnLeftCommand extends Command {
	
	Gyro gyro;

	public TurnLeftCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
		requires(Robot.SensorSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.SensorSubsystem.resetGyro();
		gyro = Robot.SensorSubsystem.getGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.leftTurn();
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
