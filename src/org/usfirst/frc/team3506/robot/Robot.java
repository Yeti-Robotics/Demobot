
package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3506.robot.commands.TestCommandGroup;
import org.usfirst.frc.team3506.robot.commands.TurnLeftCommand;
import org.usfirst.frc.team3506.robot.commands.TurnRightCommand;
import org.usfirst.frc.team3506.robot.commands.UserDriveCommand;
import org.usfirst.frc.team3506.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.Solenoid1Subsystem;
import org.usfirst.frc.team3506.robot.subsystems.Solenoid2Subsystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSubsystem drive;
	public static Solenoid1Subsystem solenoid1;
	public static Solenoid2Subsystem solenoid2;
	public static GyroSubsystem gyroSubsystem;
	public static Compressor compressor;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    		gyroSubsystem = new GyroSubsystem();
    		drive = new DriveSubsystem();
		solenoid1 = new Solenoid1Subsystem();
		solenoid2 = new Solenoid2Subsystem();
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
		//this should be last
		oi = new OI();

        SmartDashboard.putData(new TurnRightCommand());
        SmartDashboard.putData(new TurnLeftCommand());
        SmartDashboard.putData(new DriveStraightCommand(2.0));
        SmartDashboard.putData(new TestCommandGroup());
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        new UserDriveCommand().start();
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        log();
    }
    
    private void log() {
    		drive.log();
    		gyroSubsystem.log();
    		solenoid2.log();
    }
}
