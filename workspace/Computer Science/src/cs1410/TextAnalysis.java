package cs1410;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class TextAnalysis {

	/*Scott Glass making a text analysis program
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String SearchWord = JOptionPane.showInputDialog("Enter the word you want to search for:");
		if (SearchWord == null){
			System.exit(0);
		}
		SearchWord = SearchWord.toLowerCase();
		JFileChooser chooser = new JFileChooser();
		int outcome = chooser.showOpenDialog(null);
		if (outcome == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			Scanner x = new Scanner(f);
			int count = countSearchWord(x, SearchWord);
			JOptionPane.showMessageDialog(null, "Search word count: " + count);
			x = new Scanner(f);
			count = CountTotalWords(x);
			JOptionPane.showMessageDialog(null, "Total word count: " + count);
			x = new Scanner(f);
			count = AvgLength(x, f);
			JOptionPane.showMessageDialog(null, "Average word length: " + count);
			x = new Scanner(f);
			String beforeWord = beforeWord(x, SearchWord);
			JOptionPane.showMessageDialog(null, "Word that comes lexicographiclly before your seach word: " + beforeWord);
			x = new Scanner(f);
			String afterWord = afterWord(x, SearchWord);
			JOptionPane.showMessageDialog(null, "Word that comes lexicographiclly after your seach word: " + afterWord);
			x = new Scanner(f);
			double amount = Percentage(x, SearchWord, f);
			JOptionPane.showMessageDialog(null, "Percentage of words that are your search word: " + amount);
		}
	}
	/*Searches for the SearchWord and returns the number of time the word
	 * is found within the file
	 */
	public static int countSearchWord(Scanner s, String word) {
		int count = 0;
		while (s.hasNext()) {
			String t = s.next().toLowerCase();
			if (t.equalsIgnoreCase(word)) {
				count++;
			}
		}
		return count;
	}
	/*Counts the total amount of words in the file
	 */
	public static int CountTotalWords(Scanner s){
		int count = 0;
		while (s.hasNext()){
			s.next();
			count++;
		}
		return count;
	}
	/*Calculates the average length of all the words within the file
	 */
	public static int AvgLength(Scanner s, File f) throws FileNotFoundException{
		int avglngth = 0;
		int ttllngth = 0;
		while (s.hasNext()){
			String t = s.next();
			ttllngth = ttllngth + t.length();
		}
		Scanner x = new Scanner (f);
		avglngth = ttllngth/CountTotalWords(x);
		return avglngth;
	}
	/*Finds the word that would come immediately before the SearchWord if all the 
	 * distinct words in the file were arranged in lexicographic order and returns
	 * the SearchWord if no other word is found
	 */
	public static String beforeWord(Scanner s, String SearchWord){
		String oldWord = "";
		while (s.hasNext()){
			String newword = s.next();
			if (newword.compareTo(SearchWord)<0 && newword.compareTo(oldWord)>0){
						oldWord = newword;
			}
			else{
			}
		}
		if (oldWord != SearchWord){
			return oldWord;
		}
		return SearchWord;
	}
	/*Finds the word that would come immediately after the SearchWord if all the 
	 * distinct words in the file were arranged in lexicographic order and returns
	 * the SearchWord if no other word is found
	 */
	public static String afterWord(Scanner s, String SearchWord){
		String oldWord = "";
		while (s.hasNext()){
			String newword = s.next();
			if (newword.compareTo(SearchWord)>0){
				oldWord = newword;
			}
			while (s.hasNext()){
				newword = s.next();
			if (newword.compareTo(SearchWord)>0 && newword.compareTo(oldWord)<0){
						oldWord = newword;
			}
			else{
			}
			}
		}
		if (oldWord != SearchWord){
			return oldWord;
		}
		return SearchWord;
	}
	/*Calculates the percentage of the file is made up of the SearchWord
	 */
	public static double Percentage(Scanner s, String SearchWord, File f) throws FileNotFoundException{
		double Percent = 0;
		double x = countSearchWord(s, SearchWord);
		s = new Scanner (f);
		double y = CountTotalWords(s);
		Percent = 100*x/y;
		return Percent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}