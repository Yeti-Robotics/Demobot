package org.usfirst.frc.team3506.robot.commands.catapult;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateRollersCommand extends Command {

    public OperateRollersCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.catapultSubsystem); //!
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.rollersOn){
			if(Robot.rollerDirection){
				Robot.catapultSubsystem.activateRollers();
			} else{
				Robot.catapultSubsystem.reverseRollers();
			}
			
		}else{
			Robot.catapultSubsystem.deactivateRollers();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
