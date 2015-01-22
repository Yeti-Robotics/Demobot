package org.usfirst.frc.team3506.robot.domain;

import java.io.Serializable;

public class RobotInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	double leftX, leftY, rightX, rightY;
	
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
