package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::Voltage'
public class Voltage
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
				return rtiLast_Voltage;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
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
		public static final Voltage.Base.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		protected static final int rtiLast_Voltage = rtiLast_RootProtocolRole + 0;
		public Base( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final OutSignal ActualVoltage( int data )
		{
			return new OutSignal( Conjugate.rti_ActualVoltage, new java.lang.Integer( data ) );
		}
		public final OutSignal ACCSVoltage( int data )
		{
			return new OutSignal( Conjugate.rti_ACCSVoltage, new java.lang.Integer( data ) );
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
				return rtiLast_Voltage;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_ActualVoltage:
					return "ActualVoltage";
				case rti_ACCSVoltage:
					return "ACCSVoltage";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				case rti_ActualVoltage:
					return "int";
				case rti_ACCSVoltage:
					return "int";
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final Voltage.Conjugate.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_ActualVoltage = rtiLast_RootProtocolRole + 1;
		public static final int rti_ACCSVoltage = rtiLast_RootProtocolRole + 2;
		protected static final int rtiLast_Voltage = rtiLast_RootProtocolRole + 2;
		public Conjugate( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal ActualVoltage()
		{
			return new InSignal( rti_ActualVoltage );
		}
		public final InSignal ACCSVoltage()
		{
			return new InSignal( rti_ACCSVoltage );
		}
	}
	// }}}RME
}
// }}}RME
