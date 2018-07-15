package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::EnableTopGear'
public class EnableTopGear
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
				return rtiLast_EnableTopGear;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_EngageTopGear:
					return "EngageTopGear";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				case rti_EngageTopGear:
					return "boolean";
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final EnableTopGear.Base.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_EngageTopGear = rtiLast_RootProtocolRole + 1;
		protected static final int rtiLast_EnableTopGear = rtiLast_RootProtocolRole + 1;
		public Base( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal EngageTopGear()
		{
			return new InSignal( rti_EngageTopGear );
		}
		public final OutSignal TopGearEngaged()
		{
			return new OutSignal( Conjugate.rti_TopGearEngaged );
		}
		public final OutSignal TopGearDisengaged()
		{
			return new OutSignal( Conjugate.rti_TopGearDisengaged );
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
				return rtiLast_EnableTopGear;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_TopGearEngaged:
					return "TopGearEngaged";
				case rti_TopGearDisengaged:
					return "TopGearDisengaged";
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
		public static final EnableTopGear.Conjugate.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_TopGearEngaged = rtiLast_RootProtocolRole + 1;
		public static final int rti_TopGearDisengaged = rtiLast_RootProtocolRole + 2;
		protected static final int rtiLast_EnableTopGear = rtiLast_RootProtocolRole + 2;
		public Conjugate( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal TopGearEngaged()
		{
			return new InSignal( rti_TopGearEngaged );
		}
		public final InSignal TopGearDisengaged()
		{
			return new InSignal( rti_TopGearDisengaged );
		}
		public final OutSignal EngageTopGear( boolean data )
		{
			return new OutSignal( Base.rti_EngageTopGear, new java.lang.Boolean( data ) );
		}
	}
	// }}}RME
}
// }}}RME
