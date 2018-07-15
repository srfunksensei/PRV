@files =
(
	'ACCSSystem/ThrottleSensor.java',
	'ACCSSystem/Parameters.java',
	'ACCSSystem/FunctionParameters.java',
	'ACCSSystem/ManualParameters.java',
	'ACCSSystem/EnableEngine.java',
	'ACCSSystem/Voltage.java',
	'ACCSSystem/CurrentSpeed.java',
	'ACCSSystem/WheelShaftSensor.java',
	'ACCSSystem/LeverCommand.java',
	'ACCSSystem/CommandLeverSensor.java',
	'ACCSSystem/BrakeInterrupt.java',
	'ACCSSystem/EnableTopGear.java',
	'ACCSSystem/ThrottleActuator.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
