package assignment8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Driver class for the spell check utility.
 * 
 * @author Paymon Saebi
 */
public class SpellChecker 
{	
	public static void main(String[] args) 
	{	
		File dictionary = null;
		File document = null;
		String option = "";
		
		if (args.length > 3) // Ensure that there are no more than two arguments
        {
        	System.out.println("\nInvalid number of arguments!\n");
        	return;
        }
        else if (args.length < 2) // Ensure that there is at least one argument
        {
        	System.out.println("\nInvalid number of arguments!\n");
            return;
        }
		
		//TODO: Instantiate the dictionary File object using args[0]		
		dictionary = new File(args[0]);
		if(!dictionary.isFile()){
			System.out.println("Unable to use the dictionary file!");
			return;
		}
		//TODO: Check to see if this dictionary file is a normal file
		//Use the File class isFile() method
		
		//TODO: Instantiate the document File object using args[1]		
		document = new File(args[1]);
		if(!document.isFile()){
			System.out.println("Unable to use the document file!");
			return;
		}
		//TODO: Check to see if this document file is a normal file
		//Use the File class isFile() method		
		
		// If a third parameter was passed for the options, check its validity 
		if (args.length == 3) 
   			if(args[2].equalsIgnoreCase("-p") || args[2].equalsIgnoreCase("-f"))
   				option = args[2];
   			else 
   			{
   				System.out.println("Invalid printing or filing option argument!");
   				return;
   			}
		
		// Passing the dictionary file, document file, and the option
		run_spell_check(dictionary, document, option);		
	}

	private static void run_spell_check(File dic, File doc, String option)  
	{
		// Creating a new SpellCheckerUtil object with the dictionary file
		SpellCheckUtil mySC = new SpellCheckUtil(dic);
		
		// Creating a list of misspelled words after checking spellcheking the document
		List<String> misspelledWords = mySC.spellCheck(doc);
	   
		if (misspelledWords.size() == 0) 
			System.out.println("\nThere are no misspelled words in file " + doc + ".\n");
		else 
		{
			System.out.println("\nThere are " + misspelledWords.size() + " misspelled words in file " + doc + ".");
	      
			if(option.equals("-p"))
			{
				for(String g : misspelledWords){
					System.out.println(g);
				}
				//TODO: Print every misspelled word on a new line
				
			}
			else if(option.equals("-f"))				
				try
				{
					FileWriter writer = new FileWriter("misspelled.txt");
					
					BufferedWriter bw = new BufferedWriter (writer);
					for(String s : misspelledWords){
						bw.write(s);
					}
					bw.close();
					//TODO: Put every misspelled word on a new line in the misspelled.txt file 
					
					//TODO: Make sure to close the "writer" file you just populated.
					
					System.out.println("Please see misspelled.txt for a list of the words.");	
				} 
				catch (IOException e) 
				{
					System.out.println("Unable to create a file for the misspelled words!");
					return;
				}
		
			System.out.println("\nHave a nice day!\n");		
		}		
	}
}