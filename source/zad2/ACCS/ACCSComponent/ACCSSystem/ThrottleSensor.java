package ACCSSystem;
import ACCSSystem.WheelShaftSensor;
import ACCSSystem.ThrottleActuator;
// {{{RME classifier 'Logical View::ACCSSystem::ThrottleSensor'
public class ThrottleSensor extends com.rational.rosert.Capsule
{
	// {{{RME classAttribute 'ts'
	private int ts = 200;
	// }}}RME
	// {{{RME classAttribute '_voltage'
	private static int _voltage = 0;
	// }}}RME
	// {{{RME classAttribute 'ta'
	private int ta = 1000;
	// }}}RME
	// {{{RME classAttribute '_lastVoltage'
	private int _lastVoltage = 0;
	// }}}RME
	// {{{RME classAttribute '_a'
	private int _a = 80;
	// }}}RME
	// {{{RME classAttribute '_w'
	private double _w = 0.5;
	// }}}RME
	// {{{RME classAttribute 'time'
	private long time = 0;
	// }}}RME
	// {{{RME classAttribute 'commandLeverActivated'
	private boolean commandLeverActivated = false;
	// }}}RME
	protected com.rational.rosert.Timing.Base timer;
	protected ACCSSystem.Parameters.Base Manual_Parameters;
	protected ACCSSystem.EnableEngine.Base Enable_Engine;
	protected ACCSSystem.Voltage.Base Actual_Voltage;
	protected ACCSSystem.Parameters.Base Function_Parameters;
	protected ACCSSystem.LeverCommand.Conjugate RecieveCommand;
	// {{{RME operation 'calculateNewVoltage()'
	private int calculateNewVoltage()
	{
		int _newVoltage = 0;

		if(commandLeverActivated){
			_newVoltage = (int) (
				((int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000))
					 + ThrottleActuator.getActualVoltage()) / 2);
		} else {
			_newVoltage = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));
		}

		time += ts;
		return _newVoltage;
	}
	// }}}RME
	// {{{RME operation 'checkForError(int,int)'
	private void checkForError( int lastVoltage, int newVoltage )
	{
		if(java.lang.Math.abs(lastVoltage - newVoltage) > 8){
			CommandLeverSensor.gui.setErrorMsg("ERORR: unexpected voltage");
			// roll back to previous safe state
			_voltage = _lastVoltage;
		} else {
			CommandLeverSensor.gui.clearErrorMsg();
		}
	}
	// }}}RME
	// {{{RME operation 'getActualVoltage()'
	public static int getActualVoltage()
	{
		return _voltage;
	}
	// }}}RME
	// {{{RME transition ':TOP:Initial:Initial'
	protected void rtTransition0_Initial()
	{
		_a = 80;
		_w = 0.5;
		ta = 1000;
		ts = 200;
		_voltage = _lastVoltage = 0;
	}
	// }}}RME
	// {{{RME transition ':TOP:Deactivated:J4FCF843C0139:activate'
	protected void rtTransition1_activate()
	{
		timer.informAt(ts + java.lang.System.currentTimeMillis() ); 
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCF8449006E:deactivate'
	protected void rtTransition2_deactivate()
	{
		time = 0;
		_voltage = _lastVoltage = 0;
		CommandLeverSensor.gui.setActualVoltage(_voltage);
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCF8457031E:readSensor'
	protected void rtTransition3_readSensor()
	{
		ta-= ts;
		checkForError(_lastVoltage,_voltage);

		if(ta == 0){
			Actual_Voltage.ActualVoltage(_voltage).send();
			CommandLeverSensor.gui.setActualVoltage(_voltage);

			// if one sec expired we have to send new Voltage
			int _newVoltage = calculateNewVoltage();

			if(_newVoltage - _voltage > 8){
				_lastVoltage = (_voltage += 8);
			} else if(_newVoltage - _voltage < -8){
				_lastVoltage = (_voltage -= 8);
			} else {
				_lastVoltage = (_voltage = _newVoltage);
			}

			ta = 1000;

		}

		timer.informAt(ts + java.lang.System.currentTimeMillis() ); 
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCF84AD037C:manualThrottleInitialization'
	protected void rtTransition4_manualThrottleInitialization()
	{
		_voltage = ((ManualParameters)rtGetMsgData())._manualThrottleVoltage;
		Actual_Voltage.ActualVoltage(_voltage).send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Deactivated:J4FD0A747010B:parameterInitialization'
	protected void rtTransition5_parameterInitialization()
	{
		_a =((FunctionParameters)rtGetMsgData())._a;
		_w =((FunctionParameters)rtGetMsgData())._w;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FD0A7610169:parameterInitialization'
	protected void rtTransition6_parameterInitialization()
	{
		_w =((FunctionParameters)rtGetMsgData())._w;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FD0B04A037C:leverActivated'
	protected void rtTransition7_leverActivated()
	{
		commandLeverActivated = true;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FD0B09702A1:leverDeactivated'
	protected void rtTransition8_leverDeactivated()
	{
		commandLeverActivated = false;
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
		rtTransition0_Initial();
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
		rtTransition2_deactivate();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain3_readSensor()
	{
		rtChainBegin( 3, "readSensor" );
		rtExitState();
		rtTransitionBegin();
		rtTransition3_readSensor();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain4_manualThrottleInitialization()
	{
		rtChainBegin( 3, "manualThrottleInitialization" );
		rtExitState();
		rtTransitionBegin();
		rtTransition4_manualThrottleInitialization();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain5_parameterInitialization()
	{
		rtChainBegin( 2, "parameterInitialization" );
		rtExitState();
		rtTransitionBegin();
		rtTransition5_parameterInitialization();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain6_parameterInitialization()
	{
		rtChainBegin( 3, "parameterInitialization" );
		rtExitState();
		rtTransitionBegin();
		rtTransition6_parameterInitialization();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain7_leverActivated()
	{
		rtChainBegin( 3, "leverActivated" );
		rtExitState();
		rtTransitionBegin();
		rtTransition7_leverActivated();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain8_leverDeactivated()
	{
		rtChainBegin( 3, "leverDeactivated" );
		rtExitState();
		rtTransitionBegin();
		rtTransition8_leverDeactivated();
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
				case 3: // Enable_Engine
					switch( signal )
					{
					case ACCSSystem.EnableEngine.Base.rti_Enable:
						chain1_activate();
						return;
					default:
						break;
					}
					break;
				case 5: // Function_Parameters
					switch( signal )
					{
					case ACCSSystem.Parameters.Base.rti_FunctionParams:
						chain5_parameterInitialization();
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
				case 1: // timer
					switch( signal )
					{
					case com.rational.rosert.Timing.Base.rti_timeout:
						chain3_readSensor();
						return;
					default:
						break;
					}
					break;
				case 2: // Manual_Parameters
					switch( signal )
					{
					case ACCSSystem.Parameters.Base.rti_ManualParamrs:
						chain4_manualThrottleInitialization();
						return;
					default:
						break;
					}
					break;
				case 3: // Enable_Engine
					switch( signal )
					{
					case ACCSSystem.EnableEngine.Base.rti_Disable:
						chain2_deactivate();
						return;
					default:
						break;
					}
					break;
				case 5: // Function_Parameters
					switch( signal )
					{
					case ACCSSystem.Parameters.Base.rti_FunctionParams:
						chain6_parameterInitialization();
						return;
					default:
						break;
					}
					break;
				case 6: // RecieveCommand
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Conjugate.rti_Activate:
						chain7_leverActivated();
						return;
					case ACCSSystem.LeverCommand.Conjugate.rti_Deactivate:
						chain8_leverDeactivated();
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
		case 0: // Manual_Parameters
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Manual_Parameters, index );
			break;
		case 1: // Enable_Engine
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Enable_Engine, index );
			break;
		case 2: // Actual_Voltage
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Actual_Voltage, index );
			break;
		case 3: // Function_Parameters
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Function_Parameters, index );
			break;
		case 4: // RecieveCommand
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.RecieveCommand, index );
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
			return ACCSSystem.EnableEngine.Base.rtDescriptor;
		case 2:
			return ACCSSystem.Voltage.Base.rtDescriptor;
		case 3:
			return ACCSSystem.Parameters.Base.rtDescriptor;
		case 4:
			return ACCSSystem.LeverCommand.Conjugate.rtDescriptor;
		default:
			return super.rtGetRelayProtocol( relay );
		}

	}
	protected int rtGetRelayCount()
	{
		return 5;
	}
	protected int rtGetRelayCardinality( int relay )
	{
		switch( relay )
		{
		case 0: // Manual_Parameters
			return 1;
		case 1: // Enable_Engine
			return 1;
		case 2: // Actual_Voltage
			return 1;
		case 3: // Function_Parameters
			return 1;
		case 4: // RecieveCommand
			return 1;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		timer = new com.rational.rosert.Timing.Base
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterAutoUnlockedUnpublished
				+ com.rational.rosert.Capsule.PortDescriptor.Unwired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		Manual_Parameters = new ACCSSystem.Parameters.Base
		(
			this,
			1, // cardinality
			( 2 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Enable_Engine = new ACCSSystem.EnableEngine.Base
		(
			this,
			1, // cardinality
			( 3 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Actual_Voltage = new ACCSSystem.Voltage.Base
		(
			this,
			1, // cardinality
			( 4 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Function_Parameters = new ACCSSystem.Parameters.Base
		(
			this,
			1, // cardinality
			( 5 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		RecieveCommand = new ACCSSystem.LeverCommand.Conjugate
		(
			this,
			1, // cardinality
			( 6 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);

	}
	protected void rtEnumeratePorts( com.rational.rosert.Capsule.PortList list )
	{
		super.rtEnumeratePorts( list );
		list.add( this.timer );
		list.add( this.Manual_Parameters );
		list.add( this.Enable_Engine );
		list.add( this.Actual_Voltage );
		list.add( this.Function_Parameters );
		list.add( this.RecieveCommand );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "timer";
		case 2:
			return "Manual_Parameters";
		case 3:
			return "Enable_Engine";
		case 4:
			return "Actual_Voltage";
		case 5:
			return "Function_Parameters";
		case 6:
			return "RecieveCommand";
		default:
			return super.rtGetPortName( port );
		}
	}
	protected void rtEnumerateAttributes( com.rational.rosert.AttributeList list, com.rational.rosert.ExtendedAttributeList extended )
	{
		super.rtEnumerateAttributes( list, extended );
		this.ts = (int)list.add( "ts", this.ts );
		this._voltage = (int)list.add( "_voltage", this._voltage );
		this.ta = (int)list.add( "ta", this.ta );
		this._lastVoltage = (int)list.add( "_lastVoltage", this._lastVoltage );
		this._a = (int)list.add( "_a", this._a );
		if( extended != null )
			this._w = (double)extended.add( "_w", this._w );
		this.time = (long)list.add( "time", this.time );
		this.commandLeverActivated = (boolean)list.add( "commandLeverActivated", this.commandLeverActivated );

	}
}
// }}}RME
