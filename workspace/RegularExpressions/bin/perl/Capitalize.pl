# The loop condition stores one line at a time into $_
while (<STDIN>)
{
    # Replace each occurrence in $_ of the pattern
    # with the value of the expression.
    #  Option g = global (replace all patterns)
    #  Option e = evaluate (evaluate the replacement)    
	s/(\w+)/uc(substr($1,0,1)) . substr($1,1)/ge;
	print $_;
}
