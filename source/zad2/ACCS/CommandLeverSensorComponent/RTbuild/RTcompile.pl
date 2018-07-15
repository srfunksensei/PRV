@files =
(
	'ACCSSystem/CommandLeverSensor.java',
	'ACCSSystem/BrakeInterrupt.java',
	'ACCSSystem/EnableTopGear.java',
	'ACCSSystem/EnableEngine.java',
	'ACCSSystem/LeverCommand.java',
	'ACCSSystem/WheelShaftSensor.java',
	'ACCSSystem/CurrentSpeed.java',
	'ACCSSystem/Parameters.java',
	'ACCSSystem/ThrottleActuator.java',
	'ACCSSystem/Voltage.java',
	'ACCSSystem/InjectEventEngine.java',
	'ACCSSystem/InjectEventTopGear.java',
	'ACCSSystem/InjectEventBrake.java',
	'ACCSSystem/InjectEventCommand.java',
	'ACCSSystem/InjectEventFunctionParams.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
