import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatin
{
    /**
     * Converts the input to Pig Latin.
     */
    public static void main (String[] args) throws IOException
    {
        try (Scanner s = new Scanner(System.in))
        {
            // The first part of the pattern matches strings that contain a vowel
            // but that don't begin with a vowel. The second pattern matches words
            // that begin with a vowel.
            Pattern p = Pattern.compile("([^aeiou\\W]+)([aeiou]\\w*)" + "|" + "([aeiou]\\w*)",
                    Pattern.CASE_INSENSITIVE);
            
            // Work on one line at a time
            while (s.hasNextLine())
            {
                // Match on the current line
                Matcher m = p.matcher(s.nextLine());
                
                // The modified text will be accumulated into the StringBuffer
                StringBuffer sb = new StringBuffer();
                
                // Replace each matched word with its Pig Latin equivalent
                while (m.find())
                {
                    // This part deals with matches to the first part of the pattern
                    if (m.group(1) != null)
                    {
                        m.appendReplacement(sb, "$2$1ay");
                    }
                    // This part deals with matches to the second part of the pattern
                    else
                    {
                        m.appendReplacement(sb, "$3way");
                    }
                }
                
                // Copy over any remaining text into the StringBuffer, then print it out.
                m.appendTail(sb);
                System.out.println(sb);
            }
        }
    }
}
