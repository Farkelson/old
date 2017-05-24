# The loop reads all of the input into $text
while (<STDIN>)
{
	$text .= $_;
}

# Replace each comment with "COMMENT"
#  Option g = global (replace all matches)
#  Option s = let . match newlines
$text =~ s!(//.*?\n)!uc($1)!ge;
print $text;
