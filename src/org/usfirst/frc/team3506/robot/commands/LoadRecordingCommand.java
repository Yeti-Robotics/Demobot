package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadRecordingCommand extends Command {
	int count = 0;

	public LoadRecordingCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		count = 0;
		Robot.playing = true;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (count < Robot.inputs.size()) {
			Robot.input = Robot.inputs.get(count);
			System.out.println(Robot.input);
			Robot.drive.userDrive();
			Robot.input.executeButtonCommand(true, 10, new ChangeLightSpeedCommand());
			Robot.input.executeButtonCommand(true, 4, new ToggleLightsCommand());
		}
		count++;
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println("Finished Condition: " + (count >= Robot.inputs.size()));
		return count >= Robot.inputs.size();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.playing = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
