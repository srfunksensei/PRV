package ACCSSystem;
import ACCSSystem.CommandLeverSensor;
// {{{RME classifier 'Logical View::ACCSSystem::EngineSensor'
public class EngineSensor extends com.rational.rosert.Capsule
{
	protected ACCSSystem.EnableEngine.Base ToggleEngine;
	protected ACCSSystem.EnableEngine.Base Enable_Engine;
	// {{{RME transition ':TOP:EngineOff:J4FC4E62C02EF:turnOn'
	protected void rtTransition1_turnOn()
	{
		ToggleEngine.Engine_on().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:EngineOff:J4FC4E62C02EF:turnOn' guard '1'
	protected boolean rtGuard1_turnOn_event0()
	{
		return (java.lang.Boolean)rtGetMsgData()==true;
	}
	// }}}RME
	// {{{RME transition ':TOP:EngineOn:J4FC4E6570020:turnOff'
	protected void rtTransition2_turnOff()
	{
		ToggleEngine.Engine_off().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:EngineOn:J4FC4E6570020:turnOff' guard '1'
	protected boolean rtGuard2_turnOff_event0()
	{
		return (java.lang.Boolean)rtGetMsgData()==false;
	}
	// }}}RME
	protected void rtDescribeBehavior( com.rational.rosert.Capsule.BehaviorInfo info )
	{
		super.rtDescribeBehavior( info );

		info.includeState( 2, "EngineOn", 1 );
		info.includeState( 3, "EngineOff", 1 );

	}
	protected int rtGetStateCount()
	{
		return 3;
	}
	protected int rtGetStateDepth()
	{
		return 1;
	}
	protected void chain0_Initial()
	{
		rtChainBegin( 1, "Initial" );
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain1_turnOn()
	{
		rtChainBegin( 3, "turnOn" );
		rtExitState();
		rtTransitionBegin();
		rtTransition1_turnOn();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain2_turnOff()
	{
		rtChainBegin( 2, "turnOff" );
		rtExitState();
		rtTransitionBegin();
		rtTransition2_turnOff();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	public void rtBehavior( int signal, int port, int state )
	{
		for(;;)
		{
			switch( state )
			{
			case 1:
				// {{{RME state ':TOP'
				switch( port )
				{
				case 0: // system port
					switch( signal )
					{
					case 1: // init
						chain0_Initial();
						return;
					default:
						break;
					}
					break;
				default:
					break;
				}
				rtUnexpectedMessage();
				return;
				// }}}RME
			case 2:
				// {{{RME state ':TOP:EngineOn'
				switch( port )
				{
				case 0: // system port
					switch( signal )
					{
					case 1: // init
						return;
					default:
						break;
					}
					break;
				case 2: // Enable_Engine
					switch( signal )
					{
					case ACCSSystem.EnableEngine.Base.rti_Enable:
						if( rtGuard2_turnOff_event0() )
						{
							chain2_turnOff();
							return;
						}
						break;
					default:
						break;
					}
					break;
				default:
					break;
				}
				state = 1;
				break;
				// }}}RME
			case 3:
				// {{{RME state ':TOP:EngineOff'
				switch( port )
				{
				case 0: // system port
					switch( signal )
					{
					case 1: // init
						return;
					default:
						break;
					}
					break;
				case 2: // Enable_Engine
					switch( signal )
					{
					case ACCSSystem.EnableEngine.Base.rti_Enable:
						if( rtGuard1_turnOn_event0() )
						{
							chain1_turnOn();
							return;
						}
						break;
					default:
						break;
					}
					break;
				default:
					break;
				}
				state = 1;
				break;
				// }}}RME
			default:
				rtUnexpectedState();
				return;
			}
		}

	}
	protected com.rational.rosert.BindingEnd rtFollowInV( int relay, int index )
	{
		switch( relay )
		{
		case 0: // ToggleEngine
			if( index < 3 )
				return new com.rational.rosert.BindingEnd( this.ToggleEngine, index );
			break;
		case 1: // Enable_Engine
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Enable_Engine, index );
			break;
		default:
			break;
		}
		return super.rtFollowInV( relay, index );
	}
	protected com.rational.rosert.ProtocolRole.Descriptor rtGetRelayProtocol( int relay )
	{
		switch( relay )
		{
		case 0:
			return ACCSSystem.EnableEngine.Base.rtDescriptor;
		case 1:
			return ACCSSystem.EnableEngine.Base.rtDescriptor;
		default:
			return super.rtGetRelayProtocol( relay );
		}

	}
	protected int rtGetRelayCount()
	{
		return 2;
	}
	protected int rtGetRelayCardinality( int relay )
	{
		switch( relay )
		{
		case 0: // ToggleEngine
			return 3;
		case 1: // Enable_Engine
			return 1;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		ToggleEngine = new ACCSSystem.EnableEngine.Base
		(
			this,
			3, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Enable_Engine = new ACCSSystem.EnableEngine.Base
		(
			this,
			1, // cardinality
			( 2 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);

	}
	protected void rtEnumeratePorts( com.rational.rosert.Capsule.PortList list )
	{
		super.rtEnumeratePorts( list );
		list.add( this.ToggleEngine );
		list.add( this.Enable_Engine );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "ToggleEngine";
		case 2:
			return "Enable_Engine";
		default:
			return super.rtGetPortName( port );
		}
	}
}
// }}}RME
