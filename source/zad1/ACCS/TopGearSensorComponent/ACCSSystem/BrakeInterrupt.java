package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::BrakeInterrupt'
public class BrakeInterrupt
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
				return rtiLast_BrakeInterrupt;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_ApplyBrake:
					return "ApplyBrake";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				case rti_ApplyBrake:
					return "boolean";
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final BrakeInterrupt.Base.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_ApplyBrake = rtiLast_RootProtocolRole + 1;
		protected static final int rtiLast_BrakeInterrupt = rtiLast_RootProtocolRole + 1;
		public Base( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal ApplyBrake()
		{
			return new InSignal( rti_ApplyBrake );
		}
		public final OutSignal BrakeApplied()
		{
			return new OutSignal( Conjugate.rti_BrakeApplied );
		}
		public final OutSignal BrakeReleased()
		{
			return new OutSignal( Conjugate.rti_BrakeReleased );
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
				return rtiLast_BrakeInterrupt;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_BrakeApplied:
					return "BrakeApplied";
				case rti_BrakeReleased:
					return "BrakeReleased";
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
		public static final BrakeInterrupt.Conjugate.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_BrakeApplied = rtiLast_RootProtocolRole + 1;
		public static final int rti_BrakeReleased = rtiLast_RootProtocolRole + 2;
		protected static final int rtiLast_BrakeInterrupt = rtiLast_RootProtocolRole + 2;
		public Conjugate( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal BrakeApplied()
		{
			return new InSignal( rti_BrakeApplied );
		}
		public final InSignal BrakeReleased()
		{
			return new InSignal( rti_BrakeReleased );
		}
		public final OutSignal ApplyBrake( boolean data )
		{
			return new OutSignal( Base.rti_ApplyBrake, new java.lang.Boolean( data ) );
		}
	}
	// }}}RME
}
// }}}RME
