package org.usfirst.frc.team3506.robot.commands.recording;

import org.usfirst.frc.team3506.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RecordCommand extends Command {
	public RecordCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (!Robot.recording) {
			Robot.inputs.clear();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.recording = !Robot.recording;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}	
}
