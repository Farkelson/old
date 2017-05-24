import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountNumbers
{
    /**
     * Prints out the number of integer literals the input contains
     */
    public static void main (String[] args) throws IOException
    {
        try (Scanner s = new Scanner(System.in))
        {
            // Matches one or more digits
            Pattern p = Pattern.compile("\\d+");
            
            // Use this variable to accumulate the answer
            int count = 0;
            
            // Work on one line at a time
            while (s.hasNextLine())
            {
                // Match on the current line
                Matcher m = p.matcher(s.nextLine());
                
                // Increment the count with each line
                while (m.find())
                {
                    count++;
                }
            }
            
            // Display the answer
            System.out.println(count);
        }
    }
}
