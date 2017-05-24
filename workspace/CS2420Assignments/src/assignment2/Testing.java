/*Jordan Phillips
 *Scott Glass 
 */
package assignment2;

import junit.framework.TestCase;

public class Testing extends TestCase {
	
	private LibraryGeneric lib;
	private long isbn;
	private String author;
	private String title;
	private LibraryBookGeneric book;

	protected void setUp() throws Exception {
		super.setUp();
		lib = new LibraryGeneric();
		lib.addAll("Mushroom_Publishing.txt");
		isbn = 9781843190004L;
		author = "Moyra Caldecott";
		title = "Weapons of the Wolfhound";
		book = new LibraryBookGeneric(isbn, author, title);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		
	}
	
	public void testGetIsbn1() 
	{
	  assertEquals(isbn, book.getIsbn());
	}
	public void testGetIsbn2() 
	{
	  assertEquals(null, lib.lookup(isbn));
	}
	public void testLbraryCheckin1() 
	{
	  assertEquals(false, lib.checkin(0));
	}
	public void testLbraryCheckin2() 
	{
	  assertEquals(false, lib.checkin(isbn));
	}
	public void testLbraryCheckin3() 
	{
		lib.checkout(isbn, "steve", 1, 1, 2013);
	  assertEquals(true, lib.checkin(isbn));
	}
	public void testLbraryCheckOut1() 
	{
	  assertEquals(true, lib.checkout(isbn, "steve", 1, 1, 2013));
	}
	public void testLbraryCheckOut2() 
	{
		lib.checkout(isbn, "steve", 1, 1, 2013);
	  assertEquals(false, lib.checkout(isbn, "bob", 1, 1, 2013));
	}
	public void testLbraryCheckInOut1() 
	{
		lib.checkout(isbn, "steve", 1, 1, 2013);
		lib.checkin("steve");
	  assertEquals(true, lib.checkout(isbn, "bob", 1, 1, 2013));
	}
	public void testLbraryCheckInOut2() 
	{
		lib.checkout(isbn, "steve", 1, 1, 2013);
		lib.checkin(isbn);
	  assertEquals(true, lib.checkout(isbn, "bob", 1, 1, 2013));
	}
	public void testgetOverdueList1() 
	{
		lib.checkout(isbn, "steve", 1, 1, 2013);
	  assertEquals(1, lib.getOverdueList(1,  1,  1000).size());
	}
	
	
	

}
