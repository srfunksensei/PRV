@files =
(
	'ACCSSystem/ThrottleSensor.java',
	'ACCSSystem/Parameters.java',
	'ACCSSystem/FunctionParameters.java',
	'ACCSSystem/ManualParameters.java',
	'ACCSSystem/EnableEngine.java',
	'ACCSSystem/Voltage.java',
	'ACCSSystem/LeverCommand.java',
	'ACCSSystem/WheelShaftSensor.java',
	'ACCSSystem/CurrentSpeed.java',
	'ACCSSystem/BrakeInterrupt.java',
	'ACCSSystem/CommandLeverSensor.java',
	'ACCSSystem/EnableTopGear.java',
	'ACCSSystem/ThrottleActuator.java',
	'ACCSSystem/InjectEventEngine.java',
	'ACCSSystem/InjectEventTopGear.java',
	'ACCSSystem/InjectEventBrake.java',
	'ACCSSystem/InjectEventCommand.java',
	'ACCSSystem/InjectEventParams.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
