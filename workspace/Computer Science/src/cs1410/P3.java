package cs1410;

import java.util.Scanner;

//Scott Glass using Scanners and Operators
public class P3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner x = new Scanner("7 9 14 70000 343");
		System.out.println(largest(x));
		x = new Scanner("word hat mind word plus word word nine plus");
		String word = ("plus");
		System.out.println(countWord(x, word));
		x = new Scanner("4.0 5.5 9.5 2.0");
		System.out.println(average(x));
		x = new Scanner("this is a kinda funny weird word test");
		System.out.println(compareParity(x));	
		x = new Scanner("hi how are you dick face");
		System.out.println(lastLetters(x));
		x = new Scanner("1 2 3 4 5 6 7 8 9 10 11 12");
		System.out.println(threeCount(x));
		x = new Scanner("first hand mat zebra");
		System.out.println(first(x));
		x = new Scanner("flight now pie pouring");
		System.out.println(total(x));
		x = new Scanner("1 2 5 8 10 40 22");
		System.out.println(between(x,0,21));
		x = new Scanner("4.0 9.0 16.0 25.0");
		System.out.println(sumOfSquareRoots(x));
		
	}
	//The method should return the largest integer from an imput
	//provided by a Scanner
	public static int largest(Scanner x){
		int l = 0;
		while (x.hasNext()){
			int t = x.nextInt();
			if (l<t){
				l=t;				
			}
		}
		return l;		
	}
	// The method should return the number of times that a word occurs in the Scanner
	public static int countWord(Scanner x, String word){
		int count = 0;
		while (x.hasNext()){
			String t = x.next();
			if (t.equals(word)){
				count = count + 1;
			}
		}
		if(count>0){
				return count;
			}
		return 0;
	}
	//The method should return the average of the doubles in a Scanner
	public static double average(Scanner x){
		double numbers = 0;
		double total = 0;
		while(x.hasNext()){
			double u = Double.parseDouble(x.next());
			total = total + u;
			numbers = numbers + 1;
		}
		if (numbers!=0){
			double avg = total/numbers;
		return avg;
		}
		return 0.0;
	}
	//The method should return true if the input Scanner contains more 
	//strings of even length than strings of odd length and should return 
	//false if otherwise
	public static String compareParity(Scanner x){
		int odd = 0;
		int even = 0;
		while (x.hasNext()){
			String y = x.next();
			if (y.length()%2 == 0){
				even = even + 1;
			}
			else if (y.length()%2!=0){
				odd = odd + 1;
			}
		}
			if (even>odd){
				return "true";
			}
		return "false";
			
		}
	
	//The method should return a String consisting of the last letter of every word in the Scanner
	public static String lastLetters(Scanner x){
		String w = "";
		while (x.hasNext()){
			String v = x.next();
			int lastIndex = v.length() - 1;
			char c = v.charAt(lastIndex);
			w = w + c;
		}
		return w;
	}
	//The method should return how many of the integers in the Scanner 
	//are evenly divisible by 3
	public static int threeCount(Scanner x){
		int threes = 0;
		while (x.hasNext()){
			int y = Integer.parseInt(x.next());
			if (y%3 == 0){
				threes = threes + 1;
		}
		}
		return threes;
	}
	//The method should return the word from the Scanner that comes first in lexicographic order
	public static String first(Scanner x){
		String end = "z";
		int order = 0;
		while (x.hasNext()){
			String test = x.next();
			order = (end.compareTo(test));
			if (order>0){
				end = test;
			}
		}
		return end;
	}
	//The method should return the total number of letters in all of the words from the Scanner
	public static int total(Scanner x){
		int added = 0;
		while (x.hasNext()){
			String v = x.next();
			int amount = v.length();
			added = added + amount;
		}
		return added;
	}
	//The method should return how many of the integers in the 
	//Scanner are greater than or equal to a and less than or equal to b
	public static int between(Scanner x, int a, int b){
		int bee = 0;
		while (x.hasNext()){
			int c = Integer.parseInt(x.next());
			if (c>= a){
				if (c<=b){
					bee = bee +1;
					
				}
			}
		}
		return bee;
	}
	// The method should return the sum of the square roots of the doubles in 
	//the Scanner
	public static double sumOfSquareRoots(Scanner x){
		double sumrot = 0;
		while (x.hasNext()){
			double root = Double.parseDouble(x.next());
			sumrot = sumrot + Math.sqrt(root);
		}
		return sumrot;
	}
	
	
	
	
	
	
	
	
	
}
