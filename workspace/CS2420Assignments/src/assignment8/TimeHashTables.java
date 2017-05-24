package assignment8;

import java.util.Random;

public class TimeHashTables {
	
	public static String generateString()
	{
		Random rng = new Random();
		int length = rng.nextInt(50);
		 String characters= "abcdefghijklmnopqrstuvwxyz";
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}

	public static void main(String[] args) {
		long startTime, midpointTime, stopTime;
		long timesToLoop = 1000;
		int colisions = 0;
		for (int n = 1000; n <= 10000; n += 1000) {
			
			//Uncomment the HashFunctor you wanted to test.
			QuadProbeHashTable QPHT = new QuadProbeHashTable(1,new BadHashFunctor());
//			QuadProbeHashTable QPHT = new QuadProbeHashTable(1,new MediocreHashFunctor());
			
			//Uncomment which table to use
//			QuadProbeHashTable QPHT = new QuadProbeHashTable(1,new GoodHashFunctor());
//			ChainingHashTable CHT = new ChainingHashTable(1,new GoodHashFunctor());
			
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				for(long g = 0; g<n;g++){
					QPHT.add(generateString());
//					CHT.add(generateString());
					
				}
				colisions += QPHT.totalCollisions;
				QPHT.clear();
//				CHT.clear();
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
				QPHT.clear();
//				CHT.clear();
				for(long g = 0; g<n;g++){
					generateString();
				}
			} // empty block

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
					/ timesToLoop;

//			System.out.println("" + averageTime);
			colisions = (int) (colisions/timesToLoop);
			System.out.println("" + colisions);
		}
	}

}
