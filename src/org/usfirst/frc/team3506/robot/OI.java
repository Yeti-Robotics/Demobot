package org.usfirst.frc.team3506.robot;

import static org.usfirst.frc.team3506.robot.RobotMap.LEFT_JOYSTICK;
import static org.usfirst.frc.team3506.robot.RobotMap.RIGHT_JOYSTICK;

import org.usfirst.frc.team3506.robot.commands.DriveUntilObstacleCommand;
import org.usfirst.frc.team3506.robot.commands.FollowCommand;
import org.usfirst.frc.team3506.robot.commands.Piston1ForwardCommand;
import org.usfirst.frc.team3506.robot.commands.Piston1ReverseCommand;
import org.usfirst.frc.team3506.robot.commands.Piston2ForwardCommand;
import org.usfirst.frc.team3506.robot.commands.Piston2ReverseCommand;
import org.usfirst.frc.team3506.robot.commands.RebootCommand;
import org.usfirst.frc.team3506.robot.commands.RecordCommand;
import org.usfirst.frc.team3506.robot.commands.ResetGyroCommand;
import org.usfirst.frc.team3506.robot.commands.StartCompressorCommand;
import org.usfirst.frc.team3506.robot.commands.StopCompressorCommand;
import org.usfirst.frc.team3506.robot.commands.TestCommandGroup;
import org.usfirst.frc.team3506.robot.commands.ChangeLightSpeedCommand;
import org.usfirst.frc.team3506.robot.commands.ToggleLightsCommand;
import org.usfirst.frc.team3506.robot.commands.UniversalDriveCommand;
import org.usfirst.frc.team3506.robot.domain.RobotInput;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	private Joystick leftJoy;
	private Joystick rightJoy;

	public OI() {
		leftJoy = new Joystick(LEFT_JOYSTICK);
		rightJoy = new Joystick(RIGHT_JOYSTICK);
		
		//Piston 2 reverse
		setJoystickButtonCommand(leftJoy, 2, new Piston2ReverseCommand());
		//Piston 2 forward
		setJoystickButtonCommand(leftJoy, 3, new Piston2ForwardCommand());
		//Toggle LEDs
		setJoystickButtonCommand(leftJoy, 4, new ToggleLightsCommand());
		//Failsafe
		setJoystickButtonCommand(leftJoy, 7, new RebootCommand());
		//Start the compressor
		setJoystickButtonCommand(leftJoy, 8, new StartCompressorCommand());
		//Stop the compressor
		setJoystickButtonCommand(leftJoy, 9, new StopCompressorCommand());
		//Change LED speed
		setJoystickButtonCommand(leftJoy, 10, new ChangeLightSpeedCommand());
		//Start recording
		setJoystickButtonCommand(leftJoy, 11, new RecordCommand());
		
		//Piston 1 reverse (not currently necessary)
		setJoystickButtonCommand(rightJoy, 2, new Piston1ReverseCommand());
		//Piston 1 forward
		setJoystickButtonCommand(rightJoy, 3, new Piston1ForwardCommand());
		//Sonar follow
		setJoystickButtonCommand(rightJoy, 6, new FollowCommand());
		//Drive until an object is encountered
		setJoystickButtonCommand(rightJoy, 7, new DriveUntilObstacleCommand(0.15));
		//Command group in development
		setJoystickButtonCommand(rightJoy, 8, new TestCommandGroup());
		//Reset the gyro
		setJoystickButtonCommand(rightJoy, 10, new ResetGyroCommand());
		//Testing universal drive command
		setJoystickButtonCommand(rightJoy, 9, new UniversalDriveCommand(164, 0.2, 0));
		setJoystickButtonCommand(rightJoy, 11, new UniversalDriveCommand(0, 0.5, 3));
		
		
	}
	

	private double deadZoneMod(double joyVal){
		if (Math.abs(joyVal) > 0.1) {
			return joyVal;
		} else {
			return 0.0;
		}
	}
	
	public double getLeftX() {
		return deadZoneMod(leftJoy.getX());
	}

	public double getLeftY(){
		return deadZoneMod(leftJoy.getY());
	}
	
	public double getRightX() {
		return deadZoneMod(rightJoy.getX());
	}

	public Joystick getLeftJoystick() {
		return leftJoy;
	}
	
	public Joystick getRightJoystick() {
		return rightJoy;
	}
	
	private void setJoystickButtonCommand(Joystick joystick, int button,
			Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
		if (leftJoy == joystick) {
			RobotInput.leftCommands[button - 1] = command;
		} else if (rightJoy == joystick) {
			RobotInput.rightCommands[button - 1] = command;
			
		}
		
	}

}
