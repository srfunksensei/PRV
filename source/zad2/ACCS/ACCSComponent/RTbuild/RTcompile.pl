@files =
(
	'ACCSSystem/ACCS.java',
	'ACCSSystem/BrakeInterrupt.java',
	'ACCSSystem/CommandLeverSensor.java',
	'ACCSSystem/EnableTopGear.java',
	'ACCSSystem/EnableEngine.java',
	'ACCSSystem/ThrottleActuator.java',
	'ACCSSystem/ThrottleSensor.java',
	'ACCSSystem/WheelShaftSensor.java',
	'ACCSSystem/LeverCommand.java',
	'ACCSSystem/CurrentSpeed.java',
	'ACCSSystem/Parameters.java',
	'ACCSSystem/Voltage.java',
	'ACCSSystem/InjectEventEngine.java',
	'ACCSSystem/InjectEventTopGear.java',
	'ACCSSystem/InjectEventBrake.java',
	'ACCSSystem/InjectEventCommand.java',
	'ACCSSystem/InjectEventFunctionParams.java',
	'ACCSSystem/TmpBrake.java',
	'ACCSSystem/TmpTopGear.java',
	'ACCSSystem/TmpCommand.java',
	'ACCSSystem/TmpManualParams.java',
	'ACCSSystem/TmpFunctionParams.java',
	'ACCSSystem/InjectEventManualParams.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
