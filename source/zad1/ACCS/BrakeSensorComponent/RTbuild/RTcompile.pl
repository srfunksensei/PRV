@files =
(
	'ACCSSystem/BrakeSensor.java',
	'ACCSSystem/BrakeInterrupt.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
