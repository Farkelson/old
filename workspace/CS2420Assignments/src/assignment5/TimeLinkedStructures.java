//Scott Glass
//Jordon Phillips
package assignment5;

import java.util.ArrayList;

public class TimeLinkedStructures {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime, midpointTime, stopTime;

		long timesToLoop = 10000;

		// Testing the add methods

		MyLinkedList<Integer> Linklist = new MyLinkedList<Integer>();

		for (int z = 0; z < 10; z++) {

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				Linklist.addFirst(5);
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

			System.out.println("" + averageTime);
		}
		System.out.println();

		ArrayList<Integer> Arrlist = new ArrayList<Integer>();

		for (int y = 0; y < 10; y++) {

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				Arrlist.add(0, 5);
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

			System.out.println("" + averageTime);
		}

		// Testing the get methods

		for (int s = 1000; s <= 20000; s += 1000) {
			Linklist = new MyLinkedList<Integer>();
			Linklist.clear();
			for (int k = 0; k <= s; k++) {
				Linklist.addFirst(k);
			}
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				Linklist.get(s / 2);
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

			System.out.println("" + averageTime);

			System.out.println();

			Arrlist = new ArrayList<Integer>();
			Arrlist.clear();
			for (int j = 0; j <= s; j++) {
				Arrlist.add(j);
			}

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				Arrlist.get(s / 2);
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
			} // empty block

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
					/ timesToLoop;

			System.out.println("" + averageTime);

		}

		// Testing remove methods

		for (int s = 10000; s <= 100000; s += 10000) {
			Linklist = new MyLinkedList<Integer>();
			Linklist.clear();
			for (int k = 0; k <= s; k++) {
				Linklist.addFirst(k);
			}
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				Linklist = new MyLinkedList<Integer>();
				for (int k = 0; k <= s; k++) {
					Linklist.addFirst(k);
				}
				Linklist.remove(s / 2);
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
				Linklist = new MyLinkedList<Integer>();
				for (int k = 0; k <= s; k++) {
					Linklist.addFirst(k);
				}
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
					/ timesToLoop;

			System.out.println("" + averageTime);

			System.out.println();

			Arrlist = new ArrayList<Integer>();
			Arrlist.clear();
			for (int j = 0; j <= s; j++) {
				Arrlist.add(j);
			}

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				Arrlist = new ArrayList<Integer>();
				for (int j = 0; j <= s; j++) {
					Arrlist.add(j);
				}
				Arrlist.remove(s / 2);
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
				Arrlist = new ArrayList<Integer>();
				for (int j = 0; j <= s; j++) {
					Arrlist.add(j);
				}
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
					/ timesToLoop;

			System.out.println("" + averageTime);

		}
	}
}
