# Deal with one line at a time in $_
while (<STDIN>)
{
    # Do both kind of Pig Latin substitution to $_, then print    
	s/([aeiou]\w*)/$1way/ig;
	s/([^aeiou\W]+?)([aeiou]\w*)/$2$1ay/ig;
	print;
}
