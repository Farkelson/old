package assignment10;

import java.io.File;
import java.util.Random;

public class TimeSpelling {
	
	public static void main(String[] args) {
		long startTime, midpointTime, stopTime;
		long timesToLoop = 1000;
		for (int n = 10; n <= 100; n += 10) {
			Random rng = new Random();
			String characters = "abcdefghijklmnopqrstuvwxyz";
			char[] text = new char[n];
			for (int i = 0; i < n; i++) {
				text[i] = characters.charAt(rng.nextInt(characters.length()));
			}
			String test = new String(text);
			
			SpellingFunctions.setFr(true);
			//BestWordSearch.populateDictionary(new File("WordStats.txt"));

			
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.
			startTime = System.nanoTime();
			
			SpellingCorrection.populate(new File("WordStats.txt"));

			for (long i = 0; i < timesToLoop; i++) {
				SpellingCorrection.process(test);
				//SpellingFunctions.run_ALL_the_functions(test);
				//BestWordSearch.run_ALL_the_functions(test);
				//BestWordSearch.getBest(test);
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
				
								
			} // empty block

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
					/ timesToLoop;
			
			//ystem.out.printf("%d\n",CHT.getTotalCollisions());
			//CHT.setTotalCollisions(0);
			System.out.println(" " + averageTime);
		}
	}

}

