package org.usfirst.frc.team3506.robot.domain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class ButtonInput
{
	private DriverStation driverStation;
	private byte byteButtonNumber;
	private int joystickPort;
	private Command command;

	public ButtonInput(int joystickPort, int buttonNumber, Command command)
	{
		this.byteButtonNumber = (byte) buttonNumber;
		this.joystickPort = joystickPort;
		this.command = command;
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

	public void recordButtonState()
	{
		if(isButtonPressed())
		{
			Scheduler.getInstance().add(command);
		}
	}
}
