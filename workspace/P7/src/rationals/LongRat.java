package rationals;

/**
 * Provides objects that represent rational numbers (fractions), as long
 * as their numerators and denominators can be represented with longs.
 */
public class LongRat {
	
	public static void main (String [] args){
		LongRat x = new LongRat();
		System.out.println(x);
		x = new LongRat(7);
		System.out.println(x);
		x = new LongRat("3", "9");
		System.out.println(x);
		x = new LongRat(15,30);
		System.out.println(x);
		//x = new LongRat("four", "six");
		//System.out.println(x);
		
	}
	
	// (Abstraction function:)
	// Represents the rational number num/den where:
	
	// (Representation invariant:)
	// den > 0
	// gcd(|num|, den) = 1   (in lowest terms)
	private long num;
	private long den;
	
	/**
	 * Creates the rational number 0
	 */
	public LongRat () {
		// The following line of code uses the LongRat(long,long) constructor
		// to initialize the object.
		this(0,1);
	}
	
	/**
	 * Creates the rational number n
	 */
	public LongRat (long n) {
		// The following line of code uses the LongRat(long,long) constructor
		// to initialize the object.
		this(n,1);
	}
	
	/**
	 * If n and d can be parsed as the longs n' and d':
	 *    Throws an IllegalArgumentException if d' = 0
	 *    Creates the rational number n'/d' otherwise.
	 * If n or d can't be parsed, throws a NumberFormatException.
	 */
	public LongRat(String n, String d) {
		// Note:  The following line of code uses the LongRat(long,long) constructor
		// to initialize the object.
		this(Long.parseLong(n), Long.parseLong(d));
	}

	/**
	 * If d is zero, throws an IllegalArgumentException
	 * Creates a Rat that represents the fraction n/d 
	 */
	public LongRat(long n, long d) {
		
		// Throw an exception for zero denominator
		if (d == 0) {
			throw new IllegalArgumentException();
		}
		
		// Make sure that d is positive
		if (d < 0) {
			n = -n;
			d = -d;
		}
		
		// Put n and d in lowest terms
		long g = gcd(Math.abs(n), d);
		
		// Save the num and den
		num = n/g;
		den = d/g;
	}
	


	/**
	 * Returns the sum of the two Rats this and r
	 * a/b + c/d = (ad + cb)/bd
	 */
	public LongRat add(LongRat r) {
		return new LongRat(this.num*r.den + r.num*this.den,
				       this.den*r.den);
	}
	
	/**
	 * Returns the difference of the two Rats this and r
	 * a/b - c/d = (ad - cb)/bd
	 */
	public LongRat sub(LongRat r) {
		return new LongRat(this.num*r.den - r.num*this.den, 
						this.den*r.den);
	}

	/**
	 * Returns the product of the two Rats this and r
	 * a/b * c/d = ac/bd
	 */
	public LongRat mul(LongRat r) {
		return new LongRat(this.num*r.num, this.den*r.den);
	}
	
	/**
	 * If r is zero, throws an IllegalArgumentException.
	 * Otherwise, returns the quotient of the two Rats this and r.  
	 * a/b / c/d = ad/bc
	 */
	public LongRat div(LongRat r) {
		if (r.num == 0){
			throw new IllegalArgumentException();
		}
		return new LongRat(this.num*r.den, this.den*r.num);
	}
	

	/**
	 * Returns a negative number if this < r
	 * Returns zero if this = r
	 * Returns a positive number if this > r
	 * a/b < c/d if and ony if ad < cb
	 */
	public int compareTo(LongRat r) {
		return Long.compare(this.num*r.den, r.num*this.den);
	}
	
	/**
	 * Reports whether this = r
	 * a/b = c/d if and only if ad = bc
	 */
	public boolean equals (LongRat r) {
		return this.num == r.num && this.den == r.den;
	}
	
	/**
	 * Returns a string version of this in lowest terms.
	 * Examples:
	 *   3/4 => "3/4"
	 *   6/8 => "3/4"
	 *   2/1 => "2"
	 *   0/8 => "0"
	 *   3/-4 => "-3/4"
	 */
	public String toString () {
		if (den == 1) {
			return num + "";
		}
		else {
			return num + "/" + den;
		}
	}
	
	/**
	 * Returns the greatest common divisor of a and b,
	 * where a >= 0 and b > 0.
	 */
	private static long gcd (long a, long b) {
		while (b > 0) {
			long remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}

}
