while (<STDIN>)
{
    # Replace each occurrence in $_ of the pattern
    # with the value of the expression.
    #  Option g = global (replace all patterns)
    #  Option e = evaluate (evaluate the replacement)    
	s/(\b\d{3}-\d{2}-\d{4}\b)/("###-##-####")/ge;
	print $_;
}