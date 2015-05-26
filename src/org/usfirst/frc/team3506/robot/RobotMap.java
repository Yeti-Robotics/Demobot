package org.usfirst.frc.team3506.robot;

import java.util.Hashtable;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// Talon ports
	public final static int LEFT_BACK_PORT = 3;
	public final static int LEFT_FRONT_PORT = 0;
	public final static int RIGHT_BACK_PORT = 2;
	public final static int RIGHT_FRONT_PORT = 1;
	public static final int CATAPULT_TALON_PORT = 0;
	public static final double CATAPULT_ROLLER_SPEED = 1.0;
	
	//Pneumatics ports
	public static final int PCM_ID = 0;
	public static final int[] CATAPULT_SOLENOID = {};
	
	// Joystick ports
	public static final int LEFT_JOYSTICK = 1;
	public static final int RIGHT_JOYSTICK = 2;
	public static final int GAMEPAD_PORT = 3;
	
	public static final int LEFT_ANALOG_X = 0;
	public static final int LEFT_ANALOG_Y = 4;
	public static final int RIGHT_ANALOG_X = 1;
	public static final double JOYSTICK_NORMAL_MOD = 1.0;
	public static final double JOYSTICK_SAFE_MOD = 0.5;
	
	//Gamepad buttons
	public static final int A_BUTTON = 1;
	public static final int B_BUTTON = 2;
	public static final int X_BUTTON = 3;
	public static final int Y_BUTTON = 4;
	public static final int LEFT_SHOULDER_BUTTON = 5;
	public static final int RIGHT_SHOULDER_BUTTON = 6;
	public static final int BACK_BUTTON = 7;
	public static final int START_BUTTON = 8;
	public static final int LEFT_STICK_BUTTON = 9;
	public static final int RIGHT_STICK_BUTTON = 10;
	
	 // Gyro Port
	public static final int GYRO_PORT = 0;
	public static final double TURN_TIMEOUT = 0.75;
	public static final double DRIVE_STRAIGHT_TIMEOUT= 2;	
		
	// Angles
	public final static double TURN_STOP_ANGLE = 70;
	
	// Speed
	public final static double TURN_RIGHT_SPEED = 0.3;
	public final static double TURN_LEFT_SPEED = -0.3;
	public final static double FORWARD_SPEED = -0.5;
	
	public static final String COMMANDS_FILE = "/3506/recording.txt";
}
