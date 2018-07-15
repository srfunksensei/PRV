package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::CurrentSpeed'
public class CurrentSpeed
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
				return rtiLast_CurrentSpeed;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_GetCurrSpeed:
					return "GetCurrSpeed";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				case rti_GetCurrSpeed:
					return "int";
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final CurrentSpeed.Base.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_GetCurrSpeed = rtiLast_RootProtocolRole + 1;
		protected static final int rtiLast_CurrentSpeed = rtiLast_RootProtocolRole + 1;
		public Base( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal GetCurrSpeed()
		{
			return new InSignal( rti_GetCurrSpeed );
		}
		public final OutSignal SendCurrSpeed( int data )
		{
			return new OutSignal( Conjugate.rti_SendCurrSpeed, new java.lang.Integer( data ) );
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
				return rtiLast_CurrentSpeed;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_SendCurrSpeed:
					return "SendCurrSpeed";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				case rti_SendCurrSpeed:
					return "int";
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final CurrentSpeed.Conjugate.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_SendCurrSpeed = rtiLast_RootProtocolRole + 1;
		protected static final int rtiLast_CurrentSpeed = rtiLast_RootProtocolRole + 1;
		public Conjugate( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal SendCurrSpeed()
		{
			return new InSignal( rti_SendCurrSpeed );
		}
		public final OutSignal GetCurrSpeed( int data )
		{
			return new OutSignal( Base.rti_GetCurrSpeed, new java.lang.Integer( data ) );
		}
	}
	// }}}RME
}
// }}}RME
