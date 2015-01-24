package org.usfirst.frc.team3506.robot.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.domain.OldRobotInput;
import org.usfirst.frc.team3506.robot.domain.RobotInput;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class LoadRecordingCommand extends Command {
	int count = 0;
	RobotInput testLeftButton3;

	public LoadRecordingCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@SuppressWarnings("unchecked")
	protected void initialize() {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(
					"input.txt"));
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			Robot.inputs = (List<OldRobotInput>) objectInputStream.readObject();
			Robot.robotInputs = (List<RobotInput>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = 0;
		Robot.playing = true;
		testLeftButton3 = new RobotInput(RobotMap.LEFT_JOYSTICK, 3, new Piston2ForwardCommand());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if (count < Robot.inputs.size()) {
			Robot.input = Robot.inputs.get(count);
			Robot.drive.userDrive();
			/*if (Robot.input.isLeftButtonState3()) {
				Scheduler.getInstance().add(new Piston2ForwardCommand());
			}*/
			if (Robot.input.isRightButtonState3()) {
				Scheduler.getInstance().add(new Piston1ForwardCommand());
			}
			if (Robot.input.isRightButtonState2()) {
				Scheduler.getInstance().add(new Piston1ReverseCommand());
			}
			testLeftButton3.recordButtonState();
			if (Robot.input.isLeftButtonState3()) {
			Scheduler.getInstance().add(new Piston2ForwardCommand());
			}
			
		} else {
			System.out.println("ERROR: list should have something in it:");
		}
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
