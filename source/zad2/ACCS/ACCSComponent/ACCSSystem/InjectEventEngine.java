package ACCSSystem;
import ACCSGUI.ButtonValues;
import ACCSSystem.EnableEngine;
// {{{RME classifier 'Logical View::ACCSSystem::InjectEventEngine'
public class InjectEventEngine extends ACCSGUI.ButtonEvent
{
	// {{{RME classAttribute 'savedPort'
	public static EnableEngine.Conjugate savedPort;
	// }}}RME
	// {{{RME operation 'InjectEventEngine(EnableEngine.Conjugate)'
	public InjectEventEngine( EnableEngine.Conjugate savedPort )
	{
		this.savedPort = savedPort;
	}
	// }}}RME
	// {{{RME operation 'buttonClicked(int)'
	public void buttonClicked( int button )
	{
		switch (button){
			case ButtonValues.btnEnable :
				savedPort.Enable().send();
				break;
			case ButtonValues.btnDisable :
				savedPort.Disable().send();
				break;

			default:
				break;
		}

	}
	// }}}RME
}
// }}}RME
