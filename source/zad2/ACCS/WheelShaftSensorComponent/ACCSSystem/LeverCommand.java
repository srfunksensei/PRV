package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::LeverCommand'
public class LeverCommand
{
	// {{{RME classifier 'Base'
	public static class Base extends com.rational.rosert.RootProtocolRole
	{
		// {{{RME classifier 'Descriptor'
		public static class Descriptor extends com.rational.rosert.RootProtocolRole.Descriptor
		{
			public com.rational.rosert.ProtocolRole.Descriptor rtGetConjugate()
			{
				return Conjugate.rtDescriptor;
			}
			public int rtGetInSignalCount()
			{
				return rtiLast_LeverCommand;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_Enable:
					return "Enable";
				case rti_StartAccIn:
					return "StartAccIn";
				case rti_StopAccIn:
					return "StopAccIn";
				case rti_ResumeIn:
					return "ResumeIn";
				case rti_Disable:
					return "Disable";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final LeverCommand.Base.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_Enable = rtiLast_RootProtocolRole + 1;
		public static final int rti_StartAccIn = rtiLast_RootProtocolRole + 2;
		public static final int rti_StopAccIn = rtiLast_RootProtocolRole + 3;
		public static final int rti_ResumeIn = rtiLast_RootProtocolRole + 4;
		public static final int rti_Disable = rtiLast_RootProtocolRole + 5;
		protected static final int rtiLast_LeverCommand = rtiLast_RootProtocolRole + 5;
		public Base( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal Enable()
		{
			return new InSignal( rti_Enable );
		}
		public final InSignal StartAccIn()
		{
			return new InSignal( rti_StartAccIn );
		}
		public final InSignal StopAccIn()
		{
			return new InSignal( rti_StopAccIn );
		}
		public final InSignal ResumeIn()
		{
			return new InSignal( rti_ResumeIn );
		}
		public final InSignal Disable()
		{
			return new InSignal( rti_Disable );
		}
		public final OutSignal Activate()
		{
			return new OutSignal( Conjugate.rti_Activate );
		}
		public final OutSignal StartAcc()
		{
			return new OutSignal( Conjugate.rti_StartAcc );
		}
		public final OutSignal Resume()
		{
			return new OutSignal( Conjugate.rti_Resume );
		}
		public final OutSignal Deactivate()
		{
			return new OutSignal( Conjugate.rti_Deactivate );
		}
		public final OutSignal Reached()
		{
			return new OutSignal( Conjugate.rti_Reached );
		}
	}
	// }}}RME
	// {{{RME classifier 'Conjugate'
	public static class Conjugate extends com.rational.rosert.RootProtocolRole
	{
		// {{{RME classifier 'Descriptor'
		public static class Descriptor extends com.rational.rosert.RootProtocolRole.Descriptor
		{
			public com.rational.rosert.ProtocolRole.Descriptor rtGetConjugate()
			{
				return Base.rtDescriptor;
			}
			public int rtGetInSignalCount()
			{
				return rtiLast_LeverCommand;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_Activate:
					return "Activate";
				case rti_StartAcc:
					return "StartAcc";
				case rti_Resume:
					return "Resume";
				case rti_Deactivate:
					return "Deactivate";
				case rti_Reached:
					return "Reached";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final LeverCommand.Conjugate.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_Activate = rtiLast_RootProtocolRole + 1;
		public static final int rti_StartAcc = rtiLast_RootProtocolRole + 2;
		public static final int rti_Resume = rtiLast_RootProtocolRole + 3;
		public static final int rti_Deactivate = rtiLast_RootProtocolRole + 4;
		public static final int rti_Reached = rtiLast_RootProtocolRole + 5;
		protected static final int rtiLast_LeverCommand = rtiLast_RootProtocolRole + 5;
		public Conjugate( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal Activate()
		{
			return new InSignal( rti_Activate );
		}
		public final InSignal StartAcc()
		{
			return new InSignal( rti_StartAcc );
		}
		public final InSignal Resume()
		{
			return new InSignal( rti_Resume );
		}
		public final InSignal Deactivate()
		{
			return new InSignal( rti_Deactivate );
		}
		public final InSignal Reached()
		{
			return new InSignal( rti_Reached );
		}
		public final OutSignal Enable()
		{
			return new OutSignal( Base.rti_Enable );
		}
		public final OutSignal StartAccIn()
		{
			return new OutSignal( Base.rti_StartAccIn );
		}
		public final OutSignal StopAccIn()
		{
			return new OutSignal( Base.rti_StopAccIn );
		}
		public final OutSignal ResumeIn()
		{
			return new OutSignal( Base.rti_ResumeIn );
		}
		public final OutSignal Disable()
		{
			return new OutSignal( Base.rti_Disable );
		}
	}
	// }}}RME
}
// }}}RME
