package org.usfirst.frc.team3506.robot.domain;

import java.io.Serializable;

public class OldRobotInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	double leftX, leftY, rightX, rightY;
	
	boolean leftButtonState3;
	public boolean isRightButtonState2() {
		return rightButtonState2;
	}
	public void setRightButtonState2(boolean rightButtonState2) {
		this.rightButtonState2 = rightButtonState2;
	}
	boolean rightButtonState3;
	public boolean isRightButtonState3() {
		return rightButtonState3;
	}
	public void setRightButtonState3(boolean rightButtonState3) {
		this.rightButtonState3 = rightButtonState3;
	}
	boolean rightButtonState2;
	
	public boolean isLeftButtonState3() {
		return leftButtonState3;
	}
	public void setLeftButtonState3(boolean leftButtonState3) {
		this.leftButtonState3 = leftButtonState3;
	}
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
