/*Jordan Phillips
 *Scott Glass 
 */
package assignment2;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<T> extends Book{
	
	//initialize member variables for LibraryBook
	private T holder;
	private int dueDateM;
	private int dueDateD;
	private int dueDateY;
	
	//create a constructor for LibraryBook
	public LibraryBookGeneric(long isbn, String author, String title){
		super(isbn, author, title);	
		dueDateM = 0;
		dueDateD = 0;
		dueDateY = 0;
	}
	
	//method to return holder
	public T getHolder(){
		return holder;		
	}
	
	//method to return dueDate
	public GregorianCalendar getDueDate(){
		return new GregorianCalendar(dueDateY, dueDateM, dueDateD);
	}
	
	//method that checks in books, holder and dueDate are set to null
	public void checkin(){
		holder = null;
		dueDateM = 0;
		dueDateY = 0;
		dueDateD = 0;
	}
	
	//method that checks out books, assigns a value for holder and dueDate
	public void checkout(T owner, int month, int day, int year){
		holder = owner;
		dueDateD = day;
		dueDateM = month;
		dueDateY = year;
	}

}