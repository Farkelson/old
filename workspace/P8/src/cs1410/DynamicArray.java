package cs1410;

/**
 * A DynamicArray behaves like an array of strings, except that it 
 * can grow and shrink.  It is indexed beginning with zero.  When a 
 * DynamicArray is created, it is empty.  Operations are provided to
 * add, get, change, and remove elements.
 */
public class DynamicArray {

	public static void main(String[] args) {
		
		// Add four elements to an initially empty DynamicArray.
		DynamicArray da1 = new DynamicArray();
		da1.add("a");
		System.out.println("[a] = " + da1);
		da1.add("b");
		System.out.println("[a, b] = " + da1);
		da1.add("d");
		System.out.println("[a, b, d] = " + da1);
		da1.add(2,"c");
		System.out.println("[a, b, c, d] = " + da1);
		
		// Add 20 elements to an initially empty DynamicArray.
		DynamicArray da2 = new DynamicArray();
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
	
	// The elements in the DynamicArray.  The indexes into the
	// DynamicArray correspond exactly with indexes into data.
	// In other words, element i of the DynamicArray is stored
	// in data[i].
	private String[] data;
	
	/**
	 * Creates an empty DynamicArray.
	 */
	public DynamicArray () {
		data = new String[0];
	}
	
	/**
	 * Returns the number of elements.
	 */
	public int size () {
		return data.length;
	}
	
	/**
	 * Appends s to the end.
	 */
	public void add (String s) {
		add(data.length, s);
	}
	
	/**
	 * If i < 0 or i > size(), throws an IndexOutOfBoundsException.
	 * Otherwise, inserts s at index i, increasing the size by 1.
	 */
	public void add (int i, String s) {	
		
		// Make sure i is in bounds
		if (i < 0 || i > data.length) {
			throw new IndexOutOfBoundsException();
		}
		
		// Allocate a new array that is one bigger than the old one
		String[] newData = new String[data.length+1];
		
		// Copy data[j] to newData[j], for 0 <= j < i
		for (int j = 0; j < i; j++) {
			newData[j] = data[j];
		}
		
		// Add the element
		newData[i] = s;
		
		// Copy data[j] to newData[j+1], for i <= j < data.length
		for (int j = i; j < data.length; j++) {
			newData[j+1] = data[j];
		}
		
		// Save the new array in the object
		data = newData;
		
	}
	
	/**
	 * If i < 0 or i >= size(), throws an IndexOutOfBoundsException.
	 * Otherwise, removes the element at index i.
	 */
	public void remove (int i) {
		
		// Make sure i is in bounds
		if (i < 0 || i >= data.length) {
			throw new IndexOutOfBoundsException();
		}
		// Allocate a new array that is one smaller than the old one
		String[] newData = new String[data.length-1];
		
		// Copy data[j] to newData[j], for 0 <= j < i
		for (int j = 0; j < i; j++) {
			newData[j] = data[j];
		}
		
		// Copy data[j] to newData[j-], for i <= j < data.length
		for (int j = i; j < data.length; j++) {
			newData[j-1] = data[j];
		}
		
		// Save the new array in the object
		data = newData;
		
		
	}
	
	/**
	 * If i < 0 or i >= size(), throws an IndexOutOfBoundsException.
	 * Otherwise, returns the element at index i.
	 */
	public String get (int i) {
		if (i < 0 || i >= data.length) {
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
		if (i < 0 || i >= data.length) {
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
