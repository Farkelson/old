package cs1410;

import java.util.*;

class Helper implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		if (a.length() > b.length()){
			return 1;
		}
		else if (a.length() < b.length()){
			return -1;
		}
		else {
			return 0;
		}
	}
}

public class CCDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> allStrings = new HashSet<String>();
		allStrings.add("aba");
		allStrings.add("level");
		allStrings.add("a");
		allStrings.add("abb");
		System.out.println(palindromes(allStrings));
		allStrings.clear();
		allStrings.add("xyz");
		allStrings.add("x");
		allStrings.add("y");
		allStrings.add("yz");
		System.out.println(substringCount(allStrings));
		allStrings.clear();
		allStrings.add("xyz");
		allStrings.add("ab");
		allStrings.add("a");
		allStrings.add("xy");
		System.out.println(sortByLength (allStrings));

	}
	
	public static boolean isItPalindrome(String s){
		int f = 0;
		int e = s.length()-1;
		while (f<=e){
			if (s.charAt(f)!=s.charAt(e)){
				return false;
			}
			f++;
			e--;
		}
		return true;
	}
	
	/**
     * Returns the set containing every string from allStrings that
     * is a palindrome.  For example, if allStrings is [aba, a, bc],
     * the method should return [aba, a].
     */
    public static Set<String> palindromes (Set<String> allStrings) {
    	Set<String> s = new HashSet<String>();
    	for (String t: allStrings){
    		if (isItPalindrome(t)){
    			s.add(t);
    		}
    	}
        return s;
    }  
    
    private static int numSubst (String test, List<String> newl){
    	int count = 0;
    	for(int i=0; i<newl.size();i++){
    		String fromList = newl.get(i);
    		if(!fromList.equals(test)){
    			if(fromList.contains(test)){
    			count++;
    			}
    		}
    		
    	}
    	return count;
    }
    
    /**
     * The return value maps each string s in allStrings to the number of
     * other strings from allStrings of which s is a substring.  For example,
     * if allStrings is [xyz, x, y, yz], the method should return
     * {x=1, y=2, yz=1}.
     */
    public static Map<String,Integer> substringCount (Set<String> allStrings) {
    	Map<String, Integer> m = new HashMap<String, Integer>();
    	List<String> l = new ArrayList<String>();
    	for (String w: allStrings){
    		l.add(w);
    	}
    	for (int i = 0; i<l.size(); i++){
    		String s = l.get(i);
    		m.put(s, numSubst(s, l));
    	}
    	for (int i = 0; i<l.size(); i++){
    		String s = l.get(i);
    		int maybe = m.get(s);
    		if (maybe ==0){
    			m.remove(s);
    		}
    	}
        return m;
    }
      
    /**
     * Returns a list containing the strings from allStrings, arranged in
     * order of increasing length.  The relative ordering of two equal-length
     * strings does not matter.  For example, if allStrings is [xyz, ab, a, xy],
     * the method should return [a, ab, xy, xyz] or [a, xy, ab, xyz].
     */
    public static List<String> sortByLength (Set<String> allStrings) {
    	Helper h = new Helper();
    	List<String> l = new ArrayList<String>();
    	for (String w: allStrings){
    		l.add(w);
    	}
    	Collections.sort(l, h);
    	
        return l;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
