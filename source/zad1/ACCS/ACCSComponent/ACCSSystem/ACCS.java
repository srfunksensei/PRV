package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::ACCS'
public class ACCS extends com.rational.rosert.Capsule
{
	protected static final com.rational.rosert.CapsuleRole brakeSensor;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		brakeSensor = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.BrakeSensor",
			1,
			( 0 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindFixed
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole commandLeverSensor;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		commandLeverSensor = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.CommandLeverSensor",
			1,
			( 1 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindFixed
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole engineSensor;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		engineSensor = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.EngineSensor",
			1,
			( 2 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindFixed
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
	protected static final com.rational.rosert.CapsuleRole gearSensor;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		gearSensor = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.TopGearSensor",
			1,
			( 3 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindFixed
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
			( 4 << com.rational.rosert.CapsuleRole.IdShift )
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
			( 5 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindFixed
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
			( 6 << com.rational.rosert.CapsuleRole.IdShift )
				+ com.rational.rosert.CapsuleRole.KindFixed
				+ com.rational.rosert.CapsuleRole.Substitutable
		);
	}
	// }}}RME
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
		case 0: // brakeSensor
			switch( relay )
			{
			case 0: // Brake_Interrupt
				if( index < 1 ) // commandLeverSensor/BrakeApplied
					return rtFollowIn( this.commandLeverSensor, 0, index );
				else if( index < 2 ) // wheelShaftSensor/Brake_Applied
					return rtFollowIn( this.wheelShaftSensor, 6, index - 1 );
				break;
			default:
				break;
			}
			break;
		case 1: // commandLeverSensor
			switch( relay )
			{
			case 0: // BrakeApplied
				if( index < 1 ) // brakeSensor/Brake_Interrupt
					return rtFollowIn( this.brakeSensor, 0, index );
				break;
			case 1: // TopGearEngaged
				if( index < 1 ) // gearSensor/ToggleTopGear
					return rtFollowIn( this.gearSensor, 1, index );
				break;
			case 2: // EngineEnabled
				if( index < 1 ) // engineSensor/ToggleEngine
					return rtFollowIn( this.engineSensor, 0, index );
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
		case 2: // engineSensor
			switch( relay )
			{
			case 0: // ToggleEngine
				if( index < 1 ) // commandLeverSensor/EngineEnabled
					return rtFollowIn( this.commandLeverSensor, 2, index );
				else if( index < 2 ) // wheelShaftSensor/EngineEnabled
					return rtFollowIn( this.wheelShaftSensor, 0, index - 1 );
				else if( index < 3 ) // throttleSensor/Enable_Engine
					return rtFollowIn( this.throttleSensor, 1, index - 2 );
				break;
			default:
				break;
			}
			break;
		case 3: // gearSensor
			switch( relay )
			{
			case 1: // ToggleTopGear
				if( index < 1 ) // commandLeverSensor/TopGearEngaged
					return rtFollowIn( this.commandLeverSensor, 1, index );
				break;
			default:
				break;
			}
			break;
		case 4: // throttleActuator
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
		case 5: // throttleSensor
			switch( relay )
			{
			case 1: // Enable_Engine
				if( index < 1 ) // engineSensor/ToggleEngine
					return rtFollowIn( this.engineSensor, 0, index + 2 );
				break;
			case 4: // RecieveCommand
				if( index < 1 ) // commandLeverSensor/SendCommand
					return rtFollowIn( this.commandLeverSensor, 4, index + 2 );
				break;
			default:
				break;
			}
			break;
		case 6: // wheelShaftSensor
			switch( relay )
			{
			case 0: // EngineEnabled
				if( index < 1 ) // engineSensor/ToggleEngine
					return rtFollowIn( this.engineSensor, 0, index + 1 );
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
				if( index < 1 ) // brakeSensor/Brake_Interrupt
					return rtFollowIn( this.brakeSensor, 0, index + 1 );
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
			return this.brakeSensor;
		case 1:
			return this.commandLeverSensor;
		case 2:
			return this.engineSensor;
		case 3:
			return this.gearSensor;
		case 4:
			return this.throttleActuator;
		case 5:
			return this.throttleSensor;
		case 6:
			return this.wheelShaftSensor;
		default:
			return super.rtGetCapsuleRole( role );
		}

	}
	protected java.lang.String rtGetCapsuleRoleName( int role )
	{
		switch( role )
		{
		case 0:
			return "brakeSensor";
		case 1:
			return "commandLeverSensor";
		case 2:
			return "engineSensor";
		case 3:
			return "gearSensor";
		case 4:
			return "throttleActuator";
		case 5:
			return "throttleSensor";
		case 6:
			return "wheelShaftSensor";
		default:
			return super.rtGetCapsuleRoleName( role );
		}

	}
	protected int rtGetConnectorCount( int role )
	{
		switch( role )
		{
		case 0: // brakeSensor
			return 2;
		case 1: // commandLeverSensor
			return 6;
		case 2: // engineSensor
			return 2;
		case 3: // gearSensor
			return 2;
		case 4: // throttleActuator
			return 4;
		case 5: // throttleSensor
			return 5;
		case 6: // wheelShaftSensor
			return 7;
		default:
			return super.rtGetConnectorCount( role );
		}

	}
	protected int rtGetConnectorCardinality( int role, int relay )
	{
		switch( role )
		{
		case 0: // brakeSensor
			switch( relay )
			{
			case 0: // Brake_Interrupt
				return 2;
			case 1: // Apply_Brake
				return 0;
			default:
				break;
			}
			break;
		case 1: // commandLeverSensor
			switch( relay )
			{
			case 0: // BrakeApplied
				return 1;
			case 1: // TopGearEngaged
				return 1;
			case 2: // EngineEnabled
				return 1;
			case 3: // Command
				return 0;
			case 4: // SendCommand
				return 3;
			case 5: // ReachedSavedSpeed
				return 1;
			default:
				break;
			}
			break;
		case 2: // engineSensor
			switch( relay )
			{
			case 0: // ToggleEngine
				return 3;
			case 1: // Enable_Engine
				return 0;
			default:
				break;
			}
			break;
		case 3: // gearSensor
			switch( relay )
			{
			case 0: // TopGearEngage
				return 0;
			case 1: // ToggleTopGear
				return 1;
			default:
				break;
			}
			break;
		case 4: // throttleActuator
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
		case 5: // throttleSensor
			switch( relay )
			{
			case 0: // Manual_Parameters
				return 0;
			case 1: // Enable_Engine
				return 1;
			case 2: // Actual_Voltage
				return 0;
			case 3: // Function_Parameters
				return 0;
			case 4: // RecieveCommand
				return 1;
			default:
				break;
			}
			break;
		case 6: // wheelShaftSensor
			switch( relay )
			{
			case 0: // EngineEnabled
				return 1;
			case 1: // Function_Parameters
				return 0;
			case 2: // Manual_Parameters
				return 0;
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
		default:
			break;
		}
		return super.rtGetConnectorCardinality( role, relay );
	}
	protected int rtGetCapsuleRoleCount()
	{
		return 7;
	}
}
// }}}RME
