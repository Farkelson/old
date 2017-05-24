package mranaga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Mranaga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String[] numALength = input.split(" ");
		int numWords = Integer.parseInt(numALength[0]);
		int wordLength = Integer.parseInt(numALength[1]);
		
		ArrayList<String> startWords = new ArrayList<String>();
		for(int i = 0; i < numWords; i++){
			String newWord = scanner.nextLine();
			startWords.add(newWord);
		}
		Set<String> solutions = new HashSet<String>();
		Set<String> rejected = new HashSet<String>();
		
		for (Iterator<String> i = startWords.iterator(); i.hasNext();){
			String unsortedWord = i.next();
			char[] unsortedChars = unsortedWord.toCharArray();
			Arrays.sort(unsortedChars);
			String sortedWord = new String(unsortedChars);
			if(solutions.contains(sortedWord)){
				solutions.remove(sortedWord);
				rejected.add(sortedWord);
			}
			else if(!rejected.contains(sortedWord)){
				solutions.add(sortedWord);
			}
		}
		System.out.println(solutions.size());
	}

}
