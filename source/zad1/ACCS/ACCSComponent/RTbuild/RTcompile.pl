@files =
(
	'ACCSSystem/ACCS.java',
	'ACCSSystem/BrakeSensor.java',
	'ACCSSystem/BrakeInterrupt.java',
	'ACCSSystem/CommandLeverSensor.java',
	'ACCSSystem/EnableTopGear.java',
	'ACCSSystem/EnableEngine.java',
	'ACCSSystem/EngineSensor.java',
	'ACCSSystem/TopGearSensor.java',
	'ACCSSystem/ThrottleActuator.java',
	'ACCSSystem/ThrottleSensor.java',
	'ACCSSystem/WheelShaftSensor.java',
	'ACCSSystem/LeverCommand.java',
	'ACCSSystem/CurrentSpeed.java',
	'ACCSSystem/Parameters.java',
	'ACCSSystem/FunctionParameters.java',
	'ACCSSystem/ManualParameters.java',
	'ACCSSystem/Voltage.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
