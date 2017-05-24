import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in))
        {
			Pattern p = Pattern.compile("(//.*?\\n)");
            String document = "";
            while (s.hasNextLine())
            {
                document += s.nextLine() + "\n";
            }
            Matcher m = p.matcher(document);
            StringBuffer sb = new StringBuffer();
            while (m.find())
            {
                m.appendReplacement(sb, m.group().toUpperCase());
            }
            m.appendTail(sb);
            System.out.println(sb);
            
        }
	}

}
