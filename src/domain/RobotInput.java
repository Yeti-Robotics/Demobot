package domain;

import java.io.Serializable;
import java.util.Arrays;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.ClearScheduleCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class RobotInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	double leftX, leftY, rotation;
	//public boolean[] leftButtons = new boolean[RobotMap.NUMBER_OF_JOYSTICK_BUTTONS];
	//public boolean[] rightButtons = new boolean[RobotMap.NUMBER_OF_JOYSTICK_BUTTONS];
	//public static Command[] leftCommands = new Command[RobotMap.NUMBER_OF_JOYSTICK_BUTTONS];
	//public static Command[] rightCommands = new Command[RobotMap.NUMBER_OF_JOYSTICK_BUTTONS];
	public boolean[] buttons = new boolean[10];
	public static Command[] commands = new Command[10];
	
	public RobotInput(){
		commands[0] = new ClearScheduleCommand();
	}
	
	/**
	 * @param booleanArray
	 *            Must be RobotInput.leftButtons[] or
	 *            RobotInput.rightButtons[]
	 * 
	 * @param buttonNumber
	 *            The value of the button on the joystick
	 * 
	 * @return The value of booleanArray[] at buttonNumber
	 */
	public boolean getButtonState(int buttonNumber) {
		return buttons[buttonNumber-1];
	}

	public void setButtonState(int buttonNumber,
			Joystick joystick) {
		buttons[buttonNumber-1] = joystick.getRawButton(buttonNumber);
	}

	public void executeButtonCommand(int buttonNumber,
			Command command) {
		boolean buttonState = getButtonState(buttonNumber);
		if (buttonState) {
			Scheduler.getInstance().add(command);
		}
	}

	public double getJoystickAxis(int joystickPort, int joystickAxisValue) {
		return DriverStation.getInstance().getStickAxis(joystickPort,
				joystickAxisValue);
	}

	public double getLeftX(){
		return leftX;
	}
	
	public double getLeftY(){
		return leftY;
	}
	
	public void setLeftX(double num){
		leftX = num;
	}
	
	public void setLeftY(double num){
		leftY = num;
	}
	
	public double getRotation(){
		return rotation;
	}
	
	public void setRotation(double num){
		rotation = num;
	}

	@Override
	public String toString() {
		return "RobotInput";
		
	}
}
