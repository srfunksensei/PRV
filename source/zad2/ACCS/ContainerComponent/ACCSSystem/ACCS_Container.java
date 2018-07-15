package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::ACCS_Container'
public class ACCS_Container extends com.rational.rosert.Capsule
{
	protected static final com.rational.rosert.CapsuleRole aCCSR1;
	// {{{RME tool 'RTJava' property 'InitializationCode'
	static
	{
		aCCSR1 = new com.rational.rosert.CapsuleRole
		(
			"ACCSSystem.ACCS",
			1,
			( 0 << com.rational.rosert.CapsuleRole.IdShift )
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
	protected com.rational.rosert.CapsuleRole rtGetCapsuleRole( int role )
	{
		switch( role )
		{
		case 0:
			return this.aCCSR1;
		default:
			return super.rtGetCapsuleRole( role );
		}

	}
	protected java.lang.String rtGetCapsuleRoleName( int role )
	{
		switch( role )
		{
		case 0:
			return "aCCSR1";
		default:
			return super.rtGetCapsuleRoleName( role );
		}

	}
	protected int rtGetConnectorCount( int role )
	{
		switch( role )
		{
		case 0: // aCCSR1
			return 0;
		default:
			return super.rtGetConnectorCount( role );
		}

	}
	protected int rtGetCapsuleRoleCount()
	{
		return 1;
	}
}
// }}}RME
