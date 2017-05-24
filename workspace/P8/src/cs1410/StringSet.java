package cs1410;

/**
 * A StringSet is a collection of non-null strings, no two
 * of which map be equal.  Initially, a StringSet is empty.
 * There are operations to insert a new element, remove an
 * existing element, and check whether an element is in the
 * StringSet.
 */
public class StringSet {
	
	//Make StringSet a DynamicArray.
	private DynamicArray2 data;	
	
	public static void main (String args[]){
		StringSet sa1 = new StringSet();
		System.out.println("Empty = " + sa1);
		sa1.insert("a");
		System.out.println("{a} = " + sa1);
		sa1.insert("b");
		System.out.println("{a, b} = " + sa1);
		sa1.insert("d");
		System.out.println("{a, b, d} = " + sa1);
		System.out.println("true = " + sa1.contains("b"));
		sa1.remove("b");
		System.out.println("{a, d} = " + sa1);
		System.out.println("2 = " + sa1.size());
		//sa1.insert(null);
	}
      
    /**
     * Creates an empty StringSet object.
     */
    public StringSet () {
    	data = new DynamicArray2();
    }
    
    
    /**
     * If e is null, throws an IllegalArgumentException.
     * Else, if there is already an element in the StringSet that
     * is equal (in the .equals sense) to e, does nothing.
     * Otherwise, adds e to the StringSet. 
     */
    public void insert (String e) {
    	if (e == null){
    		throw new IllegalArgumentException();
    	}
    	
    	if (!this.contains(e)){
    		data.add(e);
    	}
    }
    
    
    /**
     * If e is null, throws an IllegalArgumentException.
     * Otherwise, reports whether the StringSet contains e.
     */
    public boolean contains (String e) {
    	if (e == null){
    		throw new IllegalArgumentException();
    	}
    	for (int j = 0; j<data.size(); j++){
    		if (e.equals(data.get(j))){
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * If e is null, throws an IllegalArgumentException.
     * Otherwise, reports where the StringSet contains e.
     */
    public int containsAtNum (String e) {
    	if (e == null){
    		throw new IllegalArgumentException();
    	}
    	for (int j = 0; j<data.size(); j++){
    		if (e.equals(data.get(j))){
    			return j;
    		}
    	}
    	throw new IllegalArgumentException();
    }
    
    
    /**
     * If e is null, throws an IllegalArgumentException.
     * Else, if the StringSet contains e, removes it.
     * Otherwise, does nothing.
     */
    public void remove (String e) {
    	if (e == null){
    		throw new IllegalArgumentException();
    	}
    	if (this.contains(e)){
    		data.remove(containsAtNum(e));
    	}
    }
    
    
    /**
     * Returns the number of key/value pairs in the StringSet.
     */
    public int size () {
        return data.size();
    }
    
    /**
	 * If i < 0 or i >= size(), throws an IndexOutOfBoundsException.
	 * Otherwise, returns the element at index i.
	 */
	public String get (int i) {
		if (i<0 || i > size()){
			throw new IndexOutOfBoundsException();
		}
		else {
			return data.get(i);
		}
		
	}
    
    
    /**
     * Renders the StringSet as a string.  For example, suppose that
     * the StringSet contains "a" and "b".  This method
     * should return the string "{a, b}".  An empty
     * StringSet should render as the string "{}".
     */
    public String toString () {
    	String result = "{";
		if (size() > 0) {
			result += data.get(0);
		}
		for (int i = 1; i < size(); i++) {
			result += ", " + data.get(i);
		}
		return result + "}";
	}

}