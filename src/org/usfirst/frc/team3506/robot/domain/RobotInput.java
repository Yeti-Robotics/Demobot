package org.usfirst.frc.team3506.robot.domain;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class RobotInput
{
	private DriverStation driverStation;
	private byte byteButtonNumber;
	private int joystickPort, leftJoystickDrivePort, rightJoystickDrivePort;
	private Command command;
	private double leftX, leftY, rightX, rightY;
	private boolean buttonState;
	

	public RobotInput(int buttonJoystickPort, int buttonNumber, Command command)
	{
		this.byteButtonNumber = (byte) buttonNumber;
		this.joystickPort = buttonJoystickPort;
		this.command = command;
	}
	
	public RobotInput (int leftJoystickDrivePort, int rightJoystickDrivePort)
	{
		this.leftJoystickDrivePort = leftJoystickDrivePort;
		this.rightJoystickDrivePort = rightJoystickDrivePort;
	}

	public boolean isButtonPressed()
	{
		if (driverStation.getStickButton(joystickPort, byteButtonNumber))
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	public boolean otherIsButtonPressed()
	{
		return buttonState;
	}
	
	public void setButtonState()
	{
		buttonState = driverStation.getStickButton(joystickPort, byteButtonNumber);
	}

	public void recordButtonState()
	{
		if(otherIsButtonPressed())
		{
			Scheduler.getInstance().add(command);
		}
	}
	
	public double getLeftX() 
	{
		return leftX;
	}
	public void setLeftX() 
	{
		leftX = driverStation.getStickAxis(leftJoystickDrivePort, RobotMap.JOYSTICK_AXIS_X);
	}
	public double getLeftY() 
	{
		return leftY;
	}
	public void setLeftY() 
	{
		leftY = driverStation.getStickAxis(leftJoystickDrivePort, RobotMap.JOYSTICK_AXIS_Y);
	}
	public double getRightX() 
	{
		return rightX;
	}
	public void setRightX() 
	{
		rightX = driverStation.getStickAxis(rightJoystickDrivePort, RobotMap.JOYSTICK_AXIS_X);
	}
	public double getRightY() 
	{
		return rightY;
	}
	public void setRightY() 
	{
		rightY = driverStation.getStickAxis(rightJoystickDrivePort, RobotMap.JOYSTICK_AXIS_Y);
	}
	
	
}
