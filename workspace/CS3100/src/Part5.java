import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in))
        {
			Pattern p = Pattern.compile("<([^\n\"]*?(\".*?\\w\"))*[^\"]*?>");
            String document = "";
            while (s.hasNextLine())
            {
                document += s.nextLine() + "\n";
            }
            Matcher m = p.matcher(document);
            while (m.find())
            {
                System.out.println(m.group());
            }
            
        }
	}

}