package org.usfirst.frc.team5119.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	protected AnalogInput ultrasonic = new AnalogInput(0);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double distance(){
    	return ultrasonic.getVoltage();
    }
}

