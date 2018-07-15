package ACCSSystem;
import ACCSSystem.WheelShaftSensor;
// {{{RME classifier 'Logical View::ACCSSystem::ThrottleActuator'
public class ThrottleActuator extends com.rational.rosert.Capsule
{
	// {{{RME classAttribute '_currSpeed'
	private int _currSpeed = 0;
	// }}}RME
	// {{{RME classAttribute '_savedSpeed'
	private static int _savedSpeed = 140;
	// }}}RME
	// {{{RME classAttribute '_currVoltage'
	private static int _currVoltage = 0;
	// }}}RME
	// {{{RME classAttribute '_lastVoltage'
	private int _lastVoltage = 0;
	// }}}RME
	// {{{RME classAttribute 'ta'
	private int ta = 1000;
	// }}}RME
	protected ACCSSystem.CurrentSpeed.Conjugate Curr_Speed;
	protected ACCSSystem.LeverCommand.Conjugate Command;
	protected com.rational.rosert.Timing.Base timer;
	protected ACCSSystem.Voltage.Base ACCS_Voltage;
	protected ACCSSystem.Voltage.Base Actual_Voltage;
	// {{{RME operation 'getSavedSpeed()'
	public static int getSavedSpeed()
	{
		return _savedSpeed;
	}
	// }}}RME
	// {{{RME operation 'setSavedSpeed(int)'
	public static void setSavedSpeed( int savedSpeed )
	{
		_savedSpeed = savedSpeed;
	}
	// }}}RME
	// {{{RME operation 'getActualVoltage()'
	public static int getActualVoltage()
	{
		return _currVoltage;
	}
	// }}}RME
	// {{{RME transition ':TOP:Deactivated:J4FCF013703C9:activate'
	protected void rtTransition1_activate()
	{
		timer.informAt(ta + java.lang.System.currentTimeMillis() );
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCF0BAA02A1:calculateVoltage'
	protected void rtTransition3_calculateVoltage()
	{
		_currSpeed = WheelShaftSensor.getCurrSpeed();

		if((200 - _currSpeed) > 2 && _savedSpeed != _currSpeed){
			_currVoltage = 80;
			ACCS_Voltage.ACCSVoltage(_currVoltage).send();

			if((_currVoltage - _lastVoltage) > 8){
				// for comfort accelerating
				_currVoltage = (_lastVoltage += 8);
			}
		} else if((_savedSpeed - _currSpeed) < -2){
			_currVoltage = 0;
			ACCS_Voltage.ACCSVoltage(_currVoltage).send();

			// for comfort accelerating
			if((_lastVoltage - _currVoltage) > 8){
				_currVoltage = (_lastVoltage -= 8);
			} else {
				_lastVoltage = _currVoltage;
			}
		} else {
			_currVoltage = 2*(_savedSpeed - _currSpeed + 2);
			ACCS_Voltage.ACCSVoltage(_currVoltage).send();

			if((_lastVoltage - _currVoltage) > 8){
				// for comfort accelerating
				_currVoltage = (_lastVoltage -= 8);
			} else if((_currVoltage - _lastVoltage) > 8){
				// for comfort accelerating
				_currVoltage = (_lastVoltage += 8);
			}else {
				_lastVoltage = _currVoltage;
			}
		}

		Actual_Voltage.ActualVoltage(_currVoltage).send();
		timer.informAt(ta + java.lang.System.currentTimeMillis() ); 
	}
	// }}}RME
	protected void rtDescribeBehavior( com.rational.rosert.Capsule.BehaviorInfo info )
	{
		super.rtDescribeBehavior( info );

		info.includeState( 2, "Deactivated", 1 );
		info.includeState( 3, "Activated", 1 );

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
	protected void chain1_activate()
	{
		rtChainBegin( 2, "activate" );
		rtExitState();
		rtTransitionBegin();
		rtTransition1_activate();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain2_deactivate()
	{
		rtChainBegin( 3, "deactivate" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain3_calculateVoltage()
	{
		rtChainBegin( 3, "calculateVoltage" );
		rtExitState();
		rtTransitionBegin();
		rtTransition3_calculateVoltage();
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
				// {{{RME state ':TOP:Deactivated'
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
				case 2: // Command
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Conjugate.rti_Activate:
						chain1_activate();
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
			case 3:
				// {{{RME state ':TOP:Activated'
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
				case 2: // Command
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Conjugate.rti_Deactivate:
						chain2_deactivate();
						return;
					default:
						break;
					}
					break;
				case 3: // timer
					switch( signal )
					{
					case com.rational.rosert.Timing.Base.rti_timeout:
						chain3_calculateVoltage();
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
		case 0: // Curr_Speed
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Curr_Speed, index );
			break;
		case 1: // Command
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Command, index );
			break;
		case 2: // ACCS_Voltage
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.ACCS_Voltage, index );
			break;
		case 3: // Actual_Voltage
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Actual_Voltage, index );
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
			return ACCSSystem.CurrentSpeed.Conjugate.rtDescriptor;
		case 1:
			return ACCSSystem.LeverCommand.Conjugate.rtDescriptor;
		case 2:
			return ACCSSystem.Voltage.Base.rtDescriptor;
		case 3:
			return ACCSSystem.Voltage.Base.rtDescriptor;
		default:
			return super.rtGetRelayProtocol( relay );
		}

	}
	protected int rtGetRelayCount()
	{
		return 4;
	}
	protected int rtGetRelayCardinality( int relay )
	{
		switch( relay )
		{
		case 0: // Curr_Speed
			return 1;
		case 1: // Command
			return 1;
		case 2: // ACCS_Voltage
			return 1;
		case 3: // Actual_Voltage
			return 1;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		Curr_Speed = new ACCSSystem.CurrentSpeed.Conjugate
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Command = new ACCSSystem.LeverCommand.Conjugate
		(
			this,
			1, // cardinality
			( 2 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		timer = new com.rational.rosert.Timing.Base
		(
			this,
			1, // cardinality
			( 3 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterAutoUnlockedUnpublished
				+ com.rational.rosert.Capsule.PortDescriptor.Unwired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		ACCS_Voltage = new ACCSSystem.Voltage.Base
		(
			this,
			1, // cardinality
			( 4 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Actual_Voltage = new ACCSSystem.Voltage.Base
		(
			this,
			1, // cardinality
			( 5 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);

	}
	protected void rtEnumeratePorts( com.rational.rosert.Capsule.PortList list )
	{
		super.rtEnumeratePorts( list );
		list.add( this.Curr_Speed );
		list.add( this.Command );
		list.add( this.timer );
		list.add( this.ACCS_Voltage );
		list.add( this.Actual_Voltage );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "Curr_Speed";
		case 2:
			return "Command";
		case 3:
			return "timer";
		case 4:
			return "ACCS_Voltage";
		case 5:
			return "Actual_Voltage";
		default:
			return super.rtGetPortName( port );
		}
	}
	protected void rtEnumerateAttributes( com.rational.rosert.AttributeList list, com.rational.rosert.ExtendedAttributeList extended )
	{
		super.rtEnumerateAttributes( list, extended );
		this._currSpeed = (int)list.add( "_currSpeed", this._currSpeed );
		this._savedSpeed = (int)list.add( "_savedSpeed", this._savedSpeed );
		this._currVoltage = (int)list.add( "_currVoltage", this._currVoltage );
		this._lastVoltage = (int)list.add( "_lastVoltage", this._lastVoltage );
		this.ta = (int)list.add( "ta", this.ta );

	}
}
// }}}RME
