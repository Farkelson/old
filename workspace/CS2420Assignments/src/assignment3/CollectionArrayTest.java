//Scott Glass
//Jordon Phillips
package assignment3;

import java.util.Collection;

import junit.framework.TestCase;

public class CollectionArrayTest extends TestCase{
	
	private CollectionArray<String> test;
	private CollectionArray<String> check;
	private Collection<String> collect;

	protected void setUp() throws Exception {
		super.setUp();
		test = new CollectionArray<String>();
		collect = new CollectionArray<String>();
		check = new CollectionArray<String>();
		test.add("Hello ");
		test.add("there ");
		test.add("World!");
		test.add("I'm ");
		test.add("testing ");
		test.add("to ");
		test.add("see ");
		test.add("if ");
		test.add("grow ");
		test.add("works ");
		test.add("correctly!");
		test.add("TUNA");
		collect.add("Computer ");
		collect.add("science ");
		collect.add("is ");
		collect.add("cool!");
		check.add("Hello ");
		check.add("science ");
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	//checking if size returns the number of items in the array
	public void testSize() {
		int i = test.size();
		assertEquals(12, i);
	}
	/*
	 * checking if removeAll can remove every item from the array and if size
	 * returns the number of items in the array
	 */
	public void testSize2(){
		test.removeAll(test);
		assertEquals(0, test.size());
	}
	/*
	 * checking if clear() effects size correctly
	 */
	public void testSize3() {
		test.clear();
		int i = test.size();
		assertEquals(0, i);
	}
	/*
	 * checking if clear will remove every item from an array and if
	 * isEmpty returns the proper value
	 */
	public void testClear(){
		test.clear();
		assertEquals(true, test.isEmpty());
		assertEquals(0, test.size());
	}
	
	//checking that isEmpty returns the proper value
	public void testIsEmpty(){
		assertEquals(false, test.isEmpty());
	}
	
	/*
	 * checking if contains() works correctly
	*/
	public void testContains(){
		assertEquals(true, test.contains("Hello "));
	}
	
	/*
	 * checking if remove() works
	 */	
	public void testRemove(){
		test.remove("Hello ");
		assertEquals(false, test.contains("Hello "));
		assertEquals(11, test.size());
	}
	
	public void testContainsAll(){
		assertEquals(false, test.containsAll(collect));
	}
	
	public void testAddAll(){
		test.addAll(collect);
		assertEquals(true, test.containsAll(collect));
	}
	public void testRemoveAll(){
		test.addAll(collect);
		test.removeAll(collect);
		assertEquals(false, test.containsAll(collect));
	}
	public void testRetainAll(){
		test.addAll(collect);
		test.retainAll(collect);
		assertEquals(true, test.containsAll(collect));
	}
	public void testRetainAll2(){
		test.addAll(collect);
		test.retainAll(collect);
		test.add("Hello ");
		assertEquals(true, test.containsAll(check));
	}
	
	public void testRetainAll3(){
		test.addAll(collect);
		test.retainAll(collect);
		assertEquals(false, test.containsAll(check));
	}
	
	public void testAdd(){
		test.addAll(collect);
		assertEquals(false, test.add("is "));
	}

}
