package assignment9;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Represents a priority queue of generically-typed items. 
 * The queue is implemented as a min heap. 
 * The min heap is implemented implicitly as an array.
 * 
 * @author Paymon Saebi & ??
 */
public class TaskInterface 
{
	public static void main(String[] args) 
	{ 			
		//check to make sure there is only one argument passed to main
		//note - The only argument allowed is a valid text file 
		//If there are more than one argument or none, print a message and return		
		File tasks = null;
		
		if (args.length > 1) // Ensure that there is no more than one argument
        {
        	System.out.println("\nInvalid number of arguments!\n");
        	return;
        }
        else if (args.length < 1) // Ensure that there is at least one argument
        {
        	System.out.println("\nInvalid number of arguments!\n");
            return;
        }
		
		//create a file object using the File class like before		
		tasks = new File(args[0]);
		//check to make sure the file is real (use .isFile())
		if(!tasks.isFile()){
			//If the file is invalid then print a message and return
			System.out.println("Unable to use the task file!");
			return;
		}		
		
//		TaskManager manager = null;
		
		//create a TaskManager object and pass it the file and your comparator
		TaskComparator C = new TaskComparator();
		TaskManager manager = new TaskManager(tasks, C);
		//call the populateTasks() method on the object so it is ready to use
		manager.populateTasks();
		
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
				
		System.out.println("System task manager is initialized ...\n");		
		System.out.println("Current task: " + manager.nextTask());
				
		while(true)
		{				
	        String input = scanner.nextLine();	 	        
	       	        
	        if(input.equals("task"))
	        {
	        	System.out.println("Current task: " + manager.getTask());
	        }
	        
	        else if(input.equals("next"))
	        {
	        	System.out.println("Current task: " + manager.nextTask());

	        }
	        
	        else if(input.equals("exit"))
	        {
	        	System.out.println("\nSystem task manager has exited ...");
	        	return;
	        }	
	        
	        if(manager.isDone())
	        {
	        	System.out.println("\nAll tasks are done, Have a nice day...");
	        	return;
	        }
		}
	}	
}