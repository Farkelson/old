package cs1410;

/**
 * A StringMap is a collection of key/value pairs, where keys and values are 
 * non-null Strings.  A StringMap may not contain two pairs that share
 * the same key.  Initially, a StringMap is empty.  There are operations
 * for pairing a key with a value, for looking up the value of a key, 
 * and for removing a pair.
 */
public class StringMap {
	
	
	public static void main (String args[]){
		StringMap sm1 = new StringMap();
		System.out.println("Empty = " + sm1);
		sm1.put("Kelly", "20");
		System.out.println("[Kelly => 20 ] = " + sm1);
		sm1.put("Sam", "40");
		System.out.println("[Kelly => 20 , Sam => 40 ] = " + sm1);
		sm1.put("Max", "12");
		System.out.println("[Kelly => 20 , Sam => 40 , Max => 12 ] = " +sm1);
		sm1.remove("Sam");
		System.out.println("[Kelly => 20 , Max => 12 ] = " + sm1);
		sm1.remove("Kelly");
		System.out.println("[Max => 12 ] = " + sm1);
		sm1.put("Kelly", "60");
		sm1.put("Sam", "80");
		sm1.put("Sam", "70");
		sm1.put("Max", "24");
		System.out.println("24 = " + sm1.get("Max"));
		System.out.println("70 = " + sm1.get("Sam"));
	}
    
	private StringSet Keys;			//Get a StringSet of keys
	private DynamicArray2 Values;	//Get a DynamicArray of values
    /**
     * Creates an empty StringMap object.
     */
    public StringMap () {
    	Keys = new StringSet();
    	Values = new DynamicArray2();
    }
    
    
    /**
     * If k or v is null, throws an IllegalArgumentException.
     * If there is already a pair in the StringMap whose key is 
     * equal to k (in the .equals sense), changes its associated value to v.
     * Otherwise, adds the pair k/v to the StringMap.
     */
    public void put (String k, String v) {
    	if ( k ==null || v==null){
    		throw new IllegalArgumentException();
    	}
    	if (Keys.contains(k)){
    		Values.set(Keys.containsAtNum(k), v);
    	}
    	else {
    		Keys.insert(k);
    		Values.add(v);
    	}
    }
    
    
    /**
     * If k is null, throws an IllegalArgumentException.
     * If there is a pair in the StringMap whose key is equal 
     * (in the .equals sense) to k, returns the associated value.
     * Otherwise returns null.
     */
    public String get (String k) {
    	if ( k == null){
    		throw new IllegalArgumentException();
    	}
    	if (Keys.contains(k)){
    		return Values.get(Keys.containsAtNum(k));
    	}
        return null;
    }
    
    
    /**
     * If k is null, throws an IllegalArgumentException.
     * If there is a pair in the StringMap whose key is equal
     * (in the .equals sense) to k, removes the pair from the
     * StringMap.  Otherwise, does nothing.
     */
    public void remove (String k) {
    	if ( k == null){
    		throw new IllegalArgumentException();
    	}
    	if (Keys.contains(k)){
    		Values.remove(Keys.containsAtNum(k));
    		Keys.remove(k);
    	}
    }
    
    
    /**
     * Returns the number of key/value pairs in the StringMap.
     */
    public int size () {
        return Keys.size();
    }
    
    
    /**
     * Renders the StringMap as a string.  For example, suppose that
     * the StringMap contains pairs "a"/"b" and "c"/"d".  This method
     * should return the string "[ a => b , c => d ]".  An empty
     * StringMap should render as the string "[ ]".
     */
    public String toString () {
    	String result = "[";
		if (size() > 0) {
			result += Keys.get(0);
			result += " => " + Values.get(0);
		}
		for (int i = 1; i < size(); i++) {
			result += " , " + Keys.get(i);
			result += " => " + Values.get(i);
		}
		
		return result + " ]";
	}

}