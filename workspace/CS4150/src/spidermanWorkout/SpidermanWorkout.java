package spidermanWorkout;

import java.util.ArrayList;
import java.util.Scanner;

public class SpidermanWorkout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		int numProbs = Integer.parseInt(input);
		for(int i = 0; i < numProbs; i++){
			//Solve each problem
			int numOfClimbs = Integer.parseInt(scanner.nextLine());
			String[] climbAmtsString = scanner.nextLine().split(" ");
			int maxPossHeight = 0;
			ArrayList<Integer> climbAmts = new ArrayList<Integer>();
			for (int j = 0; j<numOfClimbs; j++){
				climbAmts.add(Integer.parseInt(climbAmtsString[j]));
				maxPossHeight += Integer.parseInt(climbAmtsString[j]);
			}
			
			// Got the data, now to work
			// Setup
			ArrayList<ArrayList<Integer>> minHeight = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Character>> moveTable = new ArrayList<ArrayList<Character>>();
			// Need to make the arrays so big
			// 2000 means impossible since we know sum < 1000
			for(int j = 0; j < numOfClimbs; j++){
				minHeight.add(new ArrayList<Integer>());
				moveTable.add(new ArrayList<Character>());
				for(int k = 0; k <= maxPossHeight; k++){
					minHeight.get(j).add(2000);
					moveTable.get(j).add('z');
				}
			}
			// The last move has to be down to ground level
			int height = climbAmts.get(numOfClimbs-1);
			minHeight.get(numOfClimbs-1).set(height, height);
			moveTable.get(numOfClimbs-1).set(height, 'D');
			
			// Each move can climb up or down back onto path to the end
			// Here is the meat
			// We know the last row is set, now move backwards
			for (int j = numOfClimbs - 2; j >=0; j--){
				// For other values we need to check if any are set
				for(int k = 0; k <= maxPossHeight; k++){
					// Found one!
					if(minHeight.get(j+1).get(k) != 2000){
						// Check climb up then down to next point
						if(k >= climbAmts.get(j)){
							// Do this part if not set, don't so it if there is already a better option
							if(minHeight.get(j).get(k - climbAmts.get(j)) > minHeight.get(j+1).get(k)){
								minHeight.get(j).set(k- climbAmts.get(j), minHeight.get(j+1).get(k));
								moveTable.get(j).set(k- climbAmts.get(j), 'U');
							}
						}
						int newMinHeight = Math.max(minHeight.get(j+1).get(k), k + climbAmts.get(j));
						if(minHeight.get(j).get(k + climbAmts.get(j)) > newMinHeight){
							minHeight.get(j).set(k+ climbAmts.get(j), newMinHeight);
							moveTable.get(j).set(k+ climbAmts.get(j), 'D');
						}
					}
				}
			}
			
			if(minHeight.get(0).get(0) == 2000){
				System.out.print("IMPOSSIBLE");
			}
			else{
				int delta = 0;
				for (int m = 0; m < numOfClimbs; m++) {
					System.out.print(moveTable.get(m).get(delta));

					if (moveTable.get(m).get(delta) == 'U'){
						delta += climbAmts.get(m);
					}
					else{
						delta -= climbAmts.get(m);
					}
				}
			}
			System.out.println();
			
		}
	}

}
