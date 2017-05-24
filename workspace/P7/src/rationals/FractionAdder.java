package rationals;

public class FractionAdder {

	/**
	 * Sums the series 1 + 1/2 + 1/3 + ... + 1/n for different
	 * values of n using different ways of representing fractions
	 */
	public static void main(String[] args) {

		// Try different values of n
		for (int n = 1; n <= 60; n++) {
			System.out.println("n = " + n);
			
			// Sum the series using IntRats.
			IntRat isum = new IntRat(0);
			for (int i = 1; i <= n; i++) {
				isum = isum.add(new IntRat(1,i));
			}
			System.out.println("   IntRats:\t" + isum);
			
			// Sum the series using IntRats.
			LongRat lsum = new LongRat(0);
			for (int i = 1; i <= n; i++) {
				lsum = lsum.add(new LongRat(1,i));
			}
			System.out.println("   LongRats: \t" + lsum);
			
			// Sum the series using BigRats.
			BigRat rsum = new BigRat(0);
			for (int i = 1; i <= n; i++) {
				rsum = rsum.add(new BigRat(1,i));
			}
			System.out.println("   BigRats: \t" + rsum);
			
			System.out.println();
			
		}
	}

}
