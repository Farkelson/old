
public class Learner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// comments
		int x = 1/5;
		double foo = 1/5.0;
		System.out.println(foo + " " + x + " more text.");
		int y = calculateTwice(22);
		System.out.println(y);

	}
	
	/**
	 * This doubles the value!
	 * @param placeHolder Some sort of description here
	 * @return And here
	 */
	public static int calculateTwice(int placeHolder){
		placeHolder = placeHolder * 2;
		System.out.println("Hello from other method!");
		return placeHolder;
		
	}

}
