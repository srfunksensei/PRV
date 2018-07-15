package ACCSSystem;
import ACCSGUI.ButtonValues;
import ACCSSystem.BrakeInterrupt;
// {{{RME classifier 'Logical View::ACCSSystem::InjectEventBrake'
public class InjectEventBrake extends ACCSGUI.ButtonEvent
{
	// {{{RME classAttribute 'savedPort'
	public static BrakeInterrupt.Conjugate savedPort;
	// }}}RME
	// {{{RME operation 'InjectEventBrake(BrakeInterrupt.Conjugate)'
	public InjectEventBrake( BrakeInterrupt.Conjugate port )
	{
		savedPort = port;
	}
	// }}}RME
	// {{{RME operation 'buttonClicked(int)'
	public void buttonClicked( int button )
	{
		switch (button){
			case ButtonValues.btnApplyBrake:
				savedPort.ApplyBrake().send();
				break;
			case ButtonValues.btnReleaseBrake :
				savedPort.ReleaseBrake().send();
				break;

			default:
				break;
		}

	}
	// }}}RME
}
// }}}RME
