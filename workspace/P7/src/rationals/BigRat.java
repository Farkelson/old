package rationals;

import java.math.BigInteger;

/**
 * Provides objects that represent rational numbers (fractions), as long
 * as their numerators and denominators can be represented with longs.
 */
public class BigRat {
	
	public static void main (String [] args){
		BigRat x = new BigRat();
		System.out.println(x);
		x = new BigRat(9);
		System.out.println(x);
		x = new BigRat("4", "12");
		System.out.println(x);
		x = new BigRat(88,11);
		System.out.println(x);
		x = new BigRat(1,2);
		BigRat y = new BigRat(4,5);
		System.out.println(x.compareTo(y));
		y = new BigRat(2,5);
		System.out.println(x.compareTo(y));
		y = new BigRat(4,8);
		System.out.println(x.compareTo(y));
		//x = new LongRat("four", "six");
		//System.out.println(x);
		
	}
	
	// (Abstraction function:)
	// Represents the rational number num/den where:
		
	// (Representation invariant:)
	// den > 0
	// gcd(|num|, den) = 1   (in lowest terms)
	private BigInteger num;
	private BigInteger den;
	
	/**
	 * Creates the rational number 0
	 */
	public BigRat () {
		this(0,1);
	}
	
	/**
	 * Creates the rational number n
	 */
	public BigRat (int n) {
		this(n,1);
	}
	
	/**
	 * If n and d can be parsed as integers n' and d':
	 *    Throws an IllegalArgumentException if d' = 0
	 *    Creates the rational number n'/d' otherwise.
	 * If n or d can't be parsed, throws a NumberFormatException.
	 */
	public BigRat(String n, String d) {
			this(Long.parseLong(n), Long.parseLong(d));
		}

	/**
	 * If d is zero, throws an IllegalArgumentException
	 * Creates the rational number n/d 
	 */
	public BigRat(long n, long d) {

		if (d == 0) {
			throw new IllegalArgumentException();
		}
		
		if (d < 0) {
			n = -n;
			d = -d;
		}
		
		long g = gcd(Math.abs(n), d);
		
		num = BigInteger.valueOf(n/g);
		den = BigInteger.valueOf(d/g);
	}


	/**
	 * Returns the sum of the two Rats this and r
	 * a/b + c/d = (ad + cb)/bd
	 */
	public BigRat add(BigRat r) {
		BigInteger ad = this.num.multiply(r.den);
		BigInteger cb = r.num.multiply(this.den);
		BigInteger bd = this.den.multiply(r.den);
		BigInteger top = ad.add(cb);
		return new BigRat(top.longValue(), bd.longValue());
		}
	
	/**
	 * Returns the difference of the two Rats this and r
	 * a/b - c/d = (ad - cb)/bd
	 */
	public BigRat sub(BigRat r) {
		BigInteger ad = this.num.multiply(r.den);
		BigInteger cb = r.num.multiply(this.den);
		BigInteger bd = this.den.multiply(r.den);
		BigInteger top = ad.subtract(cb);
		return new BigRat(top.longValue(), bd.longValue());
	}

	/**
	 * Returns the product of the two Rats this and r
	 * a/b * c/d = ac/bd
	 */
	public BigRat mul(BigRat r) {
		BigInteger ac = this.num.multiply(r.num);
		BigInteger bd = this.den.multiply(r.den);
		return new BigRat(ac.longValue(), bd.longValue());
	}
	
	/**
	 * If r is zero, throws an IllegalArgumentException.
	 * Otherwise, returns the quotient of the two Rats this and r.  
	 * a/b / c/d = ad/bc
	 */
	public BigRat div(BigRat r) {
		if (r.num.longValue() == 0){
			throw new IllegalArgumentException();
		}
		BigInteger ad = this.num.multiply(r.den);
		BigInteger bc = this.den.multiply(r.num);
		return new BigRat(ad.longValue(), bc.longValue());
	}

	/**
	 * Returns a negative number if this < r
	 * Returns zero if this = r
	 * Returns a positive number if this > r
	 * a/b < c/d if and ony if ad < cb
	 */
	public int compareTo(BigRat r) {
		BigInteger ad = this.num.multiply(r.den);
		BigInteger bc = this.den.multiply(r.num);
		return Long.compare(ad.longValue(),bc.longValue());
	}
	
	/**
	 * Reports whether this = r
	 * a/b = c/d if and only if ad = bc
	 */
	public boolean equals (BigRat r) {
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
		if (den.longValue() == 1) {
			return num + "";
		}
		else {
			return num + "/" + den;
		}
	}
	
	private static long gcd (long a, long b) {
		while (b > 0) {
			long remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}
}
