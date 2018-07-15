package ACCSSystem;
import ACCSGUI.ButtonValues;
import ACCSSystem.EnableTopGear;
// {{{RME classifier 'Logical View::ACCSSystem::InjectEventTopGear'
public class InjectEventTopGear extends ACCSGUI.ButtonEvent
{
	// {{{RME classAttribute 'savedPort'
	public static EnableTopGear.Conjugate savedPort;
	// }}}RME
	// {{{RME operation 'InjectEventTopGear(EnableTopGear.Conjugate)'
	public InjectEventTopGear( EnableTopGear.Conjugate port )
	{
		savedPort = port;
	}
	// }}}RME
	// {{{RME operation 'buttonClicked(int)'
	public void buttonClicked( int button )
	{
		switch (button){
			case ButtonValues.btnEngageTopGear:
				savedPort.EngageTopGear().send();
				break;
			case ButtonValues.btnDisengageTopGear :
				savedPort.DisengageTopGear().send();
				break;

			default:
				break;
		}

	}
	// }}}RME
}
// }}}RME
