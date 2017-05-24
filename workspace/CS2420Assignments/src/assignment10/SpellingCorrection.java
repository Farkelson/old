package assignment10;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpellingCorrection {

	public static void main(String[] args) {

		File wordStats = null;
		SpellingFunctions.setFr(false);

		if (args.length > 2) // Ensure that there are no more than two arguments
		{
			System.out.println("\nIncorrect number of arguments!\n");
			return;
		} else if (args.length < 1) // Ensure that there is at least one
									// argument
		{
			System.out.println("\nIncorrect number of arguments!\n");
			return;
		}
		// if there are two aguments check if fr should be activated
		else if (args.length == 2 && args[1].equals("-fr")) {
			SpellingFunctions.setFr(true);
		} else if (args.length == 2 && args[1] != "-fr") {
			System.out.println("Invalid file report option argument");
		}

		// create a file object using the File class like before
		wordStats = new File(args[0]);
		// check to make sure the file is real (use .isFile())
		if (!wordStats.isFile()) {
			// If the file is invalid then print a message and return
			System.out.println("Invalid word statistics file argument!");
			return;

		}

		populate(wordStats);

		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		System.out.println("Spelling correction program is active... please enter a word\n");

		while (true) {

			String input = scanner.nextLine();

			if (input.equals("exit")) {
				System.out.println("Spelling Correction program is exiting... have a nice day.");
				break;
			}

			else {
				process(input);
			}
		}
	}

	public static void process(String input) {
		if (SpellingFunctions.dictionary.containsKey(input)) {
			System.out.printf("%s is a known term\n", input);
			if(SpellingFunctions.fr_isActive){
				SpellingFunctions.run_ALL_the_functions(input);
			}
			
		} else {
			BestWordSearch.run_ALL_the_functions(input);
			BestWordSearch.getBest(input);
			if(SpellingFunctions.fr_isActive){
				SpellingFunctions.run_ALL_the_functions(input);
			}
		}
	}


	public static void populate(File stats) {
		SpellingFunctions.populateDictionary(stats);
		BestWordSearch.populateDictionary(stats);
	}

}
