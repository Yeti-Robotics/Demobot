package org.usfirst.frc.team3506.robot.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.domain.RobotInput;

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
    @SuppressWarnings("unchecked")
	protected void initialize() {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("input.txt"));
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Robot.inputs = (List<RobotInput>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			Robot.inputs.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = 0;
		Robot.playing = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.input = Robot.inputs.get(count);
    		Robot.drive.userDrive();
    		count++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return count >= Robot.inputs.size();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.playing = false;
    		Robot.inputs.clear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
