package ACCSSystem;
// {{{RME classifier 'Logical View::ACCSSystem::ManualParameters'
public class ManualParameters
{
	// {{{RME classAttribute '_manualThrottleVoltage'
	public int _manualThrottleVoltage = 0;
	// }}}RME
	// {{{RME classAttribute '_manualSpeed'
	public int _manualSpeed = 0;
	// }}}RME
	// {{{RME operation 'ManualParameters(int,int)'
	public ManualParameters( int speed, int throttle )
	{
		_manualSpeed = speed;
		_manualThrottleVoltage = throttle;
	}
	// }}}RME
}
// }}}RME
