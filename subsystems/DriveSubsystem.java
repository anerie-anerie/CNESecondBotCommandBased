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

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final WPI_VictorSPX leftDriveFront = new WPI_VictorSPX(FRONT_LEFT_MOTOR_ID);
  private final WPI_VictorSPX leftDriveBack = new WPI_VictorSPX(BACK_LEFT_MOTOR_ID);
  private final WPI_VictorSPX rightDriveFront = new WPI_VictorSPX(FRONT_RIGHT_MOTOR_ID);
  private final WPI_VictorSPX rightDriveBack = new WPI_VictorSPX(BACK_RIGHT_MOTOR_ID);

  private final MotorControllerGroup driveLeft = new MotorControllerGroup(leftDriveFront, leftDriveBack);
  private final MotorControllerGroup driveRight = new MotorControllerGroup(rightDriveFront, rightDriveBack);
  private final DifferentialDrive driveRobot = new DifferentialDrive(driveLeft, driveRight);




public DriveSubsystem() {
  driveRight.setInverted(true);
  leftDriveFront.setNeutralMode(NeutralMode.Brake);
  leftDriveBack.setNeutralMode(NeutralMode.Brake);
  rightDriveFront.setNeutralMode(NeutralMode.Brake);
  rightDriveBack.setNeutralMode(NeutralMode.Brake);

}

  public CommandBase exampleMethodCommand() {
  // Inline construction of command goes here.
  // Subsystem::RunOnce implicitly requires `this` subsystem.
  return runOnce(
      () -> {
        /* one-time action goes here */
      });
}

/**
 * An example method querying a boolean state of the subsystem (for example, a digital sensor).
 *
 * @return value of some boolean subsystem state, such as a digital sensor.
 */
public boolean exampleCondition() {
  // Query some boolean state, such as a digital sensor.
  return false;
}

@Override
public void simulationPeriodic() {
  // This method will be called once per scheduler run during simulation
}
}