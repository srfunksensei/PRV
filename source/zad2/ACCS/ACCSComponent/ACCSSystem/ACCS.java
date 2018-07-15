package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::ACCS'
public class ACCS extends com.rational.rosert.Capsule
{
	protected com.rational.rosert.Frame.Base frame;
	protected ACCSSystem.EnableEngine.Conjugate Enable_Engine;
	protected ACCSSystem.EnableTopGear.Conjugate TopGearEngaged;
	protected ACCSSystem.LeverCommand.Conjugate Command;
	protected ACCSSystem.BrakeInterrupt.Conjugate BrakeApplied;
	protected ACCSSystem.Parameters.Conjugate Manual_Parameters;
	protected ACCSSystem.Parameters.Conjugate Function_Parameters;
	protected static final com.rational.rosert.CapsuleRole commandLeverSensor;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		commandLeverSensor = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.CommandLeverSensor",
			1,
			( 0 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindOptional
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole throttleActuator;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		throttleActuator = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.ThrottleActuator",
			1,
			( 1 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindFixed
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole throttleSensor;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		throttleSensor = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.ThrottleSensor",
			1,
			( 2 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindOptional
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole wheelShaftSensor;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		wheelShaftSensor = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.WheelShaftSensor",
			1,
			( 3 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindOptional
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole tmpBrake;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		tmpBrake = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.TmpBrake",
			1,
			( 4 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindOptional
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole tmpTopGear;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		tmpTopGear = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.TmpTopGear",
			1,
			( 5 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindOptional
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole tmpCommand;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		tmpCommand = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.TmpCommand",
			1,
			( 6 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindOptional
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole tmpManualParams;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		tmpManualParams = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.TmpManualParams",
			1,
			( 7 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindOptional
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole tmpFunctionParams;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		tmpFunctionParams = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.TmpFunctionParams",
			1,
			( 8 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindOptional
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	// {{{RME transition ':TOP:Initial:Initial'
	protected void rtTransition0_Initial()
	{
		com.rational.rosert.Controller newController = new com.rational.rosert.Controller( rtGetController().getApplication(), "NewThread" );

		java.lang.Thread thread1 = new java.lang.Thread( newController );

		thread1.start();

		try{
			// engine
			frame.incarnate( commandLeverSensor, Enable_Engine, newController);
			frame.incarnate( throttleSensor, Enable_Engine, newController);
			frame.incarnate( wheelShaftSensor, Enable_Engine, newController);

			// brake
			frame.incarnate( tmpBrake, BrakeApplied, newController);	

			// top gear
			frame.incarnate( tmpTopGear, TopGearEngaged, newController);

			// command
			frame.incarnate( tmpCommand, Command, newController);

			// manual params
			frame.incarnate( tmpManualParams, Manual_Parameters, newController);

			// function params
			frame.incarnate( tmpFunctionParams, Function_Parameters, newController);

		} 
		catch( com.rational.rosert.FullException ex ){
			System.out.println("g1" + ex);
		}
		catch( com.rational.rosert.IncompatibleClassException ex ){
			System.out.println("g2" + ex);
		}
		catch( java.lang.IllegalAccessException ex ){
			System.out.println("g3" + ex);
		}
		catch( java.lang.InstantiationException ex ){
			System.out.println("g4" + ex);
		}

		/* should create a method rtPredestroy to shutdown the thread body is newController.kill(); thread1.join(); */
	}
	// }}}RME
	protected void chain0_Initial()
	{
		rtChainBegin( 1, "Initial" );
		rtTransitionBegin();
		rtTransition0_Initial();
		rtTransitionEnd();
		rtProcessHistory();

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
			default:
				rtUnexpectedState();
				return;
			}
		}

	}
	protected com.rational.rosert.BindingEnd rtFollowOutV( int role, int relay, int index )
	{
		switch( role )
		{
		case 0: // commandLeverSensor
			switch( relay )
			{
			case 0: // BrakeApplied
				if( index < 1 ) // tmpBrake/Out
					return rtFollowIn( this.tmpBrake, 1, index );
				break;
			case 1: // TopGearEngaged
				if( index < 1 ) // tmpTopGear/Out
					return rtFollowIn( this.tmpTopGear, 1, index );
				break;
			case 2: // EngineEnabled
				if( index < 1 ) // Enable_Engine
					return new com.rational.rosert.BindingEnd( this.Enable_Engine, index );
				break;
			case 3: // Command
				if( index < 1 ) // tmpCommand/Out
					return rtFollowIn( this.tmpCommand, 1, index );
				break;
			case 4: // SendCommand
				if( index < 1 ) // wheelShaftSensor/RecieveCommand
					return rtFollowIn( this.wheelShaftSensor, 3, index );
				else if( index < 2 ) // throttleActuator/Command
					return rtFollowIn( this.throttleActuator, 1, index - 1 );
				else if( index < 3 ) // throttleSensor/RecieveCommand
					return rtFollowIn( this.throttleSensor, 4, index - 2 );
				break;
			case 5: // ReachedSavedSpeed
				if( index < 1 ) // wheelShaftSensor/ReachedSavedSpeed
					return rtFollowIn( this.wheelShaftSensor, 5, index );
				break;
			default:
				break;
			}
			break;
		case 1: // throttleActuator
			switch( relay )
			{
			case 0: // Curr_Speed
				if( index < 1 ) // wheelShaftSensor/Curr_Speed
					return rtFollowIn( this.wheelShaftSensor, 4, index );
				break;
			case 1: // Command
				if( index < 1 ) // commandLeverSensor/SendCommand
					return rtFollowIn( this.commandLeverSensor, 4, index + 1 );
				break;
			default:
				break;
			}
			break;
		case 2: // throttleSensor
			switch( relay )
			{
			case 0: // Manual_Parameters
				if( index < 1 ) // tmpManualParams/OutThrottle
					return rtFollowIn( this.tmpManualParams, 2, index );
				break;
			case 1: // Enable_Engine
				if( index < 1 ) // Enable_Engine
					return new com.rational.rosert.BindingEnd( this.Enable_Engine, index + 2 );
				break;
			case 3: // Function_Parameters
				if( index < 1 ) // tmpFunctionParams/OutThrottle
					return rtFollowIn( this.tmpFunctionParams, 2, index );
				break;
			case 4: // RecieveCommand
				if( index < 1 ) // commandLeverSensor/SendCommand
					return rtFollowIn( this.commandLeverSensor, 4, index + 2 );
				break;
			default:
				break;
			}
			break;
		case 3: // wheelShaftSensor
			switch( relay )
			{
			case 0: // EngineEnabled
				if( index < 1 ) // Enable_Engine
					return new com.rational.rosert.BindingEnd( this.Enable_Engine, index + 1 );
				break;
			case 1: // Function_Parameters
				if( index < 1 ) // tmpFunctionParams/OutSpeed
					return rtFollowIn( this.tmpFunctionParams, 1, index );
				break;
			case 2: // Manual_Parameters
				if( index < 1 ) // tmpManualParams/OutSpeed
					return rtFollowIn( this.tmpManualParams, 1, index );
				break;
			case 3: // RecieveCommand
				if( index < 1 ) // commandLeverSensor/SendCommand
					return rtFollowIn( this.commandLeverSensor, 4, index );
				break;
			case 4: // Curr_Speed
				if( index < 1 ) // throttleActuator/Curr_Speed
					return rtFollowIn( this.throttleActuator, 0, index );
				break;
			case 5: // ReachedSavedSpeed
				if( index < 1 ) // commandLeverSensor/ReachedSavedSpeed
					return rtFollowIn( this.commandLeverSensor, 5, index );
				break;
			case 6: // Brake_Applied
				if( index < 1 ) // tmpBrake/Out
					return rtFollowIn( this.tmpBrake, 1, index + 1 );
				break;
			default:
				break;
			}
			break;
		case 4: // tmpBrake
			switch( relay )
			{
			case 0: // In
				if( index < 1 ) // BrakeApplied
					return new com.rational.rosert.BindingEnd( this.BrakeApplied, index );
				break;
			case 1: // Out
				if( index < 1 ) // commandLeverSensor/BrakeApplied
					return rtFollowIn( this.commandLeverSensor, 0, index );
				else if( index < 2 ) // wheelShaftSensor/Brake_Applied
					return rtFollowIn( this.wheelShaftSensor, 6, index - 1 );
				break;
			default:
				break;
			}
			break;
		case 5: // tmpTopGear
			switch( relay )
			{
			case 0: // In
				if( index < 1 ) // TopGearEngaged
					return new com.rational.rosert.BindingEnd( this.TopGearEngaged, index );
				break;
			case 1: // Out
				if( index < 1 ) // commandLeverSensor/TopGearEngaged
					return rtFollowIn( this.commandLeverSensor, 1, index );
				break;
			default:
				break;
			}
			break;
		case 6: // tmpCommand
			switch( relay )
			{
			case 0: // In
				if( index < 1 ) // Command
					return new com.rational.rosert.BindingEnd( this.Command, index );
				break;
			case 1: // Out
				if( index < 1 ) // commandLeverSensor/Command
					return rtFollowIn( this.commandLeverSensor, 3, index );
				break;
			default:
				break;
			}
			break;
		case 7: // tmpManualParams
			switch( relay )
			{
			case 0: // In
				if( index < 1 ) // Manual_Parameters
					return new com.rational.rosert.BindingEnd( this.Manual_Parameters, index );
				break;
			case 1: // OutSpeed
				if( index < 1 ) // wheelShaftSensor/Manual_Parameters
					return rtFollowIn( this.wheelShaftSensor, 2, index );
				break;
			case 2: // OutThrottle
				if( index < 1 ) // throttleSensor/Manual_Parameters
					return rtFollowIn( this.throttleSensor, 0, index );
				break;
			default:
				break;
			}
			break;
		case 8: // tmpFunctionParams
			switch( relay )
			{
			case 0: // In
				if( index < 1 ) // Function_Parameters
					return new com.rational.rosert.BindingEnd( this.Function_Parameters, index );
				break;
			case 1: // OutSpeed
				if( index < 1 ) // wheelShaftSensor/Function_Parameters
					return rtFollowIn( this.wheelShaftSensor, 1, index );
				break;
			case 2: // OutThrottle
				if( index < 1 ) // throttleSensor/Function_Parameters
					return rtFollowIn( this.throttleSensor, 3, index );
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return super.rtFollowOutV( role, relay, index );
	}
	protected com.rational.rosert.CapsuleRole rtGetCapsuleRole( int role )
	{
		switch( role )
		{
		case 0:
			return this.commandLeverSensor;
		case 1:
			return this.throttleActuator;
		case 2:
			return this.throttleSensor;
		case 3:
			return this.wheelShaftSensor;
		case 4:
			return this.tmpBrake;
		case 5:
			return this.tmpTopGear;
		case 6:
			return this.tmpCommand;
		case 7:
			return this.tmpManualParams;
		case 8:
			return this.tmpFunctionParams;
		default:
			return super.rtGetCapsuleRole( role );
		}

	}
	protected java.lang.String rtGetCapsuleRoleName( int role )
	{
		switch( role )
		{
		case 0:
			return "commandLeverSensor";
		case 1:
			return "throttleActuator";
		case 2:
			return "throttleSensor";
		case 3:
			return "wheelShaftSensor";
		case 4:
			return "tmpBrake";
		case 5:
			return "tmpTopGear";
		case 6:
			return "tmpCommand";
		case 7:
			return "tmpManualParams";
		case 8:
			return "tmpFunctionParams";
		default:
			return super.rtGetCapsuleRoleName( role );
		}

	}
	protected int rtGetConnectorCount( int role )
	{
		switch( role )
		{
		case 0: // commandLeverSensor
			return 6;
		case 1: // throttleActuator
			return 4;
		case 2: // throttleSensor
			return 5;
		case 3: // wheelShaftSensor
			return 7;
		case 4: // tmpBrake
			return 2;
		case 5: // tmpTopGear
			return 2;
		case 6: // tmpCommand
			return 2;
		case 7: // tmpManualParams
			return 3;
		case 8: // tmpFunctionParams
			return 3;
		default:
			return super.rtGetConnectorCount( role );
		}

	}
	protected int rtGetConnectorCardinality( int role, int relay )
	{
		switch( role )
		{
		case 0: // commandLeverSensor
			switch( relay )
			{
			case 0: // BrakeApplied
				return 1;
			case 1: // TopGearEngaged
				return 1;
			case 2: // EngineEnabled
				return 1;
			case 3: // Command
				return 1;
			case 4: // SendCommand
				return 3;
			case 5: // ReachedSavedSpeed
				return 1;
			default:
				break;
			}
			break;
		case 1: // throttleActuator
			switch( relay )
			{
			case 0: // Curr_Speed
				return 1;
			case 1: // Command
				return 1;
			case 2: // ACCS_Voltage
				return 0;
			case 3: // Actual_Voltage
				return 0;
			default:
				break;
			}
			break;
		case 2: // throttleSensor
			switch( relay )
			{
			case 0: // Manual_Parameters
				return 1;
			case 1: // Enable_Engine
				return 1;
			case 2: // Actual_Voltage
				return 0;
			case 3: // Function_Parameters
				return 1;
			case 4: // RecieveCommand
				return 1;
			default:
				break;
			}
			break;
		case 3: // wheelShaftSensor
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
				return 1;
			case 5: // ReachedSavedSpeed
				return 1;
			case 6: // Brake_Applied
				return 1;
			default:
				break;
			}
			break;
		case 4: // tmpBrake
			switch( relay )
			{
			case 0: // In
				return 1;
			case 1: // Out
				return 2;
			default:
				break;
			}
			break;
		case 5: // tmpTopGear
			switch( relay )
			{
			case 0: // In
				return 1;
			case 1: // Out
				return 1;
			default:
				break;
			}
			break;
		case 6: // tmpCommand
			switch( relay )
			{
			case 0: // In
				return 1;
			case 1: // Out
				return 1;
			default:
				break;
			}
			break;
		case 7: // tmpManualParams
			switch( relay )
			{
			case 0: // In
				return 1;
			case 1: // OutSpeed
				return 1;
			case 2: // OutThrottle
				return 1;
			default:
				break;
			}
			break;
		case 8: // tmpFunctionParams
			switch( relay )
			{
			case 0: // In
				return 1;
			case 1: // OutSpeed
				return 1;
			case 2: // OutThrottle
				return 1;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return super.rtGetConnectorCardinality( role, relay );
	}
	protected int rtGetCapsuleRoleCount()
	{
		return 9;
	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		frame = new com.rational.rosert.Frame.Base
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterAutoUnlockedUnpublished
				+ com.rational.rosert.Capsule.PortDescriptor.Unwired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		Enable_Engine = new ACCSSystem.EnableEngine.Conjugate
		(
			this,
			3, // cardinality
			( 2 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		TopGearEngaged = new ACCSSystem.EnableTopGear.Conjugate
		(
			this,
			1, // cardinality
			( 3 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		Command = new ACCSSystem.LeverCommand.Conjugate
		(
			this,
			1, // cardinality
			( 4 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		BrakeApplied = new ACCSSystem.BrakeInterrupt.Conjugate
		(
			this,
			1, // cardinality
			( 5 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		Manual_Parameters = new ACCSSystem.Parameters.Conjugate
		(
			this,
			1, // cardinality
			( 6 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);
		Function_Parameters = new ACCSSystem.Parameters.Conjugate
		(
			this,
			1, // cardinality
			( 7 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityProtected
		);

	}
	protected void rtEnumeratePorts( com.rational.rosert.Capsule.PortList list )
	{
		super.rtEnumeratePorts( list );
		list.add( this.frame );
		list.add( this.Enable_Engine );
		list.add( this.TopGearEngaged );
		list.add( this.Command );
		list.add( this.BrakeApplied );
		list.add( this.Manual_Parameters );
		list.add( this.Function_Parameters );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "frame";
		case 2:
			return "Enable_Engine";
		case 3:
			return "TopGearEngaged";
		case 4:
			return "Command";
		case 5:
			return "BrakeApplied";
		case 6:
			return "Manual_Parameters";
		case 7:
			return "Function_Parameters";
		default:
			return super.rtGetPortName( port );
		}
	}
}
// }}}RME
