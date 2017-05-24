package underTheRainbow;

import java.util.ArrayList;
import java.util.Scanner;

public class UnderTheRainbow {
	
	static ArrayList<Integer> hotelsDist, penalties;
	static int numHotels;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		numHotels = Integer.parseInt(input) + 1;
		hotelsDist = new ArrayList();
		penalties = new ArrayList();
		for(int i = 0; i < numHotels; i++){
			String dist = scanner.nextLine();
			hotelsDist.add(Integer.parseInt(dist));
			penalties.add(-1);
		}
		
		System.out.println(penalty());
	}
	
	public static int penalty(){
		return penalty(0);
	}
	
	public static int penalty(int x){
		if(x == numHotels){
			penalties.set(x, 0);
			return 0;
		}
		else{
			if(penalties.get(x) >= 0){
				return penalties.get(x);
			}
			int currentMin = -1;
			for(int j=numHotels-1; j>x; j--){
				int dist = hotelsDist.get(j)-hotelsDist.get(x);
				int pen = (int) Math.pow(400-dist,2);
				if(currentMin < 0){
					currentMin = pen + penalty(j);
				}
				else{
					currentMin = Math.min(currentMin,pen + penalty(j));
				}
			}
			if(currentMin == -1) currentMin = 0;
			penalties.set(x, currentMin);
			return currentMin;
		}
	}

}
