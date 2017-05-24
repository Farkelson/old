# Consider one line at a time; store it in $_
while (<STDIN>)
{
    # Increment $count for each match found
    #  Option g = global (consider all matches)   
	while (m/\d+/g)
	{
		$count++;
	}
}

print $count;
