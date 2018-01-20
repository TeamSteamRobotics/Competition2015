package org.usfirst.frc.team5119.robot.subsystems;

import org.usfirst.frc.team5119.robot.RobotMap;
import org.usfirst.frc.team5119.robot.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	protected  CANTalon frontLeft = new CANTalon(RobotMap.frontLeftMotor),
			frontRight = new CANTalon(RobotMap.frontRightMotor),
			backLeft = new CANTalon(RobotMap.backLeftMotor),
			backRight = new CANTalon(RobotMap.backRightMotor);
	protected RobotDrive drive = new RobotDrive(frontLeft,backLeft,frontRight,backRight);


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());

	}
	public void drive(double x,double y,double z){
		double xMod = 1;
		double yMod = 1;
		double zMod = .7;
		drive.mecanumDrive_Cartesian(x * xMod, y * yMod, z * zMod, 0);
		//testWheels();
	}
	public void testWheels(){
		//frontLeft.set(1);
		DriverStation.reportError("frontLeft="+frontLeft.get() + ", frontRight="+frontRight.get() + ", backRight="+backRight.get() + ", backLeft="+backLeft.get(), false);
	}
	public void driveAtAngle(double speed, double angle, double rotate){
		drive.mecanumDrive_Polar(speed, angle, rotate);
	}
}

