package ACCSSystem;
import ACCSGUI.ButtonValues;
import ACCSSystem.Parameters;
// {{{RME classifier 'Logical View::ACCSSystem::InjectEventFunctionParams'
public class InjectEventFunctionParams extends ACCSGUI.ButtonEvent
{
	// {{{RME classAttribute 'savedPort'
	public static Parameters.Conjugate savedPort;
	// }}}RME
	// {{{RME operation 'InjectEventFunctionParams(Parameters.Conjugate)'
	public InjectEventFunctionParams( Parameters.Conjugate port )
	{
		savedPort = port;
	}
	// }}}RME
	// {{{RME operation 'buttonClicked(int,FunctionParameters)'
	public void buttonClicked( int button, FunctionParameters params )
	{
		switch (button){
			case ButtonValues.btnSetSpeedParam:
				CommandLeverSensor.gui.speedFP = true;
				savedPort.FunctionParams(params).send();
				break;
			case ButtonValues.btnSetThrottleParam :
				savedPort.FunctionParams(params).send();
				break;

			default:
				break;
		}

	}
	// }}}RME
}
// }}}RME
