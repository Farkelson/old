package autoSink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AutoSink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		int numCities = Integer.parseInt(input);
		ArrayList<Vertex> citiesAToll = new ArrayList<Vertex>();
		for(int i = 0; i < numCities; i++){
			String newCityAToll = scanner.nextLine();
			String[] indivInfo = newCityAToll.split(" ");
			citiesAToll.add(new Vertex(indivInfo[0], Integer.parseInt(indivInfo[1])));
		}
		
		int numHighways = Integer.parseInt(scanner.nextLine());
//		ArrayList<Edge> highways = new ArrayList<Edge>();
		for(int i = 0; i < numHighways; i++){
			String newHighway = scanner.nextLine();
			String[] indivInfo = newHighway.split(" ");
//			citiesAToll.	
			
		}
		
		int numtrips = Integer.parseInt(scanner.nextLine());
		ArrayList<Trip> trips = new ArrayList<Trip>();
		for(int i = 0; i < numHighways; i++){
			String newTrip = scanner.nextLine();
			String[] indivInfo = newTrip.split(" ");
			trips.add(new Trip(indivInfo[0], indivInfo[1]));
		}
		
		Vertex current = citiesAToll.get(0);
		for(int i=0; i < numCities*2; i++){
			if(current.preTime == 0)current.preTime = i;
		}
		
	}
	
	public static class Vertex {
		
		private int preTime = 0;
		private int postTime = 0;
		private int toll = 0;
		private String cityName = "";
		private ArrayList<Vertex> children = new ArrayList<Vertex>();
		
		public Vertex(String name, int toll){
			cityName = name;
			this.toll = toll;
		}
		
		public void addVertex(Vertex vertex){
			children.add(vertex);
		}
	}
	
//public static class Edge {
//		
//		private String cityName1 = "";
//		private String cityName2 = "";
//		
//		public Edge(String city1, String city2){
//			cityName1 = city1;
//			cityName2 = city2;
//		}
//	}

public static class Trip {
	
	private String cityName1 = "";
	private String cityName2 = "";
	
	public Trip(String city1, String city2){
		cityName1 = city1;
		cityName2 = city2;
	}
}

}
