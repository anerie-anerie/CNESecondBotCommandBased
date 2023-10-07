package frc.robot.commands;
//arcade drive command (cap forward speed at 0.7 (axis 1), and turn speed at 0.8 (axis 4)


public class ArcadeDriveCommand extends CommandBase {
    private final DriveSubsystem m_driveSubsystem;
    private final DoubleSupplier speedFunction, turnFunction;

    public ArcadeDriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier speedFunction, DoubleSupplier turnFunction) {
        this.m_driveSubsystem = driveSubsystem;
        this.speedFunction = speedFunction;
        this.turnFunction = turnFunction;

        addRequirements(m_driveSubsystem);
  }
         // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


}


