package org.usfirst.frc.team3506.robot.commands.recording;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import domain.RobotInput;
/**
 *
 */
public class LoadRecordingCommand extends Command {
	int count = 0;
	RobotInput previousInput = new RobotInput();
	List<RobotInput> localInputs;

    public LoadRecordingCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    @SuppressWarnings("unchecked")
    protected void initialize() {
    	count = 0;
		Robot.playing = true;
		try {
			File file = new File(RobotMap.COMMANDS_FILE);
			FileInputStream fs = new FileInputStream(file);
			ObjectInputStream os = new ObjectInputStream(fs);
			localInputs = (List<RobotInput>) os.readObject();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(count < Robot.inputs.size()){
    		Robot.input = Robot.inputs.get(count);
    		System.out.println(Robot.input);
    		Robot.drive.automatedDrive(Robot.input.getLeftX(), Robot.input.getLeftY(), Robot.input.getRotation());
    		if(!previousInput.getButtonState(1) && Robot.input.getButtonState(1)){
    			Scheduler.getInstance().add(RobotInput.commands[1-1]);
    		}
    	}
    	count++;
    	previousInput = Robot.input;
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
