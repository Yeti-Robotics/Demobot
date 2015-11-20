/**
 * 
 */
package org.usfirst.frc.team3506.robot.commands.drive;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author acampbell
 *
 */
public class UserDriveCommand extends Command {

	public UserDriveCommand() {
		requires(Robot.drive);
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#initialize()
	 */
	@Override
	protected void initialize() {

	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#execute()
	 */
	@Override
	protected void execute() {
		if(!Robot.safeSpeed){
			Robot.drive.userDrive();
		} else{
			Robot.drive.safeDrive();
		}
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

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#end()
	 */
	@Override
	protected void end() {
		Robot.drive.abort();
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#interrupted()
	 */
	@Override
	protected void interrupted() {
		end();
	}

}
