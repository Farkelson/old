package cs1410;

import java.util.*;
import java.io.*;

/**
 * A CacheList is a collection of Cache objects together with six other pieces
 * of information: 
 * 
 *   (1) A title constraint
 *   (2) An owner constraint
 *   (3) A minimum difficulty
 *   (4) A maximum difficulty
 *   (5) A minimum terrain 
 *   (6) A maximum terrain
 */
public class CacheList {
	
	/**
	 * For testing the CacheList class
	 * @throws IOException 
	 */
	public static void main (String[] args) throws IOException {
		CacheList demo  = new CacheList ("caches.txt");
		System.out.println(demo.select().toString());
		// TODO:  Put testing code for the CacheList class here
	}
	

	// The caches being managed by this CacheList.  They are arranged in alphabetical
	// order according to cache title.
	private Cache[] allCaches;
	private int Count;			//The length of the allCaches array
	private String title;		//Title constraint of the CacheList
	private String owner;		//Name of the owner constraint of the CacheList
	private double maxDifficulty;  //The max difficulty rating constraint of the CacheList as a number
	private double minDifficulty;  //The min difficulty rating constraint of the CacheList as a number
	private double maxTerrain;		//The max terrain rating constraint of the CacheList as a number
	private double minTerrain;		//The min terrain rating constraint of the CacheList as a number
	// TODO: Put remainder of representation (private member variables) here

	/**
	 * Creates a CacheList from the specified file.  Each line of the file should contain
	 * the description of a cache in a format suitable for consumption by the Cache
	 * constructor.  The resulting CacheList should contain one Cache object corresponding to each
	 * line of the file.  Sets the initial value of the title and owner constraints to the
	 * empty string, sets the minimum difficulty and terrain to 1.0, and sets the maximum
	 * difficulty and terrain to 5.0.
	 * 
	 * Throws an IOException if there are any problems reading the file.
	 */
	public CacheList(String file) throws IOException {
		
		// Obtain the number of lines in the file
		Scanner s = new Scanner(new File(file));
		int size = getLineCount(s);
		s.close();

		// Obtain an array of all the caches in the file
		s = new Scanner(new File(file));
		allCaches = readAllCaches(s, size);
		s.close();
		
		// Sorts the array of caches
		Arrays.sort(allCaches, new CacheComparator());
		
		// Initialize the six extra pieces of information
		initialize();
		
	}
	
	/**
	 * Returns the number of lines in the Scanner.
	 */
	private int getLineCount(Scanner s) {
		Count = 0;
		while(s.hasNextLine()){
			s.nextLine();
			Count++;
		}
		// TODO: Replace implementation.  This is a helper for the constructor.
		return Count;
	}

	/**
	 * Returns an array containing size Cache objects, each Cache
	 * corresponding to each line of the Scanner.  Each line of the
	 * Scanner must be in the format expected by the Cache constructor.
	 */
	private Cache[] readAllCaches(Scanner s, int size) {
		// TODO: Replace implementation.  This is a helper for the constructor.
		Cache[] caches = new Cache[size];
		for (int i = 0; i <size; i++){
			caches [i] = new Cache (s.nextLine());
		}
		return caches;
	}
	
	/**
	 * Initializes the title constraint, owner constraint, minimum/maximum difficulties,
	 * and minimum/maximum terrains to their default values.
	 */
	private void initialize () {
		this.title = "";
		this.owner = "";
		this.minDifficulty = 1;
		this.maxDifficulty = 5;
		this.minTerrain = 1;
		this.maxTerrain = 5;
		// TODO: Implement.  This is a helper for the constructor.
	}
	
	/**
	 * Sets the title substring to the specified value.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the owner to the specified value.
	 */
	public void setOwner(String owner) {
		this.owner = owner;
		// TODO: Implement
	}

	/**
	 * Sets the minimum and maximum difficulties to the
	 * specified values.
	 */
	public void setDifficulty(double min, double max) {
		this.minDifficulty = min;
		this.maxDifficulty = max;
		// TODO: Implement
	}

	/**
	 * Sets the minimum and maximum difficulties to the
	 * specified values.
	 */
	public void setTerrain(double min, double max) {
		this.minTerrain = min;
		this.maxTerrain = max;
		// TODO: Implement
	}
	
	/**
	 * Returns an array that contains each cache c from the CacheList so long as
	 * c's title contains the title constraint, c's owner equals the owner constraint
	 * (unless the owner constraint is empty), c's difficulty rating is between the minimum
	 * and maximum difficulties (inclusive), and c's terrain rating is between the minimum
	 * and maximum terrains (inclusive).
	 * 
	 * The returned array is sorted in alphabetical order by cache name.
	 */
	public Cache[] select () {
		Cache [] fresh = new Cache [Count];
		int t = 0;
		for (int i = 1; i<Count; i++){
			Cache c = allCaches[0];
			
			if (c.getTitle().contains(this.title)){
			
				if (c.getDifficulty() >= this.minDifficulty && 
						c.getDifficulty() <= this.maxDifficulty){
		
					if (c.getTerrain() >= this.minTerrain && 
							c.getTerrain() <= this.maxTerrain){
						if (!c.getOwner().equals(this.owner)){
							if (c.getOwner().equals(null)){
								fresh [t] = c;
								t++;
							}
						}
						else{
							fresh [t] = c;
							t++;
						}
					}
				}
			}
			
		}
		// TODO: Replace implementation
		if (t==0){
			return allCaches;
		}
		return fresh;
	}
	
	public static boolean contains (String[] A, String v, int n) {
		for (int i = 0; i < n; i++) {
			if (A[i] == v) {
				return true;
			}
		}
		return false;
	}
	
	public String[] intersect (String[] A, String[] B) {
		String[] result = new String[Math.min(A.length, B.length)];
		int n = 0;
		for (int i = 0; i < A.length; i++) {
			if (contains(B, A[i], B.length) && 
					!contains(result, A[i], n)) {
				result[n] = A[i];
				n++;
			}
		}
		return copy(result, n);
	}
	
	public static String[] copy (String[] A, int n) {
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			result[i] = A[i];
		}
		return result;
	}
		
	public String[] ownersArray(){
		String [] array = new String [Count];
		for (int i = 0; i<Count; i++){
			array[i] = allCaches[i].getOwner();
		}
		return array;
	}
	/**
	 * Returns an array containing all the owners of all of the Cache objects in this
	 * CacheList.  There are no duplicates.  The array is sorted into alphabetical order.
	 */
	public String[] getOwners() {
		// TODO: Replace implementation
		String[] owners = new String[Count];
			owners = intersect (owners, ownersArray());
		Arrays.sort(owners, new StringComparator());
		return owners;
	}
	
	/**
	 * Useful for sorting arrays of strings.
	 */
	private class StringComparator implements Comparator<String> {
		public int compare (String s1, String s2) {
			return s1.compareToIgnoreCase(s2);
		}		
	}
	
	/**
	 * Useful for sorting arrays of caches.
	 */
	private class CacheComparator implements Comparator<Cache> {
		public int compare (Cache c1, Cache c2) {
			return c1.getTitle().compareToIgnoreCase(c2.getTitle());
		}
	}

}
