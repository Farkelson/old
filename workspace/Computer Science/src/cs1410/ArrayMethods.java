package cs1410;

public class ArrayMethods {

	/**
	 * Scott Glass struggling with an array builder
	 * @param args
	 */
	public static void main(String[] args) {
		int [] a = {1, 3, 1 ,5 ,2};
		System.out.println(contains(a, 5, 5));
		System.out.println(copy(a, 5));
	}
	public static boolean contains (int [] a, int v , int n){
		for (int j = 0; j<n; j++){
			if (a [j] == v){
				return true;
			}
		}		
		return false;
	}
	/**
	 * copy is supposed to return a new array of length n that contains 
	 * the first n elements of a, in the same order that they appear in a
	 * @param a
	 * @param n
	 * @return
	 */
	public static int [] copy(int[] a, int n){
		String b = a.toString();
		int [] c = {Integer.parseInt(b)};
		return c;
		
	}

}
