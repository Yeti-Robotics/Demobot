package org.usfirst.frc.team3506.robot;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team3506.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3506.robot.commands.LoadRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.Piston1ForwardCommand;
import org.usfirst.frc.team3506.robot.commands.Piston1ReverseCommand;
import org.usfirst.frc.team3506.robot.commands.Piston2ForwardCommand;
import org.usfirst.frc.team3506.robot.commands.SaveRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.TestCommand;
import org.usfirst.frc.team3506.robot.commands.TestCommandGroup;
import org.usfirst.frc.team3506.robot.commands.TurnLeftCommand;
import org.usfirst.frc.team3506.robot.commands.TurnRightCommand;
import org.usfirst.frc.team3506.robot.commands.UserDriveCommand;
import org.usfirst.frc.team3506.robot.domain.OldRobotInput;
import org.usfirst.frc.team3506.robot.domain.RobotInput;
import org.usfirst.frc.team3506.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.SensorSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.Solenoid1Subsystem;
import org.usfirst.frc.team3506.robot.subsystems.Solenoid2Subsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static Solenoid1Subsystem solenoid1;
	public static Solenoid2Subsystem solenoid2;
	public static SensorSubsystem sensorBase;
	public static CompressorSubsystem compressor;
	public static List<OldRobotInput> inputs = new ArrayList<OldRobotInput>();
	public static OldRobotInput input;
	public static boolean recording = false;
	public static boolean playing = false;
//	public static RobotInput testLeftButton3;
	public static List<RobotInput> robotInputs = new ArrayList<RobotInput>();
	public static RobotInput testLeftButton3;
	public static RobotInput joystickInput;
	public static RobotInput testRightButton3;
	public static RobotInput testRightButton2;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		sensorBase = new SensorSubsystem();
		drive = new DriveSubsystem();
		solenoid1 = new Solenoid1Subsystem();
		solenoid2 = new Solenoid2Subsystem();
		compressor = new CompressorSubsystem();
		// this should be last
		oi = new OI();

		SmartDashboard.putData(new TurnRightCommand());
		SmartDashboard.putData(new TurnLeftCommand());
		SmartDashboard.putData(new DriveStraightCommand(2.0));
		SmartDashboard.putData(new TestCommandGroup());
		SmartDashboard.putData(new TestCommand());
		SmartDashboard.putData(new SaveRecordingCommand());
		SmartDashboard.putData(new LoadRecordingCommand());
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
		if (!playing) {
			joystickInput = new RobotInput(RobotMap.LEFT_JOYSTICK, RobotMap.LEFT_JOYSTICK);
			testRightButton3 = new RobotInput(RobotMap.RIGHT_JOYSTICK, 3, new Piston1ForwardCommand());
			testRightButton2 = new RobotInput(RobotMap.RIGHT_JOYSTICK, 2, new Piston1ReverseCommand());
			testLeftButton3 = new RobotInput(RobotMap.LEFT_JOYSTICK, 3, new Piston2ForwardCommand());
			input = new OldRobotInput();
			joystickInput.setLeftX();
			joystickInput.setLeftY();
			joystickInput.setRightX();
			testRightButton2.setButtonState();
			testRightButton3.setButtonState();
			input.setLeftButtonState3(oi.getLeftJoystick().getRawButton(3));
//			input.setRightButtonState3(oi.getRightJoystick().getRawButton(3));
//			input.setRightButtonState2(oi.getRightJoystick().getRawButton(2));
			testLeftButton3.setButtonState();
		}
		
		if (recording) {
			robotInputs.add(testLeftButton3);
			robotInputs.add(testRightButton2);
			robotInputs.add(testRightButton3);
			inputs.add(input);
			robotInputs.add(joystickInput);
		}
		
		Scheduler.getInstance().run();
		log();
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
		sensorBase.log();
		solenoid2.log();
		SmartDashboard.putBoolean("Recording:", recording);
		SmartDashboard.putNumber("Input count:", inputs.size());
	}
}
