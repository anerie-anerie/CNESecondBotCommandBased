// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
  }

  public static class DriveConstants {
    public static final int DRIVE_AXIS = 1;
    public static final int TURN_AXIS = 4;
    public static final int TURN_CONTROLLER_POSITION_TOLERANCE = 1;
    public static final int TURN_CONTROLLER_VELOCITY_TOLERANCE = 10;
    public static final int FRONT_LEFT_MOTOR_ID = 1;
    public static final int FRONT_RIGHT_MOTOR_ID = 3;
    public static final int BACK_LEFT_MOTOR_ID = 2;
    public static final int BACK_RIGHT_MOTOR_ID = 4;
  }

  public static class IntakeConstants {
    public static final int INTAKE_OPEN_BUTTON = 2;
    public static final int INTAKE_CLOSE_BUTTON = 1;
    public static final int INTAKE_MOTOR_ID = 5;
    public static final double stallAfterIntake = 0.2;
    public static final double intakeStallSpeed = 0.2;


  }
}
