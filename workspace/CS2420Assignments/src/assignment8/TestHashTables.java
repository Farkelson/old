package assignment8;

import junit.framework.TestCase;

public class TestHashTables extends TestCase{
	
	private QuadProbeHashTable table;
	private ChainingHashTable otherTable;
	
	protected void setUp() throws Exception {
		super.setUp();
		GoodHashFunctor G = new GoodHashFunctor();
		table = new QuadProbeHashTable(3, G);
		otherTable = new ChainingHashTable(3, G);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testQPHAdd(){
		assertEquals(true, table.add("stuff"));
	}
	
	public void testQPHAdd2(){
		assertEquals(true, table.add("this"));
		assertEquals(true, table.add("stuff"));
		assertEquals(true, table.add("works"));		
	}
	public void testQPHContains(){
		assertEquals(true, table.add("this"));
		assertEquals(true, table.add("stuff"));
		assertEquals(true, table.add("works"));	
		assertEquals(true, table.contains("this"));
		assertEquals(true, table.contains("stuff"));
		assertEquals(true, table.contains("works"));	
	}
	public void testQPHClear(){
		table.add("this");
		table.add("stuff");
		table.add("works");
		table.clear();
		assertEquals(false, table.contains("this"));
		assertEquals(false, table.contains("stuff"));
		assertEquals(false, table.contains("works"));		
	}
	
	public void testCHTAdd(){
		assertEquals(true, otherTable.add("this"));
	}
	public void testCHTAdd2(){
		assertEquals(true, otherTable.add("this"));
		assertEquals(true, otherTable.add("is"));
		assertEquals(true, otherTable.add("how"));
		assertEquals(true, otherTable.add("I"));
		assertEquals(true, otherTable.add("test"));
	}
	public void testCHTContains(){
		assertEquals(true, otherTable.add("this"));
		assertEquals(true, otherTable.contains("this"));
	}
	public void testCHTContains2(){
		assertEquals(true, otherTable.add("this"));
		assertEquals(true, otherTable.add("is"));
		assertEquals(true, otherTable.add("how"));
		assertEquals(true, otherTable.add("I"));
		assertEquals(true, otherTable.add("test"));
		assertEquals(true, otherTable.contains("I"));
		assertEquals(true, otherTable.contains("is"));
	}
	public void testCHTClear(){
		assertEquals(true, otherTable.add("this"));
		assertEquals(true, otherTable.add("is"));
		assertEquals(true, otherTable.add("how"));
		assertEquals(true, otherTable.add("I"));
		assertEquals(true, otherTable.add("test"));
		assertEquals(true, otherTable.contains("I"));
		otherTable.clear();
		assertEquals(false, otherTable.contains("is"));
	}
}
