package assignment4;

import java.util.ArrayList;

public class SortUtilTiming {
	public static void main(String[] args) {
		long startTime, midpointTime, stopTime;

		ArrayList<Integer> timinglist = new ArrayList<Integer>();
		long timesToLoop = 1000;
		for (int z = 0; z < 10; z++) {
			timinglist = SortUtil.generateAverageCase(10000);

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				SortUtil.setPivotNum(1);
				SortUtil.quicksort(timinglist);
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

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				SortUtil.setPivotNum(2);
				SortUtil.quicksort(timinglist);
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

			System.out.println();
			
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				SortUtil.setPivotNum(3);
				SortUtil.quicksort(timinglist);
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

			System.out.println();
		}
	}
}
