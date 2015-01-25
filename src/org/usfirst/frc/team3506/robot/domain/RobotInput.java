package org.usfirst.frc.team3506.robot.domain;

import java.io.Serializable;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class RobotInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	double leftX, leftY, rightX, rightY;
	public static boolean[] leftButtons = new boolean[RobotMap.NUMBER_OF_LEFT_JOYSTICK_BUTTONS];
	public static boolean[] rightButtons = new boolean[RobotMap.NUMBER_OF_RIGHT_JOYSTICK_BUTTONS];
	
	boolean leftButtonState3;
	boolean rightButtonState3;
	boolean rightButtonState2;
	
	
	/**
	 * @param booleanArray
	 * 		Must be OldRobotInput.leftButtons[] or OldRobotInput.rightButtons[]
	 * 
	 * @param buttonNumber
	 * 		The value of the button on the joystick
	 * 
	 * @return 
	 * 		The value of booleanArray[] at buttonNumber
	 */
	public boolean getButtonState(boolean booleanArray[], int buttonNumber) {
		return booleanArray[buttonNumber - 1];
	}
	
	public void setButtonState(boolean booleanArray[], int buttonNumber, Joystick joystick) {
		booleanArray[buttonNumber - 1] = joystick.getRawButton(buttonNumber);
	}
	
	public void recordButtonState(boolean booleanArray[], int buttonNumber, Command command) {
		if (getButtonState(booleanArray, buttonNumber)) {
			Scheduler.getInstance().add(command);
		}
	}
	
	public double getJoystickAxis(int joystickPort, int joystickAxisValue) {
		return DriverStation.getInstance().getStickAxis(joystickPort, joystickAxisValue);
	}
	
	public void setJoystick() {
		
	}
	
	
//	public boolean isRightButtonState2() {
//		return rightButtonState2;
//	}
//	public void setRightButtonState2(boolean rightButtonState2) {
//		this.rightButtonState2 = rightButtonState2;
//	}
//	public boolean isRightButtonState3() {
//		return rightButtonState3;
//	}
//	public void setRightButtonState3(boolean rightButtonState3) {
//		this.rightButtonState3 = rightButtonState3;
//	}
//	
//	public boolean isLeftButtonState3() {
//		return leftButtonState3;
//	}
//	public void setLeftButtonState3(boolean leftButtonState3) {
//		this.leftButtonState3 = leftButtonState3;
//	}
	public double getLeftX() {
		return leftX;
	}
	public void setLeftX(double leftX) {
		this.leftX = leftX;
	}
	public double getLeftY() {
		return leftY;
	}
	public void setLeftY(double leftY) {
		this.leftY = leftY;
	}
	public double getRightX() {
		return rightX;
	}
	public void setRightX(double rightX) {
		this.rightX = rightX;
	}
	public double getRightY() {
		return rightY;
	}
	public void setRightY(double rightY) {
		this.rightY = rightY;
	}
}
