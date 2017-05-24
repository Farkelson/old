//Scott Glass
//Jordon Phillips
package assignment5;

//ATTENSION!!!! Because of the way JUnit testing works the console may display different results each time it is run
//In the order we set up it should print out    
//												3 2 1
//											    4 5 6
//

import junit.framework.TestCase;

public class TestLinkedStructures extends TestCase {

	private MyLinkedList<Integer> list;
	private MyStack<Integer> listMS;
	protected void setUp() throws Exception {
		super.setUp();
		list = new MyLinkedList<Integer>();		
		listMS = new MyStack<Integer>();
	}
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testisEmpty(){
		assertEquals(true, list.isEmpty());
	}
	public void testsize(){
		list.addFirst(3);
		list.addFirst(3);
		list.addFirst(3);
		list.addFirst(3);
		list.addFirst(3);
		assertEquals(5, list.size());
	}
	public void testaddFirst1(){
		list.addFirst(2);
		assertEquals(false, list.isEmpty());
	}
	public void testaddFirst2(){
		list.addFirst(2);
		assertEquals(true, list.getFirst()==2);
	}
	public void testaddFirst3(){
		list.addFirst(2);
		list.addFirst(3);
		assertEquals(false, list.getFirst()==2);
	}
	public void testaddFirst4(){
		list.addFirst(2);
		list.addFirst(3);
		assertEquals(true, list.getFirst()==3);
	}
	public void testaddLast1(){
		list.addLast(2);
		list.addLast(3);
		assertEquals(true, list.getLast()==3);
	}
	public void testaddLast2(){
		list.addLast(2);
		list.addLast(3);
		assertEquals(false, list.getLast()==2);
	}
	public void testadd(){
		list.add(0,2);
		assertEquals(true, list.get(0)==2);
	}
	public void testgetFirst1(){
		list.addFirst(2);
		list.addLast(3);
		assertEquals(true, list.getFirst()==2);
	}
	public void testgetFirst2(){
		list.addFirst(2);
		list.addLast(3);
		assertEquals(false, list.getFirst()==3);
	}
	public void testgetLast2(){
		list.addFirst(2);
		list.addLast(3);
		assertEquals(false, list.getLast()==2);
	}
	public void testgetLast3(){
		list.addFirst(3);
		list.addLast(2);
		list.removeLast();
		assertEquals(true, list.getLast()==3);
	}
	public void testgetLast1(){
		list.addFirst(3);
		list.addLast(2);
		assertEquals(true, list.getLast()==2);
	}
	public void testremoveFirst1(){
		list.addFirst(3);
		list.addLast(2);
		list.removeFirst();
		assertEquals(true, list.getFirst()==2);
	}
	public void testremoveFirst2(){
		list.addFirst(3);
		list.addLast(2);
		list.removeFirst();
		assertEquals(false, list.getFirst()==3);
	}
	public void testremoveLast1(){
		list.addFirst(3);
		list.addLast(2);
		assertEquals(true, list.removeLast()==2);
	}
	public void testremoveLast2(){
		list.addFirst(3);
		list.addLast(2);
		assertEquals(false, list.removeLast()==3);
	}
	public void testtoArray(){
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		Object [] tester = list.toArray();
		//Expecting 3 2 1
		System.out.printf("%s " + "%s " + "%s ", tester[0], tester[1], tester[2]);
		System.out.println("");
	}
	public void testclear(){
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.clear();
		assertEquals(true, list.size()==0);
	}
	public void testlastIndexOf(){
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		assertEquals(2, list.lastIndexOf(1));
	}
	public void testindexOf(){
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		assertEquals(0, list.indexOf(3));
	}
	
	
	public void testisEmptyMS(){
		assertEquals(true, listMS.isEmpty());
	}
	public void testsizeMS(){
		listMS.push(1);
		listMS.push(2);
		listMS.push(3);
		listMS.push(4);
		listMS.push(5);
		assertEquals(5, (int)listMS.size());
	}
	public void testpush1MS(){
		listMS.push(2);
		assertEquals(false, listMS.isEmpty());
	}
	public void testpush2MS(){
		listMS.push(2);
		assertEquals(true, listMS.peek()==2);
	}
	public void testpush3MS(){
		listMS.push(2);
		listMS.push(3);
		assertEquals(false, listMS.peek()==2);
	}
	public void testpeek1MS(){
		listMS.push(2);
		listMS.push(3);
		assertEquals(true, listMS.peek()==3);
	}
	public void testpeek2MS(){
		listMS.push(2);
		listMS.peek();
		assertEquals(false, listMS.isEmpty());
	}
	public void testpop1MS(){
		listMS.push(2);
		listMS.push(3);
		assertEquals(true, listMS.pop()==3);
	}
	public void testpop2MS(){
		listMS.push(2);
		listMS.pop();
		assertEquals(true, listMS.isEmpty());
	}
	public void testpop3MS(){
		listMS.push(2);
		listMS.push(3);
		listMS.pop();
		assertEquals(true, listMS.pop()==2);
	}
	public void testtoArrayMS(){
		listMS.push(4);
		listMS.push(5);
		listMS.push(6);
		Object [] tester = listMS.toArray();
		//Expecting 4 5 6
		System.out.printf("%s " + "%s " + "%s ", tester[0], tester[1], tester[2]);
	}
	public void testclearMS(){
		listMS.push(1);
		listMS.push(2);
		listMS.push(3);
		listMS.clear();
		assertEquals(true, listMS.size()==0);
	}	
}