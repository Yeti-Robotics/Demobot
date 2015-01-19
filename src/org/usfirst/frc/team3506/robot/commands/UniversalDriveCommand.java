package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class UniversalDriveCommand extends Command {
	Gyro gyro;
	Encoder leftFront;
	double angle;
	double speed;
	double distance;
	double distanceTravelled;
    public UniversalDriveCommand(double angle, double speed, double distance) {
    	requires(Robot.drive);
    	requires(Robot.sensorBase);
    	this.angle = angle;
    	this.speed = speed;
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gyro = Robot.sensorBase.getGyro();
    	leftFront = Robot.sensorBase.getLeftFrontEncoder();
    	gyro.reset();
    	leftFront.reset();
    	distanceTravelled = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(angle==0){
    		while(distanceTravelled<distance){
    			Robot.drive.driveStraight(speed);
    			distanceTravelled = leftFront.getDistance()*0.0065;
    		}
    	} else if(angle<0){
    		Robot.drive.leftTurn(speed, angle);
    	} else{
    		Robot.drive.rightTurn(speed, angle);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
