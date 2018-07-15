@files =
(
	'ACCSSystem/ACCS_Container.java',
	'ACCSSystem/ACCS.java',
	'ACCSSystem/BrakeSensor.java',
	'ACCSSystem/BrakeInterrupt.java',
	'ACCSSystem/CommandLeverSensor.java',
	'ACCSSystem/EnableTopGear.java',
	'ACCSSystem/EnableEngine.java',
	'ACCSSystem/LeverCommand.java',
	'ACCSSystem/WheelShaftSensor.java',
	'ACCSSystem/Parameters.java',
	'ACCSSystem/FunctionParameters.java',
	'ACCSSystem/ManualParameters.java',
	'ACCSSystem/CurrentSpeed.java',
	'ACCSSystem/ThrottleActuator.java',
	'ACCSSystem/Voltage.java',
	'ACCSSystem/EngineSensor.java',
	'ACCSSystem/TopGearSensor.java',
	'ACCSSystem/ThrottleSensor.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
