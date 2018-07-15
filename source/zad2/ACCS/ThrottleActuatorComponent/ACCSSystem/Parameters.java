package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::Parameters'
public class Parameters
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
				return rtiLast_Parameters;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_FunctionParams:
					return "FunctionParams";
				case rti_ManualParamrs:
					return "ManualParamrs";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				case rti_FunctionParams:
					return "ACCSSystem.FunctionParameters";
				case rti_ManualParamrs:
					return "ACCSSystem.ManualParameters";
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final Parameters.Base.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_FunctionParams = rtiLast_RootProtocolRole + 1;
		public static final int rti_ManualParamrs = rtiLast_RootProtocolRole + 2;
		protected static final int rtiLast_Parameters = rtiLast_RootProtocolRole + 2;
		public Base( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal FunctionParams()
		{
			return new InSignal( rti_FunctionParams );
		}
		public final InSignal ManualParamrs()
		{
			return new InSignal( rti_ManualParamrs );
		}
		public final OutSignal FunctionalParamsOut( ACCSSystem.FunctionParameters data )
		{
			return new OutSignal( Conjugate.rti_FunctionalParamsOut, data );
		}
		public final OutSignal ManualParamsOut( ACCSSystem.ManualParameters data )
		{
			return new OutSignal( Conjugate.rti_ManualParamsOut, data );
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
				return rtiLast_Parameters;
			}
			public java.lang.String rtGetInSignalName( int signal )
			{
				switch( signal )
				{
				case rti_FunctionalParamsOut:
					return "FunctionalParamsOut";
				case rti_ManualParamsOut:
					return "ManualParamsOut";
				default:
					return super.rtGetInSignalName( signal );
				}

			}
			public java.lang.String rtGetInSignalType( int signal )
			{
				switch( signal )
				{
				case rti_FunctionalParamsOut:
					return "ACCSSystem.FunctionParameters";
				case rti_ManualParamsOut:
					return "ACCSSystem.ManualParameters";
				default:
					return super.rtGetInSignalType( signal );
				}

			}
		}
		// }}}RME
		// {{{RME classAttribute 'rtDescriptor'
		public static final Parameters.Conjugate.Descriptor rtDescriptor = new Descriptor();
		// }}}RME
		public static final int rti_FunctionalParamsOut = rtiLast_RootProtocolRole + 1;
		public static final int rti_ManualParamsOut = rtiLast_RootProtocolRole + 2;
		protected static final int rtiLast_Parameters = rtiLast_RootProtocolRole + 2;
		public Conjugate( com.rational.rosert.Capsule owner, int cardinality, int properties )
		{
			super( owner, cardinality, properties );
		}
		public com.rational.rosert.ProtocolRole.Descriptor rtGetDescriptor()
		{
			return rtDescriptor;
		}
		public final InSignal FunctionalParamsOut()
		{
			return new InSignal( rti_FunctionalParamsOut );
		}
		public final InSignal ManualParamsOut()
		{
			return new InSignal( rti_ManualParamsOut );
		}
		public final OutSignal FunctionParams( ACCSSystem.FunctionParameters data )
		{
			return new OutSignal( Base.rti_FunctionParams, data );
		}
		public final OutSignal ManualParamrs( ACCSSystem.ManualParameters data )
		{
			return new OutSignal( Base.rti_ManualParamrs, data );
		}
	}
	// }}}RME
}
// }}}RME
