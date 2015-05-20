package org.usfirst.frc.team3506.robot;

import static org.usfirst.frc.team3506.robot.RobotMap.LEFT_JOYSTICK;
import static org.usfirst.frc.team3506.robot.RobotMap.RIGHT_JOYSTICK;
import static org.usfirst.frc.team3506.robot.RobotMap.GAMEPAD_PORT;

import org.usfirst.frc.team3506.robot.commands.LoadRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.RebootCommand;
import org.usfirst.frc.team3506.robot.commands.RecordCommand;
import org.usfirst.frc.team3506.robot.commands.SaveRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.TestCommandGroup;

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
	private Joystick gamepad;

	public OI() {
		//leftJoy = new Joystick(LEFT_JOYSTICK);
		//rightJoy = new Joystick(RIGHT_JOYSTICK);
		gamepad = new Joystick(GAMEPAD_PORT);

		setJoystickButtonCommand(gamepad, 1, new RebootCommand());
		setJoystickButtonCommand(gamepad, 3, new RecordCommand());
		setJoystickButtonCommand(gamepad, 4, new SaveRecordingCommand());
		setJoystickButtonCommand(gamepad, 2, new LoadRecordingCommand());
	}

	/*public Joystick getLeftJoy() {
		return leftJoy;
	}

	public Joystick getRightJoy() {
		return rightJoy;
	}
	*/
	public Joystick getGamepad(){
		return gamepad;
	}
	
	public double getGamepadX(){
		return gamepad.getX();
	}
	
	public double getGamepadY(){
		return gamepad.getY();
	}
	
	public double getGamepadAxis(int axis){
		return gamepad.getRawAxis(axis);
	}

	private void setJoystickButtonCommand(Joystick joystick, int button,
			Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}

}
