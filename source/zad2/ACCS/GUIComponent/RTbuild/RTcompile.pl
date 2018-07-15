@files =
(
	'ACCSGUI/ACCSGUIPanel.java',
	'ACCSGUI/ListenerA.java',
	'ACCSGUI/ButtonEvent.java',
	'ACCSGUI/ButtonValues.java',
	'java/awt/event/MouseAdapter.java',
	'ACCSSystem/FunctionParameters.java',
	'ACCSSystem/ManualParameters.java',
	'ACCSGUI/ListenerMP.java',
	'ACCSGUI/ListenerFP.java'
);

foreach ( @ARGV )
{
	s/^.*\s.*$/"$&"/;
}

$status = system( @ARGV, @files );

exit $status if $status & 0xFF;
exit $status >> 8;
