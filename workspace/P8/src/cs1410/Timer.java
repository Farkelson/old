package cs1410;

public class Timer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int size = 10;
		System.out.println("Size\tTime (msec)");
		for (int i = 0; i < 20; i++) {
			System.out.println(size  + "\t" + 
		                       time(size)/1e6);
			size *= 2;
		}

	}
	
	
	/**
	 * Returns the amount of time (using a crude
	 * timing methodology) it takes to add n strings
	 * into an intially empty DynamicArray.
	 */
	public static long time (int n) {
		DynamicArray2 a = new DynamicArray2();
		long start = System.nanoTime();
		while (n > 0) {
			a.add("A");
			n--;
		}
		long stop = System.nanoTime();
		return stop - start;
	}

}
