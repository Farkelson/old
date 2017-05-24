//Scott Glass
//Jordon Phillips
package assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class TimeCollectionArray {
	private static Random rand;

	public static void main(String[] args) {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		long timesToLoop = 100;

		CollectionArray<Integer> timeArr = new CollectionArray<Integer>();
		
		ArrayList<Integer> timeArrList = new ArrayList<Integer>();
		

		ArrayList<Integer> searchArr = new ArrayList<Integer>();
		for (int i = 0; i < timesToLoop; i++) {
			searchArr.add(randomInt());
		}
		IntegerComparator cmp = new IntegerComparator();
		long startTime, midpointTime, stopTime;

		
		for (int n = 1000; n <= 20000; n += 1000) {
			while (timeArr.size()<n) {
				timeArr.add(randomInt());
			}

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.
			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++)
				timeArr.toSortedList(cmp);

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
			} // empty block

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			long averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
					/ timesToLoop;

			System.out.println(""+averageTime);
			
			//System.out.println("N equals " + n);
		}
		
		
		for (int n = 1000; n <= 20000; n += 1000) {
			while(timeArr.size()<n) {
				timeArr.add(randomInt());
			}
			for (Integer element : timeArr) {
			timeArrList.add(element);
		}
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++)
				SearchUtil.binarySearch(timeArrList, searchArr.get(i), cmp);

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
			} // empty block

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			double averageTime2 = ((midpointTime - startTime) - (stopTime - midpointTime))/ timesToLoop;

			System.out.println("" + averageTime2);
			
			//System.out.println("N equals " + n);
		}
		
		System.out.println();
		ArrayList<Integer> timeArrList2 = new ArrayList<Integer>();
		CollectionArray<Integer> timeArr2 = new CollectionArray<Integer>();
		for (int n = 1000; n <= 20000; n += 1000) {
			while(timeArr2.size()<n) {
				timeArr2.add(randomInt());
			}
			for (Integer element : timeArr2) {
				timeArrList2.add(element);
			}
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++)
				timeArr.contains(searchArr.get(i));

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
			} // empty block

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			double averageTime3 = ((midpointTime - startTime) - (stopTime - midpointTime))/ timesToLoop;

			System.out.println("" + averageTime3);

			// TODO: Write code to time your toSortedList, contains, and
			// SearchUtil.binarySearch methods so you can plot the results.

			//System.out.println("N equals " + n);
		}
	}

	public static Integer randomInt() {
		return new Integer(rand.nextInt());
	}
}
