package frc.robot.subsystems;

import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
    private final CANSparkMax intake = new CANSparkMax(INTAKE_MOTOR_ID MotorType.kBrushless);
    private static boolean stall;

    /** Creates a new ExampleSubsystem. */
    public IntakeSubsystem() {
  
      public IntakeSubsystem() {
        // Set motor inversion if necessary
        intakeMotor.setInverted(false);
    }

    public void intakeIn() {
        intakeMotor.set(setMotor.PercentOutput, 0.4);
    }

    public void intakeOut() {
        intakeMotor.set(setMotor.PercentOutput, -0.4);
    }

    public void stopIntake() {
        intakeMotor.set(setMotor.PercentOutput, 0);
    }

    public void setIntakeSpeed(double d) {
    }
}
        
          public boolean getStall(){
            return stall;
          }
        }
        
          /**
           * Example command factory method.
           *
           * @return a command
           */
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
          public void periodic() {
            // This method will be called once per scheduler run
        
            
          }
        
          @Override
          public void simulationPeriodic() {
            // This method will be called once per scheduler run during simulation
          }
    }
  

