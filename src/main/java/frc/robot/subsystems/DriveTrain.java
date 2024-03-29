/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ArcadeDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Talon frontLeftMotor = new Talon(0);
  Talon frontRightMotor = new Talon(1);
  Talon rearLeftMotor = new Talon(2);
  Talon rearRightMotor = new Talon(3);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRightMotor, rearRightMotor);

  DifferentialDrive driveTrain = new DifferentialDrive(leftMotors, rightMotors);

  DigitalInput limitSwitch = new DigitalInput(0);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArcadeDrive());
  }

  public void arcadeDrive(double speed, double rotation) {
    driveTrain.arcadeDrive(speed, rotation);
  }
}
