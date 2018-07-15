package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::TmpFunctionParams'
public class TmpFunctionParams extends com.rational.rosert.Capsule
{
	protected ACCSSystem.Parameters.Base In;
	protected ACCSSystem.Parameters.Conjugate OutSpeed;
	protected ACCSSystem.Parameters.Conjugate OutThrottle;
	// {{{RME transition ':TOP:Initial:Initial'
	protected void rtTransition0_Initial()
	{
		// functional parameters
		InjectEventFunctionParams event = new InjectEventFunctionParams( (Parameters.Conjugate) rtGetMsgData() );
		CommandLeverSensor.gui.addButtonEventSpeedParams(event);
		CommandLeverSensor.gui.addButtonEventThrottleParams(event);
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDEFCBB0040:params'
	protected void rtTransition1_params()
	{
		if(CommandLeverSensor.gui.speedFP){
			OutSpeed.FunctionParams((FunctionParameters) rtGetMsgData()).send();
			CommandLeverSensor.gui.speedFP = false;
		} else {
			OutThrottle.FunctionParams((FunctionParameters) rtGetMsgData()).send();
		}


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
	protected void chain1_params()
	{
		rtChainBegin( 2, "params" );
		rtExitState();
		rtTransitionBegin();
		rtTransition1_params();
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
					case ACCSSystem.Parameters.Base.rti_FunctionParams:
						chain1_params();
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
		case 1: // OutSpeed
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.OutSpeed, index );
			break;
		case 2: // OutThrottle
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.OutThrottle, index );
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
			return ACCSSystem.Parameters.Base.rtDescriptor;
		case 1:
			return ACCSSystem.Parameters.Conjugate.rtDescriptor;
		case 2:
			return ACCSSystem.Parameters.Conjugate.rtDescriptor;
		default:
			return super.rtGetRelayProtocol( relay );
		}

	}
	protected int rtGetRelayCount()
	{
		return 3;
	}
	protected int rtGetRelayCardinality( int relay )
	{
		switch( relay )
		{
		case 0: // In
			return 1;
		case 1: // OutSpeed
			return 1;
		case 2: // OutThrottle
			return 1;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		In = new ACCSSystem.Parameters.Base
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		OutSpeed = new ACCSSystem.Parameters.Conjugate
		(
			this,
			1, // cardinality
			( 2 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		OutThrottle = new ACCSSystem.Parameters.Conjugate
		(
			this,
			1, // cardinality
			( 3 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
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
		list.add( this.OutSpeed );
		list.add( this.OutThrottle );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "In";
		case 2:
			return "OutSpeed";
		case 3:
			return "OutThrottle";
		default:
			return super.rtGetPortName( port );
		}
	}
}
// }}}RME
