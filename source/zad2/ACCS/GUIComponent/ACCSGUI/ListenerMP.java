package ACCSGUI;
import ACCSGUI.ButtonEvent;
import ACCSSystem.ManualParameters;
// {{{RME classifier 'Logical View::ACCSGUI::ListenerMP'
public class ListenerMP extends java.awt.event.MouseAdapter
{
	// {{{RME classAttribute 'app'
	private ACCSGUIPanel app;
	// }}}RME
	// {{{RME classAttribute 'eventHandler'
	private ButtonEvent eventHandler;
	// }}}RME
	// {{{RME operation 'ListenerMP(ACCSGUIPanel,ButtonEvent)'
	public ListenerMP( ACCSGUIPanel app, ButtonEvent eventHandler )
	{
		this.app = app;
		this.eventHandler = eventHandler;
	}
	// }}}RME
	// {{{RME operation 'mouseClicked(java.awt.event.MouseEvent )'
	public void mouseClicked( java.awt.event.MouseEvent  e )
	{
		ManualParameters params = new ManualParameters(app.speedManual, app.throttleManual);
		eventHandler.buttonClicked(app.lastButtonClicked, params);
	}
	// }}}RME
}
// }}}RME
