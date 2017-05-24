package cs1410;

/**
 * A DynamicArray behaves like an array of strings, except that it 
 * can grow and shrink.  It is indexed beginning with zero.  When a 
 * DynamicArray is created, it is empty.  Operations are provided to
 * add, get, change, and remove elements.
 */
public class DynamicArray2 {

	public static void main(String[] args) {
		
		// Add four elements to an initially empty DynamicArray.
		DynamicArray2 da1 = new DynamicArray2();
		da1.add("a");
		System.out.println("[a] = " + da1);
		da1.add("b");
		System.out.println("[a, b] = " + da1);
		da1.add("d");
		System.out.println("[a, b, d] = " + da1);
		da1.add(2,"c");
		System.out.println("[a, b, c, d] = " + da1);
		
		// Add 20 elements to an initially empty DynamicArray.
		DynamicArray2 da2 = new DynamicArray2();
		for (int i = 0; i < 20; i++) {
			da2.add(i + "");
		}
		System.out.println("[0, 2, ..., 19] = " + da2);
		
		// Get some elements
		for (int i = 0; i < 20; i+=4) {
			System.out.println(i + " = " + da2.get(i));
		}
		
		// Change some elements
		for (int i = 0; i < 20; i+=2) {
			da2.set(i,  (i+100)+"");
		}
		System.out.println("[100, 1, 102, 3, ..., 118, 19] = " + da2);
		
		// Remove some elements
		for (int i = 19; i >= 0; i-=2) {
			da2.remove(i);
		}
		System.out.println("[100, 102, ..., 118] = " + da2);
		
		// Determine the size
		System.out.println("10 = " + da2.size());
		
	}
	
	// Abstraction function:
	//   Represents the dynamic array
	//   [data[0], data[1], ..., data[count-1]]
	//   In other words, the first count elements of data
	//   are 
	//   elements of the dynamic array.  The remainder of
	//   data is room to grow.  When data fills up, we 
	//   allocate a new array that is twice as long.
	// Representation invariant:
	// 0 <= count <= data.length
	private String[] data;
	private int count;
	
	/**
	 * Creates an empty DynamicArray.
	 */
	public DynamicArray2 () {
		data = new String[8];
		count = 0;
	}
	
	/**
	 * Returns the number of elements.
	 */
	public int size () {
		return count;
	}
	
	/**
	 * Appends s to the end.
	 */
	public void add (String s) {
		add (count, s);
	}
	
	/**
	 * If i < 0 or i > size(), throws an IndexOutOfBoundsException.
	 * Otherwise, inserts s at index i, increasing the size by 1.
	 */
	public void add (int i, String s) {	
		if (i<0 || i > count){
			throw new IndexOutOfBoundsException();
		}
		
		String [] newData = null;
		if (count == data.length){
			newData = new String [data.length*2];
			for (int j = 0; j<i; j++){
				newData[j] = data[j];
				}
			newData[i] = s;
		
			for (int j = i; j <data.length; j++){
				newData[j+1] = data [j];
				}
		}
		else {
			newData = new String[data.length];
			
			for (int j = 0; j<i; j++){
				newData[j] = data[j];
				}
			
			newData[i] = s;
			
			for (int j = i; j <count; j++){
				newData[j+1] = data [j];
				}
			}
		count++;
		
		
		
		data = newData;
	}
	
	/**
	 * If i < 0 or i >= size(), throws an IndexOutOfBoundsException.
	 * Otherwise, removes the element at index i.
	 */
	public void remove (int i) {
		if (i<0 || i > count){
			throw new IndexOutOfBoundsException();
		}
		
		String [] newData = new String [count];
		
		for (int j = 0; j<i; j++){
			newData[j] = data[j];
		}
		
		for (int j = i+1; j <count; j++){
			newData[j-1] = data [j];
		}
		
		count--;
		data = newData;
	}
	
	/**
	 * If i < 0 or i >= size(), throws an IndexOutOfBoundsException.
	 * Otherwise, returns the element at index i.
	 */
	public String get (int i) {
		if (i<0 || i > count){
			throw new IndexOutOfBoundsException();
		}
		else {
			return data[i];
		}
		
	}
	
	/**
	 * If i < 0 or i >= size(), throws an IndexOutOfBoundsException.
	 * Otherwise, replaces the element at index i with s.
	 */
	public void set (int i, String s) {
		if (i<0 || i > count){
			throw new IndexOutOfBoundsException();
		}
		else {
			data[i] = s;
		}
	}
	
	/**
	 * Renders this dynamic array as a string.
	 */
	public String toString () {
		String result = "[";
		if (size() > 0) {
			result += get(0);
		}
		for (int i = 1; i < size(); i++) {
			result += ", " + get(i);
		}
		return result + "]";
	}


}
