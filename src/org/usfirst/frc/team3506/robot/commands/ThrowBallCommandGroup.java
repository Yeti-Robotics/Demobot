package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.commands.catapult.ForwardRollersCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.OperateRollersCommand;
import org.usfirst.frc.team3506.robot.commands.catapult.ToggleRollersCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThrowBallCommandGroup extends CommandGroup {
    
    public  ThrowBallCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new ForwardRollersCommand());
    	addParallel(new OperateRollersCommand());
    }
}
