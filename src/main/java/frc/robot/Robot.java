// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

//rev imports
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  CANSparkMax leftfront;
  CANSparkMax rightfront;
  CANSparkMax leftback;
  CANSparkMax rightback;
  DifferentialDrive my_robot;
  XboxController controller = new XboxController(0); //find port # on driver station

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    leftfront = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);
    rightfront = new CANSparkMax(1, CANSparkLowLevel.MotorType.kBrushless);
    leftback = new CANSparkMax(2, CANSparkLowLevel.MotorType.kBrushless);
    rightback = new CANSparkMax(3, CANSparkLowLevel.MotorType.kBrushless);

    leftback.follow(leftfront);
    rightback.follow(rightfront);

    my_robot = new DifferentialDrive(leftfront, rightfront);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    my_robot.tankDrive(controller.getLeftY(), controller.getRightY());
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
