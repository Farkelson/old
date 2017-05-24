package rationals;

/**
 * Provides objects that represent rational numbers (fractions), as long
 * as their numerators and denominators can be represented with ints.
 */
public class IntRat {
	
	public static void main (String [] args){
		IntRat x = new IntRat();
		System.out.println(x);
		x = new IntRat(5);
		System.out.println(x);
		x = new IntRat("5", "6");
		System.out.println(x);
		x = new IntRat(14,28);
		System.out.println(x);
		x = new IntRat(1,2);
		IntRat y = new IntRat(4,5);
		System.out.println(x.compareTo(y));
		y = new IntRat(2,5);
		System.out.println(x.compareTo(y));
		y = new IntRat(4,8);
		System.out.println(x.compareTo(y));
		//x = new IntRat("five", "six");
		//System.out.println(x);
	}
	
	// (Abstraction function:)
	// Represents the rational number num/den where:
	
	// (Representation invariant:)
	// den > 0
	// gcd(|num|, den) = 1   (in lowest terms)
	private int num;
	private int den;
	
	/**
	 * Creates the rational number 0
	 */
	public IntRat () {
		// The following line of code uses the IntRat(long,long) constructor
		// to initialize the object.
		this(0,1);
	}
	
	/**
	 * Creates the rational number n
	 */
	public IntRat (int n) {
		// The following line of code uses the IntRat(long,long) constructor
		// to initialize the object.
		this(n,1);
	}
	
	/**
	 * If n and d can be parsed as the longs n' and d':
	 *    Throws an IllegalArgumentException if d' = 0
	 *    Creates the rational number n'/d' otherwise.
	 * If n or d can't be parsed, throws a NumberFormatException.
	 */
	public IntRat(String n, String d) {
		// Note:  The following line of code uses the IntRat(long,long) constructor
		// to initialize the object.
		this(Integer.parseInt(n), Integer.parseInt(d));
	}

	/**
	 * If d is zero, throws an IllegalArgumentException
	 * Creates a Rat that represents the fraction n/d 
	 */
	public IntRat(int n, int d) {
		
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
		int g = gcd(Math.abs(n), d);
		
		// Save the num and den
		num = n/g;
		den = d/g;
	}
	


	/**
	 * Returns the sum of the two Rats this and r
	 * a/b + c/d = (ad + cb)/bd
	 */
	public IntRat add(IntRat r) {
		return new IntRat(this.num*r.den + r.num*this.den,
				       this.den*r.den);
	}
	
	/**
	 * Returns the difference of the two Rats this and r
	 * a/b - c/d = (ad - cb)/bd
	 */
	public IntRat sub(IntRat r) {
		return new IntRat(this.num*r.den - r.num*this.den, 
						this.den*r.den);
	}

	/**
	 * Returns the product of the two Rats this and r
	 * a/b * c/d = ac/bd
	 */
	public IntRat mul(IntRat r) {
		return new IntRat(this.num*r.num, this.den*r.den);
	}
	
	/**
	 * If r is zero, throws an IllegalArgumentException.
	 * Otherwise, returns the quotient of the two Rats this and r.  
	 * a/b / c/d = ad/bc
	 */
	public IntRat div(IntRat r) {
		if (r.num == 0){
			throw new IllegalArgumentException();
		}
		return new IntRat(this.num*r.den, this.den*r.num);
	}

	/**
	 * Returns a negative number if this < r
	 * Returns zero if this = r
	 * Returns a positive number if this > r
	 * a/b < c/d if and ony if ad < cb
	 */
	public int compareTo(IntRat r) {
		return Long.compare(this.num*r.den, r.num*this.den);
	}
	
	/**
	 * Reports whether this = r
	 * a/b = c/d if and only if ad = bc
	 */
	public boolean equals (IntRat r) {
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
	private static int gcd (int a, int b) {
		while (b > 0) {
			int remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}

}
