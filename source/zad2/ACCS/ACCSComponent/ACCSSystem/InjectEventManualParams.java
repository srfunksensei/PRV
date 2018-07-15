package ACCSSystem;
import ACCSGUI.ButtonValues;
import ACCSSystem.Parameters;
// {{{RME classifier 'Logical View::ACCSSystem::InjectEventManualParams'
public class InjectEventManualParams extends ACCSGUI.ButtonEvent
{
	// {{{RME classAttribute 'savedPort'
	public static Parameters.Conjugate savedPort;
	// }}}RME
	// {{{RME operation 'InjectEventManualParams(Parameters.Conjugate)'
	public InjectEventManualParams( Parameters.Conjugate port )
	{
		savedPort = port;
	}
	// }}}RME
	// {{{RME operation 'buttonClicked(int,ManualParameters)'
	public void buttonClicked( int button, ManualParameters params )
	{
		switch (button){
			case ButtonValues.btnSetSpeed:
				savedPort.ManualParamrs(params).send();
				break;
			case ButtonValues.btnSetThrottle :
				savedPort.ManualParamrs(params).send();
				break;

			default:
				break;
		}

	}
	// }}}RME
}
// }}}RME
