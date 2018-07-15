package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::TmpCommand'
public class TmpCommand extends com.rational.rosert.Capsule
{
	protected ACCSSystem.LeverCommand.Base In;
	protected ACCSSystem.LeverCommand.Conjugate Out;
	// {{{RME transition ':TOP:Initial:Initial'
	protected void rtTransition0_Initial()
	{
		// command
		InjectEventCommand event = new InjectEventCommand( (LeverCommand.Conjugate) rtGetMsgData() );
		CommandLeverSensor.gui.addButtonEventActivate(event);
		CommandLeverSensor.gui.addButtonEventDeactivate(event);
		CommandLeverSensor.gui.addButtonEventStartAcc(event);
		CommandLeverSensor.gui.addButtonEventStopAcc(event);
		CommandLeverSensor.gui.addButtonEventResume(event);
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDED10402FF:Activate'
	protected void rtTransition1_Activate()
	{
		Out.Enable().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDED1060253:Deactivate'
	protected void rtTransition2_Deactivate()
	{
		Out.Disable().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDED10900BD:StartAcc'
	protected void rtTransition3_StartAcc()
	{
		Out.StartAccIn().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDED10E00AB:StopAcc'
	protected void rtTransition4_StopAcc()
	{
		Out.StopAccIn().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Recieve:J4FDED11201D6:Resume'
	protected void rtTransition5_Resume()
	{
		Out.ResumeIn().send();
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
	protected void chain1_Activate()
	{
		rtChainBegin( 2, "Activate" );
		rtExitState();
		rtTransitionBegin();
		rtTransition1_Activate();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain2_Deactivate()
	{
		rtChainBegin( 2, "Deactivate" );
		rtExitState();
		rtTransitionBegin();
		rtTransition2_Deactivate();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain3_StartAcc()
	{
		rtChainBegin( 2, "StartAcc" );
		rtExitState();
		rtTransitionBegin();
		rtTransition3_StartAcc();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain4_StopAcc()
	{
		rtChainBegin( 2, "StopAcc" );
		rtExitState();
		rtTransitionBegin();
		rtTransition4_StopAcc();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain5_Resume()
	{
		rtChainBegin( 2, "Resume" );
		rtExitState();
		rtTransitionBegin();
		rtTransition5_Resume();
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
					case ACCSSystem.LeverCommand.Base.rti_Enable:
						chain1_Activate();
						return;
					case ACCSSystem.LeverCommand.Base.rti_StartAccIn:
						chain3_StartAcc();
						return;
					case ACCSSystem.LeverCommand.Base.rti_StopAccIn:
						chain4_StopAcc();
						return;
					case ACCSSystem.LeverCommand.Base.rti_ResumeIn:
						chain5_Resume();
						return;
					case ACCSSystem.LeverCommand.Base.rti_Disable:
						chain2_Deactivate();
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
			return ACCSSystem.LeverCommand.Base.rtDescriptor;
		case 1:
			return ACCSSystem.LeverCommand.Conjugate.rtDescriptor;
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

		In = new ACCSSystem.LeverCommand.Base
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Out = new ACCSSystem.LeverCommand.Conjugate
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
