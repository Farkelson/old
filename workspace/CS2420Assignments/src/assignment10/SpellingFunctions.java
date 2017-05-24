package assignment10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SpellingFunctions {

	//initialization of all needed private member variables
	public static HashMap<String, Integer> dictionary;
	public static StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
	private static int total;
	public static ArrayList<StringBuilder> toPrint = new ArrayList<StringBuilder>();
	private static ArrayList<StringBuilder> lastList = new ArrayList<StringBuilder>();
	public static boolean fr_isActive;
	private static FileWriter file;

	/*
	 * method to run deletion of each character in a string to search
	 * for valid words in that string
	 */
	public static ArrayList<StringBuilder> Deletion(String word){
		try {
			file = new FileWriter(word + ".txt");
			// for formating of required txt file, as per customer request
			file.write("User string: " + word+"\n"+"\n");
			// to calculate how many times to loop, deleting characters
			int i = 0;
			// keeps track of how many alternatives are generated
			int count = 0;
			// for formating of required txt file, as per customer request
			// continue looping while we haven't reached the end of the word
			while (i < word.length()) {
				// creates a new string builder of the word we are spellchecking
				StringBuilder arr = new StringBuilder(word);
				// deletes the i'th character in the string
				arr = arr.delete(i, i + 1);
				/*
				 * if -fr mode is active this will be used to generate a txt
				 * file of all alternatives as well as return valid words
				 * statement if not this will only return valid words
				 */
				file.write("Deletion string: " + arr.toString());
				file.write("\n");
				count++;
				total++;
				i++;
			}

			file.write("Created " + count + " deletion alternatives\n\n");
		} catch (Exception e) {
			System.out.println("There was an excpetion in deletion");
		}
		
		return toPrint;
	}

	/*
	 * method to flip each character in a string to search
	 * for valid words in that string
	 */
	public static ArrayList<StringBuilder> Transposition(String word) {
		int i = 0;
		int count = 0;
		try {
			while (i < word.length() - 1) {
				StringBuilder arr = new StringBuilder(word);
				char temp = arr.charAt(i);
				arr.setCharAt(i, arr.charAt(i + 1));
				arr.setCharAt(i + 1, temp);
				file.write("Transposition string: " + arr.toString());
				file.write("\n");
				count++;
				total++;
				i++;
			}
			file.write("Created " + count + " transposition alternatives\n\n");
		} catch (Exception e) {
			//System.out.println(e.printStackTrace());
			e.printStackTrace();
		}
		return toPrint;
	}

	public static ArrayList<StringBuilder> Substitution(String word) {
		int i = 0;
		int count = 0;
		try {
			while (i < word.length()) {
				StringBuilder arr = new StringBuilder(word);
				for (int j = 0; j < alphabet.length(); j++) {
					arr.setCharAt(i, alphabet.charAt(j));
					StringBuilder temp = new StringBuilder(arr);
					if (!temp.toString().equals(word)) {
						file.write("Substitution string: " + temp.toString());
						file.write("\n");
						count++;
						total++;
					}
				}
				i++;
			}
			file.write("Created " + count + " substitution alternatives\n\n");
		} catch (Exception e) {
			System.out.println("There was an excpetion in substitution");
		}
		return toPrint;
	}

	public static ArrayList<StringBuilder> Insertion(String word) {
		int i = 0;
		int count = 0;
		try {
			while (i < word.length() + 1) {
				StringBuilder arr = new StringBuilder(word);
				arr.insert(i, alphabet.charAt(0));
				for (int j = 0; j < alphabet.length(); j++) {
					arr.setCharAt(i, alphabet.charAt(j));
					StringBuilder temp = new StringBuilder(arr);
					if (!temp.toString().equals(word)) {
						{
							file.write("Insertion string: " + temp.toString());
							file.write("\n");
							count++;
							total++;
						}
					}
				}
				i++;
			}
			file.write("Created " + count + " insertion alternatives\n\n");
			file.write("TOTAL: generated " + total + " alternative spellings!");
			file.close();
		} catch (Exception e) {
			System.out.println("There was an excpetion in insertion");
		}
		return toPrint;
	}
	
	public static ArrayList<StringBuilder> run_ALL_the_functions(String word){
		total = 0;
		lastList.addAll(Deletion(word));
		lastList.addAll(Transposition(word));
		lastList.addAll(Substitution(word));
		lastList.addAll(Insertion(word));
		return lastList;
	}

	public static void populateDictionary(File input) {
		dictionary = new HashMap<String, Integer>();
		try {
			Scanner fileInput = new Scanner(input);

			int frequency = 0;
			String name = "";
			String token = "";

			while (fileInput.hasNextLine()) {
				if (fileInput.hasNext()) {
					token = fileInput.next();

					if (!token.equals("")) {
						name = token.toLowerCase();
					}

					token = fileInput.next();

					if (!token.equals("")) {
						frequency = Integer.parseInt(token);
					}

					dictionary.put(name, frequency);
				}
				else{
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File cannot be found.");
		}
	}
	public static void setFr(boolean tr){
		fr_isActive = tr;
	}
}