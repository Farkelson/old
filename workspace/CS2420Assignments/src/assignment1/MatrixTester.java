/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
*/
package assignment1;

public class MatrixTester {
	public static void main(String[] args)
	{			
		Matrix M1 = new Matrix(new int[][]
		                                 {{1, 2, 3},
										  {2, 5, 6}});
		
		Matrix M2 = new Matrix(new int[][]
		                                 {{4, 5},
										  {3, 2},
										  {1, 1}});
		Matrix M3 = new Matrix(new int[][]
                						{{3, 5},
				  						 {3, 2},
				  						 {1, 1}});
		Matrix M4 = new Matrix(new int[][]
										{{4, 5},
				  						 {3, 2},
				  						 {1, 1},
				  						 {5, 5}});
		Matrix M5 = new Matrix(new int[][]
										{{4, 5, 1},
										 {3, 2, 0},
										 {1, 1, 9},
										 {5, 5, 4}});
		Matrix M6 = new Matrix(new int[][]
										{{4, 5, 1},
				 						 {3, 2, 0},
				 						 {1, 1, 9},
				 						 {5, 5, 4}});
		System.out.println(M1.equals(M1));//True
		System.out.println(M1.equals(M2));//False
		System.out.println(M2.equals(M3));//False
		System.out.println(M2.equals(M4));//False
		System.out.println(M5.equals(M4));//False
		System.out.println(M5.equals(M6));//True
		System.out.println(M1.times(M2));//13 12 
										 //29 26
		System.out.println(M1.times(M3));//12 12 
		 								 //27 26
		System.out.println(M2.times(M3));//Not Compatible
		System.out.println(M2.plus(M3));//7 10 
										//6 4 
										//2 2 
		System.out.println(M1.plus(M2));//Not Compatible
		System.out.println(M2.plus(M2));//8 10
										//6 4 
										//2 2 
		System.out.println(M5.plus(M6));//8 10 2 
										//6 4 0 
										//2 2 18 
										//10 10 8 
		String Test = M1.toString();    
		System.out.println(Test);		//1 2 3
										//2 5 6 
		
		// this is the known correct result of multiplying M1 by M2
		Matrix referenceMultiply = new Matrix(new int[][]
		                                                {{13, 12},
														 {29, 26}});
		
		
		/* 
		 * Note that none of the tests below will be correct until you have implemented all methods.
		 * This is just one example of a test, you must write more tests and cover all cases.
		 */
		
		// get the matrix computed by your times method
		Matrix computedMultiply = M1.times(M2);
		
		// exercises your toString method
		System.out.println("Computed result for M1 * M2:\n" + computedMultiply); 
		
		// exercises your .equals method, and makes sure that your computed result is the same as the known correct result
		if(!referenceMultiply.equals(computedMultiply)) 
			System.out.println("Should be:\n" + referenceMultiply);
	}
}

