package org.usfirst.frc.team3506.robot;

import static org.usfirst.frc.team3506.robot.RobotMap.GAMEPAD_PORT;

import org.usfirst.frc.team3506.robot.commands.ClearScheduleCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.ArmCatapultCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.ForwardRollersCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.LaunchCatapultCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.ReverseRollerCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.ToggleRollerDirectionCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.ToggleRollersCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.StopRollersCommand;
import org.usfirst.frc.team3506.robot.commands.drive.ToggleSpeedCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//private Joystick leftJoy;
	//private Joystick rightJoy;
	private Joystick gamepad;
	
	public OI() {
		//leftJoy = new Joystick(LEFT_JOYSTICK);
		//rightJoy = new Joystick(RIGHT_JOYSTICK);
		gamepad = new Joystick(GAMEPAD_PORT);

		setJoystickButtonCommand(gamepad, RobotMap.RIGHT_STICK_BUTTON, new ClearScheduleCommand());
//		setJoystickButtonCommand(gamepad, 3, new RecordCommand());
//		setJoystickButtonCommand(gamepad, 4, new SaveRecordingCommand());
//		setJoystickButtonCommand(gamepad, 2, new LoadRecordingCommand());
		
		setJoystickButtonCommand(gamepad, RobotMap.Y_BUTTON, new ToggleSpeedCommand());
		//setJoystickButtonCommand(gamepad, RobotMap.START_BUTTON, new ReverseRollerCommand());
		setJoystickButtonCommand(gamepad, RobotMap.A_BUTTON, new ForwardRollersCommand());
		
		//setJoystickButtonCommand(gamepad, RobotMap.B_BUTTON, new StopRollersCommand());
		setJoystickButtonCommand(gamepad, RobotMap.B_BUTTON, new ReverseRollerCommand());
		setJoystickButtonCommand(gamepad, RobotMap.LEFT_SHOULDER_BUTTON, new LaunchCatapultCommand());
		setJoystickButtonCommand(gamepad, RobotMap.RIGHT_SHOULDER_BUTTON, new ArmCatapultCommand());
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
	
	public double getGamepadLeftX(){
		return getGamepadAxis(RobotMap.LEFT_ANALOG_X);
	}
	
	public double getGamepadLeftY(){
		return getGamepadAxis(RobotMap.LEFT_ANALOG_Y);
	}
	
	public double getGamepadRightX() {
		return getGamepadAxis(RobotMap.RIGHT_ANALOG_X);
	}
	
	public double getGamepadAxis(int axis){
		return joyMod(gamepad.getRawAxis(axis));
	}
	
	public double joyMod(double joyVal) {
		if(Math.abs(joyVal)<=0.05){
			return 0;
		} else{
			return joyVal*RobotMap.JOYSTICK_NORMAL_MOD;
		}
		//return joyVal * RobotMap.JOYSTICK_NORMAL_MOD;
	}

	private void setJoystickButtonCommand(Joystick joystick, int button,
			Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}

}
