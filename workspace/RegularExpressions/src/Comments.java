import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comments
{
    /**
     * Replaces all comments with the string COMMENT.  Comments begin
     * with slash-star and end with star-slash.  The beginning and end
     * don't have to be on the same line.
     */
	public static void main (String[] args) throws IOException
	{
		try (Scanner s = new Scanner(System.in))
		{
		    // This regex matches comments.  Two things are noteworthy.  First,
		    // the .*? in the pattern is reluctant.  Also, the second parameter
		    // allows a dot to match newline characters.  Why are both of
		    // these necessary?
			Pattern p = Pattern.compile("(/\\*.*?\\*/)", Pattern.DOTALL);

			// Pull the entire document into a string
			String document = "";
			while (s.hasNextLine())
			{
				document += s.nextLine() + "\n";
			}

			// Replace every substring that matches the pattern with
			// the string "COMMENT"
			Matcher m = p.matcher(document);
			String result = m.replaceAll("COMMENT");
			
			// Print out the result
			System.out.println(result);
		}
	}
}
