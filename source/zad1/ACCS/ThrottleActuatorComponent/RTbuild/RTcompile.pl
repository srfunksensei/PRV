@files =
(
	'ACCSSystem/ThrottleActuator.java',
	'ACCSSystem/CurrentSpeed.java',
	'ACCSSystem/LeverCommand.java',
	'ACCSSystem/Voltage.java',
	'ACCSSystem/WheelShaftSensor.java',
	'ACCSSystem/EnableEngine.java',
	'ACCSSystem/Parameters.java',
	'ACCSSystem/FunctionParameters.java',
	'ACCSSystem/ManualParameters.java',
	'ACCSSystem/CommandLeverSensor.java',
	'ACCSSystem/BrakeInterrupt.java',
	'ACCSSystem/EnableTopGear.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
