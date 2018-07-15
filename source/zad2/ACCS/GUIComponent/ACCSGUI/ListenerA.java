package ACCSGUI;
import ACCSGUI.ButtonEvent;
// {{{RME classifier 'Logical View::ACCSGUI::ListenerA'
public class ListenerA extends java.awt.event.MouseAdapter
{
	// {{{RME classAttribute 'app'
	private ACCSGUIPanel app;
	// }}}RME
	// {{{RME classAttribute 'eventHandler'
	private ButtonEvent eventHandler;
	// }}}RME
	// {{{RME operation 'ListenerA(ACCSGUIPanel,ButtonEvent)'
	public ListenerA( ACCSGUIPanel app, ButtonEvent eventHandler )
	{
		this.app = app;
		this.eventHandler = eventHandler;
	}
	// }}}RME
	// {{{RME operation 'mouseClicked(java.awt.event.MouseEvent )'
	public void mouseClicked( java.awt.event.MouseEvent  e )
	{
		eventHandler.buttonClicked(app.lastButtonClicked);
	}
	// }}}RME
}
// }}}RME
