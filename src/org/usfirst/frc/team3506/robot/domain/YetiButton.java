package org.usfirst.frc.team3506.robot.domain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class YetiButton {
	private boolean buttonState;
	private JoystickButton button;
	public YetiButton(Joystick joyRef, int buttonNumber, Command command){
		this.setButtonState(false);
		button = new JoystickButton(joyRef, buttonNumber);
		button.whenPressed(command);
	}
	public boolean isButtonState() {
		return buttonState;
	}
	public void setButtonState(boolean buttonState) {
		this.buttonState = buttonState;
	}
}
