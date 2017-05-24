package assignment9;

import java.util.Random;

public class TimePriorityQueue {
	
	public static void main(String[] args) {
		long startTime, midpointTime, stopTime;
		long timesToLoop = 10000;
		
		for (int n = 1000; n <= 10000; n += 1000) {
			
			
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block
//			PriorityQueueHEAP<Integer> time_heap = new PriorityQueueHEAP<Integer>();
//			for (int j = 0; j < n; j++) {
//				time_heap.add(j);
//			}
			// Now, run the test.
			startTime = System.nanoTime();

			for (long i = 0; i < timesToLoop; i++) {
				PriorityQueueBST<Integer> bst = new PriorityQueueBST<Integer>();

				for(long g = 0; g < n - 1;g++){
//					time_heap.deleteMin();
					bst.add((int) i);
				}
//				time_heap.findMin();
//				time_heap.clear();
				bst.clear();
//				
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
//				PriorityQueueHEAP<Integer> time_heap = new PriorityQueueHEAP<Integer>();
				PriorityQueueBST<Integer> bst = new PriorityQueueBST<Integer>();
//			    for (int j = 0; j < n; j++)
//			    {
//			        time_heap.add(j);
//			    }
//			    time_heap.clear();
				bst.clear();
								
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
