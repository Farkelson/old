package assignment10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BestWordSearch {

	//initialization of all needed private member variables
	public static HashMap<String, Integer> dictionary;
	private static StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
	private static ArrayList<StringBuilder> lastList = new ArrayList<StringBuilder>();
	public static boolean fr_isActive = false;

	/*
	 * method to run deletion of each character in a string to search
	 * for valid words in that string
	 */
	public static ArrayList<StringBuilder> Deletion(String word) {
		//to calculate how many times to loop, deleting characters
		int i = 0;
		/*
		 * toPrint collects all of the string builders and outputs them
		 * to the created file, or to the screen depending on if the program
		 * is in -fr mode.
		 */
		ArrayList<StringBuilder> toPrint = new ArrayList<StringBuilder>();
		//continue looping while we haven't reached the end of the word
		while (i < word.length()) {
			//creates a new string builder of the word we are spellchecking
			StringBuilder arr = new StringBuilder(word);
			//deletes the i'th character in the string
			arr = arr.delete(i, i + 1);
			/*
			 * if -fr mode is active this will be used to generate a txt file
			 * of all alternatives as well as return valid words statement
			 * if not this will only return valid words
			 */
			if (dictionary.containsKey(arr.toString()) || fr_isActive == true) {
				toPrint.add(arr);
			}
			i++;
		}
		return toPrint;
	}

	/*
	 * method to flip each character in a string to search
	 * for valid words in that string
	 */
	public static ArrayList<StringBuilder> Transposition(String word) {
		int i = 0;
		ArrayList<StringBuilder> toPrint = new ArrayList<StringBuilder>();
		while (i < word.length() - 1) {
			StringBuilder arr = new StringBuilder(word);
			char temp = arr.charAt(i);
			arr.setCharAt(i, arr.charAt(i + 1));
			arr.setCharAt(i + 1, temp);
			if (dictionary.containsKey(arr.toString()) || fr_isActive == true) {
				toPrint.add(arr);
			}
			i++;
		}
		return toPrint;
	}

	public static ArrayList<StringBuilder> Substitution(String word) {
		int i = 0;
		ArrayList<StringBuilder> toPrint = new ArrayList<StringBuilder>();
		while (i < word.length()) {
			StringBuilder arr = new StringBuilder(word);
			for (int j = 0; j < alphabet.length(); j++) {
				arr.setCharAt(i, alphabet.charAt(j));
				StringBuilder temp = new StringBuilder(arr);
				if (!temp.toString().equals(word)) {
					if (dictionary.containsKey(temp.toString()) || fr_isActive == true) {
						toPrint.add(temp);
					}
				}
			}
			i++;
		}
		return toPrint;
	}

	public static ArrayList<StringBuilder> Insertion(String word) {
		int i = 0;
		ArrayList<StringBuilder> toPrint = new ArrayList<StringBuilder>();
		while (i < word.length() + 1) {
			StringBuilder arr = new StringBuilder(word);
			arr.insert(i, alphabet.charAt(0));
			for (int j = 0; j < alphabet.length(); j++) {
				arr.setCharAt(i, alphabet.charAt(j));
				StringBuilder temp = new StringBuilder(arr);
				if (!temp.toString().equals(word)) {
					if (dictionary.containsKey(temp.toString()) || fr_isActive == true) {
						toPrint.add(temp);
					}
				}
			}
			i++;
		}
		return toPrint;
	}
	
	public static ArrayList<StringBuilder> run_ALL_the_functions(String word){
		lastList.clear();
		lastList.addAll(Deletion(word));
		lastList.addAll(Transposition(word));
		lastList.addAll(Substitution(word));
		lastList.addAll(Insertion(word));
		return lastList;
	}
	
	public static void getBest(String word){
		word.toLowerCase();
		if (lastList.isEmpty()) {
			System.out.println(word + " is an unknown term!");

		} else {
			StringBuilder result = lastList.get(0);
			int bestNum = dictionary.get(result.toString());
			for (int i = 0; i < lastList.size(); i++) {
				if (dictionary.get(lastList.get(i).toString()) > bestNum) {
					bestNum = dictionary.get(lastList.get(i).toString());
					result = lastList.get(i);
				}
			}
			System.out.println(word + " is an unknown term..."+"did you mean: '"+ result.toString()+"' ?");
		}
		
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
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File cannot be found.");
		}
	}
}