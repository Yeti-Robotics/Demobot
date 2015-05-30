package org.usfirst.frc.team3506.robot;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.usfirst.frc.team3506.robot.commands.drive.UserDriveCommand;
import org.usfirst.frc.team3506.robot.subsystems.CatapultSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.SensorSubsystem;

import domain.RobotInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSubsystem drive;
	public static SensorSubsystem SensorSubsystem;
	public static boolean recording;
	public static boolean playing;
	public static List<RobotInput> inputs = new ArrayList<RobotInput>();
	public static RobotInput input;
	public static boolean safeSpeed;
	public static CompressorSubsystem compressorSubsystem;
	public static CatapultSubsystem catapultSubsystem;
	

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		SensorSubsystem = new SensorSubsystem();
		drive = new DriveSubsystem();
		recording = false;
		playing = false;
		safeSpeed = false;
		compressorSubsystem = new CompressorSubsystem();
		catapultSubsystem = new CatapultSubsystem();
		
		// oi should be last
		oi = new OI();

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		new UserDriveCommand().start();

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
		if(!playing){
			input = new RobotInput();
			input.setButtonState(1, oi.getGamepad());
			input.setLeftX(oi.getGamepadLeftX());
			input.setLeftY(oi.getGamepadLeftY());
			input.setRotation(oi.getGamepadRightX());
		}
		
		if(recording){
			inputs.add(input);
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
		log();
	}

	private void log() {
		drive.log();
		SensorSubsystem.log();
	}
}
