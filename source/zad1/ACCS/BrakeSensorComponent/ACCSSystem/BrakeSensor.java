package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::BrakeSensor'
public class BrakeSensor extends com.rational.rosert.Capsule
{
	protected ACCSSystem.BrakeInterrupt.Base Brake_Interrupt;
	protected ACCSSystem.BrakeInterrupt.Base Apply_Brake;
	// {{{RME transition ':TOP:BrakeOff:J4FC504B10138:BrakeApplied'
	protected void rtTransition1_BrakeApplied()
	{
		Brake_Interrupt.BrakeApplied().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:BrakeOff:J4FC504B10138:BrakeApplied' guard '1'
	protected boolean rtGuard1_BrakeApplied_event0()
	{
		return (java.lang.Boolean)rtGetMsgData()==true;
	}
	// }}}RME
	// {{{RME transition ':TOP:BrakeOn:J4FC504DF0020:BrakeReleased'
	protected void rtTransition2_BrakeReleased()
	{
		Brake_Interrupt.BrakeReleased().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:BrakeOn:J4FC504DF0020:BrakeReleased' guard '1'
	protected boolean rtGuard2_BrakeReleased_event0()
	{
		return (java.lang.Boolean)rtGetMsgData()==false;
	}
	// }}}RME
	protected void rtDescribeBehavior( com.rational.rosert.Capsule.BehaviorInfo info )
	{
		super.rtDescribeBehavior( info );

		info.includeState( 2, "BrakeOff", 1 );
		info.includeState( 3, "BrakeOn", 1 );

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
	protected void chain1_BrakeApplied()
	{
		rtChainBegin( 2, "BrakeApplied" );
		rtExitState();
		rtTransitionBegin();
		rtTransition1_BrakeApplied();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain2_BrakeReleased()
	{
		rtChainBegin( 3, "BrakeReleased" );
		rtExitState();
		rtTransitionBegin();
		rtTransition2_BrakeReleased();
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
				// {{{RME state ':TOP:BrakeOff'
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
				case 2: // Apply_Brake
					switch( signal )
					{
					case ACCSSystem.BrakeInterrupt.Base.rti_ApplyBrake:
						if( rtGuard1_BrakeApplied_event0() )
						{
							chain1_BrakeApplied();
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
				// {{{RME state ':TOP:BrakeOn'
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
				case 2: // Apply_Brake
					switch( signal )
					{
					case ACCSSystem.BrakeInterrupt.Base.rti_ApplyBrake:
						if( rtGuard2_BrakeReleased_event0() )
						{
							chain2_BrakeReleased();
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
		case 0: // Brake_Interrupt
			if( index < 2 )
				return new com.rational.rosert.BindingEnd( this.Brake_Interrupt, index );
			break;
		case 1: // Apply_Brake
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Apply_Brake, index );
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
			return ACCSSystem.BrakeInterrupt.Base.rtDescriptor;
		case 1:
			return ACCSSystem.BrakeInterrupt.Base.rtDescriptor;
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
		case 0: // Brake_Interrupt
			return 2;
		case 1: // Apply_Brake
			return 1;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		Brake_Interrupt = new ACCSSystem.BrakeInterrupt.Base
		(
			this,
			2, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Apply_Brake = new ACCSSystem.BrakeInterrupt.Base
		(
			this,
			1, // cardinality
			( 2 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationEnabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);

	}
	protected void rtEnumeratePorts( com.rational.rosert.Capsule.PortList list )
	{
		super.rtEnumeratePorts( list );
		list.add( this.Brake_Interrupt );
		list.add( this.Apply_Brake );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "Brake_Interrupt";
		case 2:
			return "Apply_Brake";
		default:
			return super.rtGetPortName( port );
		}
	}
}
// }}}RME
