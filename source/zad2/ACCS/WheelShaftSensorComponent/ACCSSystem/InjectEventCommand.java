package ACCSSystem;
import ACCSGUI.ButtonValues;
import ACCSSystem.LeverCommand;
// {{{RME classifier 'Logical View::ACCSSystem::InjectEventCommand'
public class InjectEventCommand extends ACCSGUI.ButtonEvent
{
	// {{{RME classAttribute 'savedPort'
	public static LeverCommand.Conjugate savedPort;
	// }}}RME
	// {{{RME operation 'InjectEventCommand(LeverCommand.Conjugate)'
	public InjectEventCommand( LeverCommand.Conjugate port )
	{
		savedPort = port;
	}
	// }}}RME
	// {{{RME operation 'buttonClicked(int)'
	public void buttonClicked( int button )
	{
		switch (button){
			case ButtonValues.btnActivate:
				savedPort.Enable().send();
				break;
			case ButtonValues.btnDeactivate :
				savedPort.Disable().send();
				break;
			case ButtonValues.btnStartAcc:
				savedPort.StartAccIn().send();
				break;
			case ButtonValues.btnStopAcc :
				savedPort.StopAccIn().send();
				break;
			case ButtonValues.btnResume :
				savedPort.ResumeIn().send();
				break;

			default:
				break;
		}

	}
	// }}}RME
}
// }}}RME
