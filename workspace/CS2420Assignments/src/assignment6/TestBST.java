//Scott Glass
//Jorden Phillips
package assignment6;

import java.util.ArrayList;
import junit.framework.TestCase;

public class TestBST extends TestCase{
	
	private BinarySearchTree<Integer> tree;

	protected void setUp() throws Exception {
		super.setUp();
		tree = new BinarySearchTree<Integer>();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	//test if things are added to the tree
	public void testAdd1(){
		tree.add(2);
		assertEquals(true, tree.contains(2));
	}
	//test if null can be added to the tree
	public void testAdd2(){
		tree.add(400);
		assertEquals(true, tree.contains(400));		

	}
	public void testAdd3(){
		tree.add(400);
		assertEquals(1, tree.size());		

	}
	//TODO
	public void testAddAll1(){
		
		
	}
	//TODO
	public void testAddAll2(){
		
	}
	//testing if the tree will clear properly
	public void testClear1(){
		tree.add(1);
		tree.add(2);
		tree.clear();
		assertEquals(true, tree.isEmpty());		
	}
	//TODO, after the previous tests i'm not sure if we really need to test this.
	public void testContains1(){
		
	}
	
	public void testContains2(){
		
	}
	//TODO
	public void testContainsAll(){
		
	}
	//testing if it finds the smallest item in the tree.
	public void testFirst1(){
		tree.add(1);
		tree.add(2);
		tree.add(3);
		assertEquals(1,tree.first().intValue());
	}
	
	public void testFirst2(){
		tree.add(60);
		tree.add(27);
		tree.add(50);
		System.out.println("Testing First");
		System.out.println("27 expected, " + tree.first() + " returned");
		System.out.println();
	}
	
	public void testIsEmpty1(){
		
	}
	
	public void testLast1(){
		tree.add(22);
		tree.add(109);
		tree.add(4000);
		System.out.println("Testing Last");
		System.out.println("4000 expected, " + tree.last() + " returned");
		System.out.println();		
	}
	
	public void testLast2(){
		tree.add(4);
		tree.add(3);
		tree.add(2);
		tree.add(1);
		System.out.println("Testing Last");
		System.out.println("4 expected, " + tree.last() + " returned");
		System.out.println();		
	}
	
	public void testRemove1(){
		tree.add(7);
		tree.remove(7);
		assertEquals(true, tree.isEmpty());		
	}
	
	public void testRemove2(){
		tree.add(69);
		tree.add(77);
		tree.remove(69);
		assertEquals(false, tree.contains(69));
		
	}
	//TODO
	public void testRemoveAll1(){
		
	}
	
	public void testSize1(){
		tree.add(7);
		assertEquals(1, tree.size());
		
	}
	
	public void testSize2(){
		
	}
	//TODO
	public void testToArrayList1(){
		
	}

}
