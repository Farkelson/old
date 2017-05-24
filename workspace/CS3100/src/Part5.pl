# Store successive lines into $_
while (<STDIN>)
{
    # Loop over matches in $_
    #  Option g = global (all matches)
    while (m/(<([^\"]*?(\".*?[^\\]\"))*[^\"]*?>)/g)
    {
        # Print the first and second capture groups
        print $1 . "\n";
    }
}