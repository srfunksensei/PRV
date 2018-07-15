package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::TmpBrake'
public class TmpBrake extends com.rational.rosert.Capsule
{
	protected ACCSSystem.BrakeInterrupt.Base In;
	protected ACCSSystem.BrakeInterrupt.Conjugate Out;
	// {{{RME transition ':TOP:Initial:Initial'
	protected void rtTransition0_Initial()
	{
		// brake
		CommandLeverSensor.gui.addButtonEventBrake(new InjectEventBrake( (BrakeInterrupt.Conjugate) rtGetMsgData() ));

	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDEBFBD0271:brakeApplied'
	protected void rtTransition1_brakeApplied()
	{
		Out.ApplyBrake().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDEBFC601D6:brakeReleased'
	protected void rtTransition2_brakeReleased()
	{
		Out.ReleaseBrake().send();
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
	protected void chain1_brakeApplied()
	{
		rtChainBegin( 2, "brakeApplied" );
		rtExitState();
		rtTransitionBegin();
		rtTransition1_brakeApplied();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain2_brakeReleased()
	{
		rtChainBegin( 2, "brakeReleased" );
		rtExitState();
		rtTransitionBegin();
		rtTransition2_brakeReleased();
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
					case ACCSSystem.BrakeInterrupt.Base.rti_ApplyBrake:
						chain1_brakeApplied();
						return;
					case ACCSSystem.BrakeInterrupt.Base.rti_ReleaseBrake:
						chain2_brakeReleased();
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
			if( index < 2 )
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
			return ACCSSystem.BrakeInterrupt.Base.rtDescriptor;
		case 1:
			return ACCSSystem.BrakeInterrupt.Conjugate.rtDescriptor;
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
			return 2;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		In = new ACCSSystem.BrakeInterrupt.Base
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Out = new ACCSSystem.BrakeInterrupt.Conjugate
		(
			this,
			2, // cardinality
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
