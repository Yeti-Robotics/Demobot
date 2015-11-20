package org.usfirst.frc.team3506.robot.commands.drive;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightCommand extends Command {

	double timeout;

	public DriveStraightCommand(double timeout) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
		this.timeout = timeout;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(timeout);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.driveStraight();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
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
