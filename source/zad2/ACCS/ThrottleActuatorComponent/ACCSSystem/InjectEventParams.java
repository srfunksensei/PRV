package ACCSSystem;
import ACCSGUI.ButtonValues;
import ACCSSystem.Parameters;
// {{{RME classifier 'Logical View::ACCSSystem::InjectEventParams'
public class InjectEventParams extends ACCSGUI.ButtonEvent
{
	// {{{RME classAttribute 'savedPort'
	public static Parameters.Conjugate savedPort;
	// }}}RME
	// {{{RME operation 'InjectEventParams(Parameters.Conjugate)'
	public InjectEventParams( Parameters.Conjugate port )
	{
		savedPort = port;
	}
	// }}}RME
	// {{{RME operation 'buttonClicked(int)'
	public void buttonClicked( int button )
	{
		switch (button){
			case ButtonValues.btnSetSpeed:
		//		savedPort.ManualParamrs.send();
				break;
			case ButtonValues.btnSetThrottle :
		//		savedPort.ManualParamrs.send();
				break;
			case ButtonValues.btnSetSpeedParam:
		//		savedPort.FunctionParams.send();
				break;
			case ButtonValues.btnSetThrottleParam :
		//		savedPort.FunctionParams.send();
				break;

			default:
				break;
		}

	}
	// }}}RME
}
// }}}RME
