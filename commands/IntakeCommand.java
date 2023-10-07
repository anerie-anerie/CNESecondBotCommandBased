package frc.robot.commands;
//intake in(button 1)/out(button 2) command (in 0.4/out -0.4, add a stall of 0.2 or -0.2)

import frc.robot.subsystems.IntakeSubsystem;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.Joystick;

public class IntakeCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final IntakeSubsystem m_intakeSubsystem;
    private final DoubleSupplier speed;
    private final Joystick operatorController;
  
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public IntakeCommand(IntakeSubsystem intakeSubsystem, DoubleSupplier speedFunction) {
      this.m_intakeSubsystem = intakeSubsystem;
      this.speed = speedFunction;
      this.operatorController = operatorController;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(m_intakeSubsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
  
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
  
      if(speed.getAsDouble() < 0.0){
  
        m_intakeSubsystem.setMotor(speed.getAsDouble());
        m_intakeSubsystem.setStall(true);
     
      }
  
      else if(speed.getAsDouble() > 0.0){
        m_intakeSubsystem.setMotor(speed.getAsDouble());
        m_intakeSubsystem.setStall(false);
       
      }
  
      else if(speed.getAsDouble() == 0.0){
  
        if(m_intakeSubsystem.getStall() && IntakeConstants.stallAfterIntake){
          m_intakeSubsystem.setMotor(IntakeConstants.intakeStallSpeed);
     
        }
        else{
          m_intakeSubsystem.setMotor(speed.getAsDouble());
    
         
        }
      }
  
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      
      m_intakeSubsystem.setMotor(0.0);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  }

