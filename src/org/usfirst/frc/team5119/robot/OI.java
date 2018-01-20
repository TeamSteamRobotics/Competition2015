package org.usfirst.frc.team5119.robot;

import org.usfirst.frc.team5119.robot.commands.PlaceTheGear;
import org.usfirst.frc.team5119.robot.commands.ResetGyro;
import org.usfirst.frc.team5119.robot.commands.ClimbRope;
import org.usfirst.frc.team5119.robot.commands.StopClimbing;
import org.usfirst.frc.team5119.robot.commands.PickUpGear;
import org.usfirst.frc.team5119.robot.commands.AimForPin;
import org.usfirst.frc.team5119.robot.commands.AutonomousDrive;
import org.usfirst.frc.team5119.robot.commands.AutonomousTurn;
import org.usfirst.frc.team5119.robot.commands.BackDistance;
import org.usfirst.frc.team5119.robot.commands.ClimbDown;
import org.usfirst.frc.team5119.robot.commands.TestWheels;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final ScaledJoystick stick = new ScaledJoystick(0);
	
	//backLeft(id1)=backRight,FrontLeft(id3)=,FrontRight(id0)=,backRight(id2)=
	public final Button hangGearButton = new JoystickButton(stick, 2);
	public final Button climbRopeButton = new JoystickButton(stick, 7);
	public final Button centerPegButton = new JoystickButton(stick, 1);
	public final Button leftPegButton = new JoystickButton(stick, 5);
	public final Button rightPegButton = new JoystickButton(stick, 6);
	public final Button resetGyroButton = new JoystickButton(stick, 8);
	public final Button driveForwardButton = new JoystickButton(stick, 3);
	public final Button gearPickupButton = new JoystickButton(stick, 11);
	public final Button stayOnRopeButton = new JoystickButton(stick, 9);
	public final Button climbDownButton = new JoystickButton(stick, 10);
	//public final Button testMotorButton = new JoystickButton(stick, 9);
	
	public OI(){
		
		hangGearButton.whileHeld(new PlaceTheGear());
		climbRopeButton.whileHeld(new ClimbRope());
		centerPegButton.whenPressed(new AutonomousTurn(5,0));
		leftPegButton.whenPressed(new AutonomousTurn(2,60));
		gearPickupButton.whileHeld(new BackDistance());
		rightPegButton.whenPressed(new AutonomousTurn(5,-60));
		resetGyroButton.whileHeld(new ResetGyro());
		driveForwardButton.whileHeld(new AutonomousDrive(7,0,-.125,0));
		stayOnRopeButton.whileHeld(new StopClimbing());
		climbDownButton.whileHeld(new ClimbDown());
		//testMotorButton.whileHeld(new TestWheels());
	}
}
