package assignment9;

import junit.framework.TestCase;

public class TestPriorityQueue extends TestCase{
	
	private PriorityQueueHEAP<Integer> heap;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		heap = new PriorityQueueHEAP<Integer>();		
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testHeapAdd(){
		boolean retVal = false;
		heap.add(1);
		if(heap.findMin() == 1){
			retVal = true;
		}
		assertTrue(retVal);
	}
	
	public void testHeapAdd2(){
		boolean retVal = false;
		heap.add(1);
		heap.add(3);
		heap.add(7);
		if(heap.findMin() == 1){
			retVal = true;
		}
		assertTrue(retVal);
	}
	
	public void testHeapAdd3(){
		boolean retVal = false;
		heap.add(7);
		heap.add(3);
		heap.add(1);
		if(heap.findMin() == 1){
			retVal = true;
		}
		assertTrue(retVal);
	}
	
	public void testSize(){
		heap.add(1);
		heap.add(3);
		assertEquals(2, heap.size());
	}
	
	public void testClear(){
		boolean retval = false;
		heap.add(9);
		heap.add(5);
		heap.add(2);
		heap.clear();
		assertEquals(0, heap.size());
	}
	
	public void testDeleteMin(){
		boolean retval = false;
		heap.add(9);
		heap.add(5);
		heap.add(2);
		heap.deleteMin();
		if(heap.findMin() == 5){
			retval = true;
		}
		assertTrue(retval);
	}
	
	public void testDeleteMin2(){
		for (int i = 1; i < 11; i++)
		{
			heap.add(i);
		}
		heap.generateDotFile("initialHeap.dot");
		for (int i = 1; i < 11; i++)
		{
			assertEquals(i, (int) heap.deleteMin());
			heap.generateDotFile("heap" + i + ".dot");
		}
	}
	
	public void testSize2(){
		for (int i = 1; i < 11; i++)
		{
			heap.add(i);
		}
		assertEquals(10, heap.size());
	}
	
	public void testPriorityQueueHeap(){
		assertEquals(0, heap.size());
	}
	
	public void testFindMin(){
		boolean retval = false;
		try{
			heap.findMin();
		}
		catch(Exception NoSuchElementException){
			retval = true;
		}
		assertTrue(retval);
	}
	
	public void testDeleteMin3(){
		boolean retval = false;
		try{
			heap.deleteMin();
		}
		catch(Exception NoSuchElementException){
			retval = true;
		}
		assertTrue(retval);
	}
	
	public void testArray(){
		PriorityQueueHEAP<Integer> heap = new PriorityQueueHEAP<Integer>();
		for(int i = 0; i< heap.size(); i++){
			System.out.printf("%d", heap.toArray()[i]);
		}
	}
	

}
