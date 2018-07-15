package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::EnableEngine'
public class EnableEngine
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
				return rtiLast_EnableEngine;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_Enable:
					return "Enable";
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
		public static final EnableEngine.Base.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_Enable = rtiLast_RootProtocolRole + 1;
		public static final int rti_Disable = rtiLast_RootProtocolRole + 2;
		protected static final int rtiLast_EnableEngine = rtiLast_RootProtocolRole + 2;
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
		public final InSignal Disable()
		{
			return new InSignal( rti_Disable );
		}
		public final OutSignal Engine_on()
		{
			return new OutSignal( Conjugate.rti_Engine_on );
		}
		public final OutSignal Engine_off()
		{
			return new OutSignal( Conjugate.rti_Engine_off );
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
				return rtiLast_EnableEngine;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_Engine_on:
					return "Engine_on";
				case rti_Engine_off:
					return "Engine_off";
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
		public static final EnableEngine.Conjugate.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_Engine_on = rtiLast_RootProtocolRole + 1;
		public static final int rti_Engine_off = rtiLast_RootProtocolRole + 2;
		protected static final int rtiLast_EnableEngine = rtiLast_RootProtocolRole + 2;
		public Conjugate( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal Engine_on()
		{
			return new InSignal( rti_Engine_on );
		}
		public final InSignal Engine_off()
		{
			return new InSignal( rti_Engine_off );
		}
		public final OutSignal Enable()
		{
			return new OutSignal( Base.rti_Enable );
		}
		public final OutSignal Disable()
		{
			return new OutSignal( Base.rti_Disable );
		}
	}
	// }}}RME
}
// }}}RME
