package ACCSSystem;
import ACCSSystem.WheelShaftSensor;
import ACCSGUI.ACCSGUIPanel;
import ACCSSystem.InjectEventEngine;
import ACCSSystem.InjectEventTopGear;
import ACCSSystem.InjectEventBrake;
import ACCSSystem.InjectEventCommand;
import ACCSSystem.InjectEventFunctionParams;
// {{{RME classifier 'Logical View::ACCSSystem::CommandLeverSensor'
public class CommandLeverSensor extends com.rational.rosert.Capsule
{
	// {{{RME classAttribute '_topGearEngaged'
	private static boolean _topGearEngaged = false;
	// }}}RME
	// {{{RME classAttribute 'gui'
	public static ACCSGUIPanel gui;
	// }}}RME
	protected ACCSSystem.BrakeInterrupt.Base BrakeApplied;
	protected ACCSSystem.EnableTopGear.Base TopGearEngaged;
	protected ACCSSystem.EnableEngine.Base EngineEnabled;
	protected ACCSSystem.LeverCommand.Base Command;
	protected ACCSSystem.LeverCommand.Base SendCommand;
	protected ACCSSystem.LeverCommand.Conjugate ReachedSavedSpeed;
	// {{{RME operation 'setTopGearEngaged(boolean)'
	public static void setTopGearEngaged( boolean topGearEngaged )
	{
		_topGearEngaged = topGearEngaged;
	}
	// }}}RME
	// {{{RME transition ':TOP:Initial:initial'
	protected void rtTransition0_initial()
	{
		gui = new ACCSGUIPanel();

		// engine
		gui.addButtonEventEngine(new InjectEventEngine( (EnableEngine.Conjugate) rtGetMsgData() ));

	}
	// }}}RME
	// {{{RME transition ':TOP:Deactivate:TopGearEngaged:J4FC8E8C301F5:activate'
	protected void rtTransition5_activate()
	{
		SendCommand.Activate().send();
	}
	// }}}RME
	// {{{RME choicePoint ':TOP:Deactivate:CP'
	protected boolean rtChoicePoint0_CP()
	{
		return _topGearEngaged == true;
	}
	// }}}RME
	// {{{RME transition ':TOP:Activate:ConstantSpeed:J4FC9F6E10243:startAcc'
	protected void rtTransition12_startAcc()
	{
		SendCommand.StartAcc().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Activate:Acceleration:J4FC9F6E40197:resume'
	protected void rtTransition13_resume()
	{
		SendCommand.Resume().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Activate:Deceleration:J4FC9F6E70010:activate_or_savedSpeed_engaged'
	protected void rtTransition14_activate_or_savedSpeed_engaged()
	{
		SendCommand.Activate().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Activate:Deceleration:J4FC9F6EA01B6:startAcc'
	protected void rtTransition15_startAcc()
	{
		SendCommand.StartAcc().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Activate:Acceleration:J4FC9F6EE002F:activate_or_stopAcc'
	protected void rtTransition16_activate_or_stopAcc()
	{
		SendCommand.Activate().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Activate:Acceleration:J4FC9F9260168:deactivate'
	protected void rtTransition17_deactivate()
	{
		SendCommand.Deactivate().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Activate:Deceleration:J4FC9F93901E5:deactivate'
	protected void rtTransition18_deactivate()
	{
		SendCommand.Deactivate().send();
	}
	// }}}RME
	// {{{RME transition ':TOP:Activate:ConstantSpeed:J4FC9F96F0399:deactivate'
	protected void rtTransition19_deactivate()
	{
		SendCommand.Deactivate().send();
	}
	// }}}RME
	protected void rtDescribeBehavior( com.rational.rosert.Capsule.BehaviorInfo info )
	{
		super.rtDescribeBehavior( info );

		info.includeState( 2, "Deactivate", 1 );
		info.includeState( 3, "EngineOn", 2 );
		info.includeState( 4, "TopGearEngaged", 2 );
		info.includeState( 5, "Disabled", 2 );
		info.includeChoicePoint( 1, "CP", 2 );
		info.includeState( 6, "Activate", 1 );
		info.includeState( 7, "ConstantSpeed", 6 );
		info.includeState( 8, "Acceleration", 6 );
		info.includeState( 9, "Deceleration", 6 );

	}
	protected int rtGetStateCount()
	{
		return 9;
	}
	protected int rtGetStateDepth()
	{
		return 2;
	}
	protected void chain0_initial()
	{
		rtChainBegin( 1, "initial" );
		rtTransitionBegin();
		rtTransition0_initial();
		rtTransitionEnd();
		rtEnterState( 2 );
		rtChainBegin( 2, "Initial" );
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 5 );

	}
	protected void chain3_topGearEngaged()
	{
		rtChainBegin( 3, "topGearEngaged" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 4 );

	}
	protected void chain4_topGearDisengaged()
	{
		rtChainBegin( 4, "topGearDisengaged" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain5_activate()
	{
		rtChainBegin( 4, "activate" );
		rtExitState();
		rtTransitionBegin();
		rtTransition5_activate();
		rtTransitionEnd();
		rtChainBegin( 2, "activate" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 6 );
		rtChainBegin( 6, "activate" );
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 7 );

	}
	protected void chain6_engineOn()
	{
		rtChainBegin( 5, "engineOn" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain7_engineOff()
	{
		rtChainBegin( 3, "engineOff" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 5 );

	}
	protected void chain10_True()
	{
		rtLeaveChoicePoint( 1, "True" );
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 4 );

	}
	protected void chain11_False()
	{
		rtLeaveChoicePoint( 1, "False" );
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 3 );

	}
	protected void chain12_startAcc()
	{
		rtChainBegin( 7, "startAcc" );
		rtExitState();
		rtTransitionBegin();
		rtTransition12_startAcc();
		rtTransitionEnd();
		rtEnterState( 8 );

	}
	protected void chain13_resume()
	{
		rtChainBegin( 8, "resume" );
		rtExitState();
		rtTransitionBegin();
		rtTransition13_resume();
		rtTransitionEnd();
		rtEnterState( 9 );

	}
	protected void chain14_activate_or_savedSpeed_engaged()
	{
		rtChainBegin( 9, "activate_or_savedSpeed_engaged" );
		rtExitState();
		rtTransitionBegin();
		rtTransition14_activate_or_savedSpeed_engaged();
		rtTransitionEnd();
		rtEnterState( 7 );

	}
	protected void chain15_startAcc()
	{
		rtChainBegin( 9, "startAcc" );
		rtExitState();
		rtTransitionBegin();
		rtTransition15_startAcc();
		rtTransitionEnd();
		rtEnterState( 8 );

	}
	protected void chain16_activate_or_stopAcc()
	{
		rtChainBegin( 8, "activate_or_stopAcc" );
		rtExitState();
		rtTransitionBegin();
		rtTransition16_activate_or_stopAcc();
		rtTransitionEnd();
		rtEnterState( 7 );

	}
	protected void chain17_deactivate()
	{
		rtChainBegin( 8, "deactivate" );
		rtExitState();
		rtTransitionBegin();
		rtTransition17_deactivate();
		rtTransitionEnd();
		rtChainBegin( 6, "deactivate" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 2 );
		rtChainBegin( 2, "deactivate" );
		rtTransitionBegin();
		rtTransitionEnd();
		if( rtChoicePoint0_CP() )
			chain10_True();
		else
			chain11_False();

	}
	protected void chain18_deactivate()
	{
		rtChainBegin( 9, "deactivate" );
		rtExitState();
		rtTransitionBegin();
		rtTransition18_deactivate();
		rtTransitionEnd();
		rtChainBegin( 6, "deactivate" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 2 );
		rtChainBegin( 2, "deactivate" );
		rtTransitionBegin();
		rtTransitionEnd();
		if( rtChoicePoint0_CP() )
			chain10_True();
		else
			chain11_False();

	}
	protected void chain19_deactivate()
	{
		rtChainBegin( 7, "deactivate" );
		rtExitState();
		rtTransitionBegin();
		rtTransition19_deactivate();
		rtTransitionEnd();
		rtChainBegin( 6, "deactivate" );
		rtExitState();
		rtTransitionBegin();
		rtTransitionEnd();
		rtEnterState( 2 );
		rtChainBegin( 2, "deactivate" );
		rtTransitionBegin();
		rtTransitionEnd();
		if( rtChoicePoint0_CP() )
			chain10_True();
		else
			chain11_False();

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
						chain0_initial();
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
				// {{{RME state ':TOP:Deactivate'
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
				state = 1;
				break;
				// }}}RME
			case 3:
				// {{{RME state ':TOP:Deactivate:EngineOn'
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
				case 2: // TopGearEngaged
					switch( signal )
					{
					case ACCSSystem.EnableTopGear.Base.rti_EngageTopGear:
						chain3_topGearEngaged();
						return;
					default:
						break;
					}
					break;
				case 3: // EngineEnabled
					switch( signal )
					{
					case ACCSSystem.EnableEngine.Base.rti_Disable:
						chain7_engineOff();
						return;
					default:
						break;
					}
					break;
				default:
					break;
				}
				state = 2;
				break;
				// }}}RME
			case 4:
				// {{{RME state ':TOP:Deactivate:TopGearEngaged'
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
				case 2: // TopGearEngaged
					switch( signal )
					{
					case ACCSSystem.EnableTopGear.Base.rti_DisengageTopGear:
						chain4_topGearDisengaged();
						return;
					default:
						break;
					}
					break;
				case 4: // Command
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Base.rti_Enable:
						chain5_activate();
						return;
					default:
						break;
					}
					break;
				default:
					break;
				}
				state = 2;
				break;
				// }}}RME
			case 5:
				// {{{RME state ':TOP:Deactivate:Disabled'
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
				case 3: // EngineEnabled
					chain6_engineOn();
					return;
				default:
					break;
				}
				state = 2;
				break;
				// }}}RME
			case 6:
				// {{{RME state ':TOP:Activate'
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
				state = 1;
				break;
				// }}}RME
			case 7:
				// {{{RME state ':TOP:Activate:ConstantSpeed'
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
				case 1: // BrakeApplied
					switch( signal )
					{
					case ACCSSystem.BrakeInterrupt.Base.rti_ApplyBrake:
						chain19_deactivate();
						return;
					default:
						break;
					}
					break;
				case 2: // TopGearEngaged
					switch( signal )
					{
					case ACCSSystem.EnableTopGear.Base.rti_DisengageTopGear:
						chain19_deactivate();
						return;
					default:
						break;
					}
					break;
				case 4: // Command
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Base.rti_StartAccIn:
						chain12_startAcc();
						return;
					case ACCSSystem.LeverCommand.Base.rti_Disable:
						chain19_deactivate();
						return;
					default:
						break;
					}
					break;
				default:
					break;
				}
				state = 6;
				break;
				// }}}RME
			case 8:
				// {{{RME state ':TOP:Activate:Acceleration'
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
				case 1: // BrakeApplied
					switch( signal )
					{
					case ACCSSystem.BrakeInterrupt.Base.rti_ApplyBrake:
						chain17_deactivate();
						return;
					default:
						break;
					}
					break;
				case 2: // TopGearEngaged
					switch( signal )
					{
					case ACCSSystem.EnableTopGear.Base.rti_DisengageTopGear:
						chain17_deactivate();
						return;
					default:
						break;
					}
					break;
				case 4: // Command
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Base.rti_Enable:
						chain16_activate_or_stopAcc();
						return;
					case ACCSSystem.LeverCommand.Base.rti_StopAccIn:
						chain16_activate_or_stopAcc();
						return;
					case ACCSSystem.LeverCommand.Base.rti_ResumeIn:
						chain13_resume();
						return;
					case ACCSSystem.LeverCommand.Base.rti_Disable:
						chain17_deactivate();
						return;
					default:
						break;
					}
					break;
				default:
					break;
				}
				state = 6;
				break;
				// }}}RME
			case 9:
				// {{{RME state ':TOP:Activate:Deceleration'
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
				case 1: // BrakeApplied
					switch( signal )
					{
					case ACCSSystem.BrakeInterrupt.Base.rti_ApplyBrake:
						chain18_deactivate();
						return;
					default:
						break;
					}
					break;
				case 2: // TopGearEngaged
					switch( signal )
					{
					case ACCSSystem.EnableTopGear.Base.rti_DisengageTopGear:
						chain18_deactivate();
						return;
					default:
						break;
					}
					break;
				case 4: // Command
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Base.rti_Enable:
						chain14_activate_or_savedSpeed_engaged();
						return;
					case ACCSSystem.LeverCommand.Base.rti_StartAccIn:
						chain15_startAcc();
						return;
					case ACCSSystem.LeverCommand.Base.rti_Disable:
						chain18_deactivate();
						return;
					default:
						break;
					}
					break;
				case 6: // ReachedSavedSpeed
					switch( signal )
					{
					case ACCSSystem.LeverCommand.Conjugate.rti_Reached:
						chain14_activate_or_savedSpeed_engaged();
						return;
					default:
						break;
					}
					break;
				default:
					break;
				}
				state = 6;
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
		case 0: // BrakeApplied
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.BrakeApplied, index );
			break;
		case 1: // TopGearEngaged
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.TopGearEngaged, index );
			break;
		case 2: // EngineEnabled
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.EngineEnabled, index );
			break;
		case 3: // Command
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.Command, index );
			break;
		case 4: // SendCommand
			if( index < 3 )
				return new com.rational.rosert.BindingEnd( this.SendCommand, index );
			break;
		case 5: // ReachedSavedSpeed
			if( index < 1 )
				return new com.rational.rosert.BindingEnd( this.ReachedSavedSpeed, index );
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
			return ACCSSystem.EnableTopGear.Base.rtDescriptor;
		case 2:
			return ACCSSystem.EnableEngine.Base.rtDescriptor;
		case 3:
			return ACCSSystem.LeverCommand.Base.rtDescriptor;
		case 4:
			return ACCSSystem.LeverCommand.Base.rtDescriptor;
		case 5:
			return ACCSSystem.LeverCommand.Conjugate.rtDescriptor;
		default:
			return super.rtGetRelayProtocol( relay );
		}

	}
	protected int rtGetRelayCount()
	{
		return 6;
	}
	protected int rtGetRelayCardinality( int relay )
	{
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
			return super.rtGetRelayCardinality( relay );
		}

	}
	protected void rtPreparePorts()
	{
		super.rtPreparePorts();

		BrakeApplied = new ACCSSystem.BrakeInterrupt.Base
		(
			this,
			1, // cardinality
			( 1 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		TopGearEngaged = new ACCSSystem.EnableTopGear.Base
		(
			this,
			1, // cardinality
			( 2 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		EngineEnabled = new ACCSSystem.EnableEngine.Base
		(
			this,
			1, // cardinality
			( 3 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		Command = new ACCSSystem.LeverCommand.Base
		(
			this,
			1, // cardinality
			( 4 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		SendCommand = new ACCSSystem.LeverCommand.Base
		(
			this,
			3, // cardinality
			( 5 << com.rational.rosert.Capsule.PortDescriptor.IdShift )
				+ com.rational.rosert.Capsule.PortDescriptor.NotificationDisabled
				+ com.rational.rosert.Capsule.PortDescriptor.RegisterNotPermitted
				+ com.rational.rosert.Capsule.PortDescriptor.Wired
				+ com.rational.rosert.Capsule.PortDescriptor.VisibilityPublic
		);
		ReachedSavedSpeed = new ACCSSystem.LeverCommand.Conjugate
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
		list.add( this.BrakeApplied );
		list.add( this.TopGearEngaged );
		list.add( this.EngineEnabled );
		list.add( this.Command );
		list.add( this.SendCommand );
		list.add( this.ReachedSavedSpeed );
	}
	protected java.lang.String rtGetPortName( int port )
	{
		switch( port )
		{
		case 1:
			return "BrakeApplied";
		case 2:
			return "TopGearEngaged";
		case 3:
			return "EngineEnabled";
		case 4:
			return "Command";
		case 5:
			return "SendCommand";
		case 6:
			return "ReachedSavedSpeed";
		default:
			return super.rtGetPortName( port );
		}
	}
	protected void rtEnumerateAttributes( com.rational.rosert.AttributeList list, com.rational.rosert.ExtendedAttributeList extended )
	{
		super.rtEnumerateAttributes( list, extended );
		this._topGearEngaged = (boolean)list.add( "_topGearEngaged", this._topGearEngaged );
		this.gui = (ACCSGUIPanel)list.add( "gui", this.gui );

	}
}
// }}}RME
