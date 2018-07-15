package ACCSGUI;
import ACCSGUI.ButtonEvent;
import ACCSSystem.FunctionParameters;
// {{{RME classifier 'Logical View::ACCSGUI::ListenerFP'
public class ListenerFP extends java.awt.event.MouseAdapter
{
	// {{{RME classAttribute 'app'
	private ACCSGUIPanel app;
	// }}}RME
	// {{{RME classAttribute 'eventHandler'
	private ButtonEvent eventHandler;
	// }}}RME
	// {{{RME operation 'ListenerFP(ACCSGUIPanel,ButtonEvent)'
	public ListenerFP( ACCSGUIPanel app, ButtonEvent eventHandler )
	{
		this.app = app;
		this.eventHandler = eventHandler;
	}
	// }}}RME
	// {{{RME operation 'mouseClicked(java.awt.event.MouseEvent )'
	public void mouseClicked( java.awt.event.MouseEvent  e )
	{
		FunctionParameters params;
		app.getW();
		if(app.speedFP){
			 params = new FunctionParameters(app.wSpeed);
		} else {
			 params = new FunctionParameters(app.wThrottle);
		}

		app.speedFP = false;
		eventHandler.buttonClicked(app.lastButtonClicked, params);
	}
	// }}}RME
}
// }}}RME
