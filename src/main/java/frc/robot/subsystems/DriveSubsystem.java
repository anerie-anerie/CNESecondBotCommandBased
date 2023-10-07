// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*two subsystems
driveSubsystem 
frontleft motor id: 1
frontright motor id: 3
backleft motor id: 2
backright motor id: 4

intakeSubsystem
motor id: 5

three commands
arcade drive command (cap forward speed at 0.7 (axis 1), and turn speed at 0.8 (axis 4))
intake in(button 1)/out(button 2) command (in 0.4/out -0.4, add a stall of 0.2 or -0.2)
autonomous command: drive forward (0.5 speed) and intake at the same time for 2 seconds

Two joysticks: driver(port 0) controls driving, operator(port 1) controls intake */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final WPI_VictorSPX driveFrontLeft = new WPI_VictorSPX(DriveConstants.DRIVE_FRONT_LEFT);
  private final WPI_VictorSPX driveFrontRight = new WPI_VictorSPX(DriveConstants.DRIVE_FRONT_RIGHT);
  private final WPI_VictorSPX driveBackLeft = new WPI_VictorSPX(DriveConstants.DRIVE_BACK_LEFT);
  private final WPI_VictorSPX driveBackRight = new WPI_VictorSPX(DriveConstants.DRIVE_BACK_RIGHT);

  private final MotorControllerGroup driveLeft = new MotorControllerGroup(driveFrontLeft, driveBackLeft);
  private final MotorControllerGroup driveRight = new MotorControllerGroup(driveFrontRight, driveBackRight);
  private final DifferentialDrive driveRobot = new DifferentialDrive(driveLeft, driveRight);

  private final AHRS gyro = new AHRS(SPI.Port.kMXP);
  private final Encoder encoderLeftDrive = new Encoder(DriveConstants.LEFT_ENCODER_A, DriveConstants.LEFT_ENCODER_B);

  public double getEncoderDrivePosition() {
    return (encoderLeftDrive.getDistance());
  }

  public double getGyroYaw() {
    return (gyro.getYaw());
  }

  public double getGyroPitch() {
    return (gyro.getPitch());
  }

  public double getGyroRoll() {
    return (gyro.getRoll());
  }

  public DriveSubsystem() {
    driveFrontLeft.setNeutralMode(NeutralMode.Brake);
    driveFrontRight.setNeutralMode(NeutralMode.Brake);
    driveBackLeft.setNeutralMode(NeutralMode.Brake);
    driveBackRight.setNeutralMode(NeutralMode.Brake);
    driveRight.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Roll", getGyroRoll());
    SmartDashboard.putNumber("Pitch", getGyroPitch());
    SmartDashboard.putNumber("Yaw", getGyroYaw());
    SmartDashboard.putNumber("Encoder Left Distance", encoderLeftDrive.getDistance());

  }

  public void setMotor(double forwardSpeed, double turnSpeed) {
    driveRobot.arcadeDrive(forwardSpeed, turnSpeed);
  }
}
