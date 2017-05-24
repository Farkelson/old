import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in))
        {
            Pattern p = Pattern.compile("\\(\\d{3}\\) ?\\d{3}-\\d{4}\\b");
            int count = 0;
            String document = "";
            while (s.hasNextLine())
            {
                document += s.nextLine() + "\n";
            }
            Matcher m = p.matcher(document);
            while (m.find())
            {
                count++;
            }
            System.out.println(count + "\n");
        }
	}
}
