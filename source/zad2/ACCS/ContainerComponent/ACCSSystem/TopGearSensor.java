package ACCSSystem;
import ACCSSystem.CommandLeverSensor;
import ACCSSystem.WheelShaftSensor;
// {{{RME classifier 'Logical View::ACCSSystem::TopGearSensor'
public class TopGearSensor extends com.rational.rosert.Capsule
{
	protected ACCSSystem.EnableTopGear.Base TopGearEngage;
	protected ACCSSystem.EnableTopGear.Base ToggleTopGear;
	// {{{RME transition ':TOP:TopGearDisengaged:J4FC72AEC01E5:EngageTopGear'
	protected void rtTransition1_EngageTopGear()
	{
		ToggleTopGear.TopGearEngaged().send();
		CommandLeverSensor.setTopGearEngaged(true);
		WheelShaftSensor.setTopGearEngaged(true);
	}
	// }}}RME
	// {{{RME transition ':TOP:TopGearDisengaged:J4FC72AEC01E5:EngageTopGear' guard '1'
	protected boolean rtGuard1_EngageTopGear_event0()
	{
		return (java.lang.Boolean)rtGetMsgData()==true;
	}
	// }}}RME
	// {{{RME transition ':TOP:TopGearEngaged:J4FC72B130281:DisengageTopGear'
	protected void rtTransition2_DisengageTopGear()
	{
		ToggleTopGear.TopGearDisengaged().send();
		CommandLeverSensor.setTopGearEngaged(false);
		WheelShaftSensor.setTopGearEngaged(false);
	}
	// }}}RME
	// {{{RME transition ':TOP:TopGearEngaged:J4FC72B130281:DisengageTopGear' guard '1'
	protected boolean rtGuard2_DisengageTopGear_event0()
	{
		return (java.lang.Boolean)rtGetMsgData()==false;
	}
	// }}}RME
	protected void rtDescribeBehavior( com.rational.rosert.Capsule.BehaviorInfo info )
	{
		super.rtDescribeBehavior( info );

		info.includeState( 2, "TopGearDisengaged", 1 );
		info.includeState( 3, "TopGearEngaged", 1 );

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
		rtEnterState( 2 );

	}
	protected void chain1_EngageTopGear()
	{
		rtChainBegin( 2, "EngageTopGear" );
		rtExitState();
		rtTransitionBegin();
		rtTransition1_EngageTopGear();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain2_DisengageTopGear()
	{
		rtChainBegin( 3, "DisengageTopGear" );
		rtExitState();
		rtTransitionBegin();
		rtTransition2_DisengageTopGear();
		rtTransitionEnd();
		rtEnterState( 2 );

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
				// {{{RME state ':TOP:TopGearDisengaged'
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
				case 1: // TopGearEngage
					switch( signal )
					{
					case ACCSSystem.EnableTopGear.Base.rti_EngageTopGear:
						if( rtGuard1_EngageTopGear_event0() )
						{
							chain1_EngageTopGear();
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
				// {{{RME state ':TOP:TopGearEngaged'
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
				case 1: // TopGearEngage
					switch( signal )
					{
					case ACCSSystem.EnableTopGear.Base.rti_EngageTopGear:
						if( rtGuard2_DisengageTopGear_event0() )
						{
							chain2_DisengageTopGear();
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
		case 0: // TopGearEngage
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.TopGearEngage, index );
			break;
		case 1: // ToggleTopGear
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.ToggleTopGear, index );
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
			return ACCSSystem.EnableTopGear.Base.rtDescriptor;
		case 1:
			return ACCSSystem.EnableTopGear.Base.rtDescriptor;
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
		case 0: // TopGearEngage
			return 1;
		case 1: // ToggleTopGear
			return 1;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		TopGearEngage = new ACCSSystem.EnableTopGear.Base
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		ToggleTopGear = new ACCSSystem.EnableTopGear.Base
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
		list.add( this.TopGearEngage );
		list.add( this.ToggleTopGear );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "TopGearEngage";
		case 2:
			return "ToggleTopGear";
		default:
			return super.rtGetPortName( port );
		}
	}
}
// }}}RME
