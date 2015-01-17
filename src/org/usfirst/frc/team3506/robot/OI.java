package org.usfirst.frc.team3506.robot;

import static org.usfirst.frc.team3506.robot.RobotMap.LEFT_JOYSTICK;
import static org.usfirst.frc.team3506.robot.RobotMap.RIGHT_JOYSTICK;

import org.usfirst.frc.team3506.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3506.robot.commands.Piston1ForwardCommand;
import org.usfirst.frc.team3506.robot.commands.Piston1ReverseCommand;
import org.usfirst.frc.team3506.robot.commands.TestCommandGroup;
import org.usfirst.frc.team3506.robot.commands.TurnLeftCommand;
import org.usfirst.frc.team3506.robot.commands.TurnRightCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	
	private Joystick leftJoy;
	private Joystick rightJoy;
	
	public OI() {
		leftJoy = new Joystick(LEFT_JOYSTICK);
		rightJoy = new Joystick(RIGHT_JOYSTICK);
		
		JoystickButton leftButton10 = new JoystickButton(leftJoy, 10);
		leftButton10.whenPressed(new TurnRightCommand());
		
		JoystickButton leftButton7 = new JoystickButton(leftJoy, 7);
		leftButton7.whenPressed(new TurnLeftCommand());
		
		JoystickButton leftButton3 = new JoystickButton(leftJoy, 3);
		leftButton3.whenPressed(new DriveStraightCommand());
		
		JoystickButton leftButton2 = new JoystickButton(leftJoy, 2);
		leftButton2.whenPressed(new TestCommandGroup());
		
		JoystickButton rightButton3 = new JoystickButton(rightJoy, 3);
		rightButton3.whenPressed(new Piston1ForwardCommand());
		
		JoystickButton rightButton2 = new JoystickButton(rightJoy, 2);
		rightButton2.whenPressed(new Piston1ReverseCommand());
	}
	
	public Joystick getLeftJoy() {
		return leftJoy;
	}
	
	public Joystick getRightJoy() {
		return rightJoy;
	}
	
	
}

