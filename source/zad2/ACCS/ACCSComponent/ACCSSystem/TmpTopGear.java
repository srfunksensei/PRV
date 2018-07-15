package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::TmpTopGear'
public class TmpTopGear extends com.rational.rosert.Capsule
{
	protected ACCSSystem.EnableTopGear.Base In;
	protected ACCSSystem.EnableTopGear.Conjugate Out;
	// {{{RME transition ':TOP:Initial:Initial'
	protected void rtTransition0_Initial()
	{
		// top gear
		CommandLeverSensor.gui.addButtonEventTopGear(new InjectEventTopGear( (EnableTopGear.Conjugate) rtGetMsgData() ));
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDECF6703CA:topGearEngaged'
	protected void rtTransition1_topGearEngaged()
	{
		Out.EngageTopGear().send();
		CommandLeverSensor.setTopGearEngaged(true);
		WheelShaftSensor.setTopGearEngaged(true);
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDECF6E01B5:topGearDisengaged'
	protected void rtTransition2_topGearDisengaged()
	{
		Out.DisengageTopGear().send();
		CommandLeverSensor.setTopGearEngaged(false);
		WheelShaftSensor.setTopGearEngaged(false);
	}
	// }}}RME
	protected void rtDescribeBehavior( com.rational.rosert.Capsule.BehaviorInfo info )
	{
		super.rtDescribeBehavior( info );

		info.includeState( 2, "Recieve", 1 );

	}
	protected int rtGetStateCount()
	{
		return 2;
	}
	protected int rtGetStateDepth()
	{
		return 1;
	}
	protected void chain0_Initial()
	{
		rtChainBegin( 1, "Initial" );
		rtTransitionBegin();
		rtTransition0_Initial();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain1_topGearEngaged()
	{
		rtChainBegin( 2, "topGearEngaged" );
		rtExitState();
		rtTransitionBegin();
		rtTransition1_topGearEngaged();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain2_topGearDisengaged()
	{
		rtChainBegin( 2, "topGearDisengaged" );
		rtExitState();
		rtTransitionBegin();
		rtTransition2_topGearDisengaged();
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
				// {{{RME state ':TOP:Recieve'
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
				case 1: // In
					switch( signal )
					{
					case ACCSSystem.EnableTopGear.Base.rti_EngageTopGear:
						chain1_topGearEngaged();
						return;
					case ACCSSystem.EnableTopGear.Base.rti_DisengageTopGear:
						chain2_topGearDisengaged();
						return;
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
		case 0: // In
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.In, index );
			break;
		case 1: // Out
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Out, index );
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
			return ACCSSystem.EnableTopGear.Conjugate.rtDescriptor;
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
		case 0: // In
			return 1;
		case 1: // Out
			return 1;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		In = new ACCSSystem.EnableTopGear.Base
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Out = new ACCSSystem.EnableTopGear.Conjugate
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
		list.add( this.In );
		list.add( this.Out );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "In";
		case 2:
			return "Out";
		default:
			return super.rtGetPortName( port );
		}
	}
}
// }}}RME
