package ACCSSystem;
import ACCSSystem.CommandLeverSensor;
import ACCSSystem.ThrottleActuator;
// {{{RME classifier 'Logical View::ACCSSystem::WheelShaftSensor'
public class WheelShaftSensor extends com.rational.rosert.Capsule
{
	// {{{RME classAttribute 'engineOn'
	private boolean engineOn = false;
	// }}}RME
	// {{{RME classAttribute 'ts'
	private int ts = 200;
	// }}}RME
	// {{{RME classAttribute '_w'
	private double _w = 0.005;
	// }}}RME
	// {{{RME classAttribute '_a'
	private int _a = 120;
	// }}}RME
	// {{{RME classAttribute '_currSpeed'
	private static int _currSpeed = 0;
	// }}}RME
	// {{{RME classAttribute 'commandLeverActivated'
	private boolean commandLeverActivated = false;
	// }}}RME
	// {{{RME classAttribute 'time'
	private long time = 0;
	// }}}RME
	// {{{RME classAttribute 'topGearActivated'
	private static boolean topGearActivated = false;
	// }}}RME
	// {{{RME classAttribute '_sinus'
	private boolean _sinus = true;
	// }}}RME
	// {{{RME classAttribute '_lastSpeed'
	private int _lastSpeed = 0;
	// }}}RME
	// {{{RME classAttribute 'resume'
	private boolean resume = false;
	// }}}RME
	// {{{RME classAttribute 'startAcc'
	private boolean startAcc = false;
	// }}}RME
	// {{{RME classAttribute '_savedSpeed'
	private static int _savedSpeed = 140;
	// }}}RME
	// {{{RME classAttribute 'brakeOn'
	private boolean brakeOn = false;
	// }}}RME
	// {{{RME classAttribute 'lastBrakeOn'
	private boolean lastBrakeOn = false;
	// }}}RME
	protected ACCSSystem.EnableEngine.Conjugate EngineEnabled;
	protected com.rational.rosert.Timing.Base timer;
	protected ACCSSystem.Parameters.Base Function_Parameters;
	protected ACCSSystem.Parameters.Base Manual_Parameters;
	protected ACCSSystem.LeverCommand.Conjugate RecieveCommand;
	protected ACCSSystem.CurrentSpeed.Base Curr_Speed;
	protected ACCSSystem.LeverCommand.Base ReachedSavedSpeed;
	protected ACCSSystem.BrakeInterrupt.Conjugate Brake_Applied;
	// {{{RME operation 'getCurrSpeed()'
	public static int getCurrSpeed()
	{
		return _currSpeed;
	}
	// }}}RME
	// {{{RME operation 'setTopGearEngaged(boolean)'
	public static void setTopGearEngaged( boolean topGearEngaged )
	{
		topGearActivated = topGearEngaged;
	}
	// }}}RME
	// {{{RME operation 'adjustSpeed(boolean)'
	private void adjustSpeed( boolean topGearEngaged )
	{
		int _newSpeed = 0;

		if(!topGearEngaged){
			_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));

			if(_newSpeed < _currSpeed && _newSpeed + 2 < _currSpeed){
				// up - up
				while(_newSpeed < _currSpeed){
					time += ts;
					_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));
				}

				// down - down
				time += 2*ts;
				_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));
				while(_newSpeed > _currSpeed){
					time += ts;
					_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));
				}

			} else if(_newSpeed > _currSpeed && _newSpeed + 2 > _currSpeed){
				while(_newSpeed > _currSpeed){
					time += ts;
					_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));
				}
			}
		} else {
			// top gear engaged
			_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;

			while(_newSpeed > _currSpeed){
				time += ts;
				_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;
			}
		}
		_currSpeed = _newSpeed;
		lastBrakeOn = false;

	}
	// }}}RME
	// {{{RME operation 'checkForError()'
	private String checkForError()
	{
		if(checkSpeed()){
			// send to display
			return "ERROR: current speed is much greather than expected!";
		}

		return "";
	}
	// }}}RME
	// {{{RME operation 'checkSpeed()'
	private boolean checkSpeed()
	{
		return (_currSpeed > _lastSpeed + 3 ) || (_currSpeed < _lastSpeed  - 3);
	}
	// }}}RME
	// {{{RME transition ':TOP:Initial:Initial'
	protected void rtTransition0_Initial()
	{
		commandLeverActivated = engineOn = resume = startAcc = topGearActivated = false;
		_currSpeed = 0;
		_savedSpeed = 140;
		_a = 120;
		_w = 0.05;
		ts = 200;
		time = 0;
	}
	// }}}RME
	// {{{RME transition ':TOP:Deactivated:J4FCA0FF5037B:activate'
	protected void rtTransition1_activate()
	{
		engineOn = true;
		timer.informAt(ts + java.lang.System.currentTimeMillis() ); 

	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCA1011033D:deactivate'
	protected void rtTransition2_deactivate()
	{
		engineOn = false;
		_currSpeed = 0;
		commandLeverActivated = false;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCB43E2004E:readSensor'
	protected void rtTransition3_readSensor()
	{
		_lastSpeed = _currSpeed;
		int _newSpeed = 0;

		if(!commandLeverActivated){	
			if(brakeOn){
				// if we are braking
				_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + (topGearActivated? 120 : 0);

				while(_newSpeed > _currSpeed){
					time += ts;
					_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + (topGearActivated? 120 : 0);
				}

				_currSpeed = _newSpeed;
				lastBrakeOn = true;
			} else {
				// adjust speed if previously we were braking
				if (lastBrakeOn) {
					adjustSpeed(topGearActivated);
				} else {
					if(!topGearActivated){
						if(_currSpeed > 120){
							// deceleretion	
							// speed is greather than 120 km/h		
							_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;

							while(_newSpeed > _currSpeed){
								time += ts;
								_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;
							}

							if((_newSpeed - 1) == 120){
								_a = 120;
								_newSpeed = 120;

								_sinus = false;
							}

							_currSpeed = _newSpeed;
						 } else {
							// speed between 0 - 120 km/h
							if(_sinus){
								_currSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));
							} else {
								_currSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.cos(_w*time/1000));
								if(_currSpeed == 0) {
									time = 0;
									_sinus = true;
								}
							}
						 }
					} else {
						// top gear activated
						 _newSpeed = (int) java.lang.Math.abs(_a*java.lang.Math.sin(_w*time/1000)) + 1;

						if(_a == 80){
							_newSpeed += 120;
						} else if((_newSpeed + 1) == 120){
							_a = 80;
							time = 0;
						} else if(_newSpeed < _currSpeed){
							// sinus downgrade
							// accelerate
							while(_newSpeed < _currSpeed){
								time += ts;
								_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));
							}
						}

						_currSpeed = _newSpeed;
					}
				}
			}

			time += ts;
		} else {
			// if command lever is activated 
			// check for specific command 
			// that are "working" with speed
			if(brakeOn){
				commandLeverActivated = false;

				// if we are braking
				// deceleration with higher w
				_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));

				while(_newSpeed > _currSpeed){
					time += ts;
					_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000));
				}

				_currSpeed = _newSpeed;
				lastBrakeOn = true;
			} else if (startAcc){
				// aceleretion	
				_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;

				while(_newSpeed < _currSpeed){
					time += ts;
					_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;
				}

				_currSpeed = _newSpeed;
				time += ts;	
			} else if (resume){
				// deceleretion	
				// speed is greather than saved speed
				_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;

				while(_lastSpeed < _newSpeed){
					time += ts;
					_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;
				}

				if(_savedSpeed < _newSpeed){
					_newSpeed = (int) java.lang.Math.abs( _a*java.lang.Math.sin(_w*time/1000)) + 120;
				}

				_currSpeed = _newSpeed;
				time += ts;	
			}
		}

		System.out.println(checkForError());

		Curr_Speed.SendCurrSpeed(_currSpeed).send();
		if(_currSpeed == _savedSpeed) ReachedSavedSpeed.Reached().send();
		timer.informAt(ts + java.lang.System.currentTimeMillis() ); 
	}
	// }}}RME
	// {{{RME transition ':TOP:Deactivated:J4FCB479A033E:parameterInitialization'
	protected void rtTransition4_parameterInitialization()
	{
		_a =((FunctionParameters)rtGetMsgData())._a;
		_w =((FunctionParameters)rtGetMsgData())._w;

	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCB4CD00040:manualSpeedInitialization'
	protected void rtTransition5_manualSpeedInitialization()
	{
		_currSpeed = ((ManualParameters)rtGetMsgData())._manualSpeed;
		Curr_Speed.SendCurrSpeed(_currSpeed).send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCCCB2E03B2:commandLeverActivated'
	protected void rtTransition6_commandLeverActivated()
	{
		ThrottleActuator.setSavedSpeed(_currSpeed);
		_savedSpeed = _currSpeed;

		commandLeverActivated = true;
		resume = startAcc = false;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCCC8D701B1:parameterInitialization'
	protected void rtTransition7_parameterInitialization()
	{
		_w =((FunctionParameters)rtGetMsgData())._w;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCCD5920366:resumeActivated'
	protected void rtTransition8_resumeActivated()
	{
		resume = true;
		startAcc = false;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCCD5D70357:startAccActivated'
	protected void rtTransition9_startAccActivated()
	{
		resume = false;
		startAcc = true;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FCCDA07024B:commandLeverDeactivated'
	protected void rtTransition10_commandLeverDeactivated()
	{
		commandLeverActivated = false;
		resume = startAcc = false;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FD1EF7102F0:brakeApplied'
	protected void rtTransition11_brakeApplied()
	{
		brakeOn = true;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activated:J4FD1EFB0032E:brakeReleased'
	protected void rtTransition12_brakeReleased()
	{
		brakeOn = false;
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
	protected void chain4_parameterInitialization()
	{
		rtChainBegin( 2, "parameterInitialization" );
		rtExitState();
		rtTransitionBegin();
		rtTransition4_parameterInitialization();
		rtTransitionEnd();
		rtEnterState( 2 );

	}
	protected void chain5_manualSpeedInitialization()
	{
		rtChainBegin( 3, "manualSpeedInitialization" );
		rtExitState();
		rtTransitionBegin();
		rtTransition5_manualSpeedInitialization();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain6_commandLeverActivated()
	{
		rtChainBegin( 3, "commandLeverActivated" );
		rtExitState();
		rtTransitionBegin();
		rtTransition6_commandLeverActivated();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain7_parameterInitialization()
	{
		rtChainBegin( 3, "parameterInitialization" );
		rtExitState();
		rtTransitionBegin();
		rtTransition7_parameterInitialization();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain8_resumeActivated()
	{
		rtChainBegin( 3, "resumeActivated" );
		rtExitState();
		rtTransitionBegin();
		rtTransition8_resumeActivated();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain9_startAccActivated()
	{
		rtChainBegin( 3, "startAccActivated" );
		rtExitState();
		rtTransitionBegin();
		rtTransition9_startAccActivated();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain10_commandLeverDeactivated()
	{
		rtChainBegin( 3, "commandLeverDeactivated" );
		rtExitState();
		rtTransitionBegin();
		rtTransition10_commandLeverDeactivated();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain11_brakeApplied()
	{
		rtChainBegin( 3, "brakeApplied" );
		rtExitState();
		rtTransitionBegin();
		rtTransition11_brakeApplied();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain12_brakeReleased()
	{
		rtChainBegin( 3, "brakeReleased" );
		rtExitState();
		rtTransitionBegin();
		rtTransition12_brakeReleased();
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
				case 1: // EngineEnabled
					switch( signal )
					{
					case ACCSSystem.EnableEngine.Conjugate.rti_Engine_on:
						chain1_activate();
						return;
					default:
						break;
					}
					break;
				case 3: // Function_Parameters
					switch( signal )
					{
					case ACCSSystem.Parameters.Base.rti_FunctionParams:
						chain4_parameterInitialization();
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
				case 1: // EngineEnabled
					switch( signal )
					{
					case ACCSSystem.EnableEngine.Conjugate.rti_Engine_off:
						chain2_deactivate();
						return;
					default:
						break;
					}
					break;
				case 2: // timer
					switch( signal )
					{
					case com.rational.rosert.Timing.Base.rti_timeout:
						chain3_readSensor();
						return;
					default:
						break;
					}
					break;
				case 3: // Function_Parameters
					switch( signal )
					{
					case ACCSSystem.Parameters.Base.rti_FunctionParams:
						chain7_parameterInitialization();
						return;
					default:
						break;
					}
					break;
				case 4: // Manual_Parameters
					switch( signal )
					{
					case ACCSSystem.Parameters.Base.rti_ManualParamrs:
						chain5_manualSpeedInitialization();
						return;
					default:
						break;
					}
					break;
				case 5: // RecieveCommand
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Conjugate.rti_Activate:
						chain6_commandLeverActivated();
						return;
					case ACCSSystem.LeverCommand.Conjugate.rti_StartAcc:
						chain9_startAccActivated();
						return;
					case ACCSSystem.LeverCommand.Conjugate.rti_Resume:
						chain8_resumeActivated();
						return;
					case ACCSSystem.LeverCommand.Conjugate.rti_Deactivate:
						chain10_commandLeverDeactivated();
						return;
					default:
						break;
					}
					break;
				case 8: // Brake_Applied
					switch( signal )
					{
					case ACCSSystem.BrakeInterrupt.Conjugate.rti_BrakeApplied:
						chain11_brakeApplied();
						return;
					case ACCSSystem.BrakeInterrupt.Conjugate.rti_BrakeReleased:
						chain12_brakeReleased();
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
		case 0: // EngineEnabled
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.EngineEnabled, index );
			break;
		case 1: // Function_Parameters
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Function_Parameters, index );
			break;
		case 2: // Manual_Parameters
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Manual_Parameters, index );
			break;
		case 3: // RecieveCommand
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.RecieveCommand, index );
			break;
		case 4: // Curr_Speed
			if( index < 2 )
				return new com.rational.rosert.BindingEnd( this.Curr_Speed, index );
			break;
		case 5: // ReachedSavedSpeed
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.ReachedSavedSpeed, index );
			break;
		case 6: // Brake_Applied
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Brake_Applied, index );
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
			return ACCSSystem.EnableEngine.Conjugate.rtDescriptor;
		case 1:
			return ACCSSystem.Parameters.Base.rtDescriptor;
		case 2:
			return ACCSSystem.Parameters.Base.rtDescriptor;
		case 3:
			return ACCSSystem.LeverCommand.Conjugate.rtDescriptor;
		case 4:
			return ACCSSystem.CurrentSpeed.Base.rtDescriptor;
		case 5:
			return ACCSSystem.LeverCommand.Base.rtDescriptor;
		case 6:
			return ACCSSystem.BrakeInterrupt.Conjugate.rtDescriptor;
		default:
			return super.rtGetRelayProtocol( relay );
		}

	}
	protected int rtGetRelayCount()
	{
		return 7;
	}
	protected int rtGetRelayCardinality( int relay )
	{
		switch( relay )
		{
		case 0: // EngineEnabled
			return 1;
		case 1: // Function_Parameters
			return 1;
		case 2: // Manual_Parameters
			return 1;
		case 3: // RecieveCommand
			return 1;
		case 4: // Curr_Speed
			return 2;
		case 5: // ReachedSavedSpeed
			return 1;
		case 6: // Brake_Applied
			return 1;
		default:
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		EngineEnabled = new ACCSSystem.EnableEngine.Conjugate
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		timer = new com.rational.rosert.Timing.Base
		(
			this,
			1, // cardinality
			( 2 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterAutoUnlockedUnpublished
				+ com.rational.rosert.Capsule.PortDescriptor.Unwired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		Function_Parameters = new ACCSSystem.Parameters.Base
		(
			this,
			1, // cardinality
			( 3 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Manual_Parameters = new ACCSSystem.Parameters.Base
		(
			this,
			1, // cardinality
			( 4 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		RecieveCommand = new ACCSSystem.LeverCommand.Conjugate
		(
			this,
			1, // cardinality
			( 5 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Curr_Speed = new ACCSSystem.CurrentSpeed.Base
		(
			this,
			2, // cardinality
			( 6 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		ReachedSavedSpeed = new ACCSSystem.LeverCommand.Base
		(
			this,
			1, // cardinality
			( 7 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Brake_Applied = new ACCSSystem.BrakeInterrupt.Conjugate
		(
			this,
			1, // cardinality
			( 8 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);

	}
	protected void rtEnumeratePorts( com.rational.rosert.Capsule.PortList list )
	{
		super.rtEnumeratePorts( list );
		list.add( this.EngineEnabled );
		list.add( this.timer );
		list.add( this.Function_Parameters );
		list.add( this.Manual_Parameters );
		list.add( this.RecieveCommand );
		list.add( this.Curr_Speed );
		list.add( this.ReachedSavedSpeed );
		list.add( this.Brake_Applied );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "EngineEnabled";
		case 2:
			return "timer";
		case 3:
			return "Function_Parameters";
		case 4:
			return "Manual_Parameters";
		case 5:
			return "RecieveCommand";
		case 6:
			return "Curr_Speed";
		case 7:
			return "ReachedSavedSpeed";
		case 8:
			return "Brake_Applied";
		default:
			return super.rtGetPortName( port );
		}
	}
	protected void rtEnumerateAttributes( com.rational.rosert.AttributeList list, com.rational.rosert.ExtendedAttributeList extended )
	{
		super.rtEnumerateAttributes( list, extended );
		this.engineOn = (boolean)list.add( "engineOn", this.engineOn );
		this.ts = (int)list.add( "ts", this.ts );
		if( extended != null )
			this._w = (double)extended.add( "_w", this._w );
		this._a = (int)list.add( "_a", this._a );
		this._currSpeed = (int)list.add( "_currSpeed", this._currSpeed );
		this.commandLeverActivated = (boolean)list.add( "commandLeverActivated", this.commandLeverActivated );
		this.time = (long)list.add( "time", this.time );
		this.topGearActivated = (boolean)list.add( "topGearActivated", this.topGearActivated );
		this._sinus = (boolean)list.add( "_sinus", this._sinus );
		this._lastSpeed = (int)list.add( "_lastSpeed", this._lastSpeed );
		this.resume = (boolean)list.add( "resume", this.resume );
		this.startAcc = (boolean)list.add( "startAcc", this.startAcc );
		this._savedSpeed = (int)list.add( "_savedSpeed", this._savedSpeed );
		this.brakeOn = (boolean)list.add( "brakeOn", this.brakeOn );
		this.lastBrakeOn = (boolean)list.add( "lastBrakeOn", this.lastBrakeOn );

	}
}
// }}}RME
