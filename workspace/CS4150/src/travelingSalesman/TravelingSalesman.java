package travelingSalesman;

import java.util.ArrayList;
import java.util.Scanner;

public class TravelingSalesman {
	
	public static ArrayList<ArrayList<Integer>> edges;
	public static int lowest;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		int numVertecies = Integer.parseInt(input);
		edges = new ArrayList<ArrayList<Integer>>();
		// 50 edges at 500 max, so lowest set > 25,000 is easily not the answer
		lowest = 30000;
		for(int i = 0; i < numVertecies; i++){
			String vertex = scanner.nextLine();
			String[] vertexInfo = vertex.split(" ");
			for(int j = 0; j < numVertecies; j++){
				edges.add(new ArrayList<Integer>(Integer.parseInt(vertexInfo[j])));
			}
		}
		solve(0);
		System.out.println(lowest);
	}
	
	public static void solve(int row){
		
	}

}
