package narrowArtGallery;

import java.util.Scanner;

public class NarrowArtGallery2 {
	
	static int numRoomsToClose, numRows;
	static int[][] values;
	static int[][][] maxedValues;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String[] indivInfo = input.split(" ");
		numRows = Integer.parseInt(indivInfo[0]);
		numRoomsToClose = Integer.parseInt(indivInfo[1]);
		
		values  = new int[numRows+1][2];
		for(int i = 0; i < numRows+1; i++){
			String newGalleryRow = scanner.nextLine();
			String[] row = newGalleryRow.split(" ");
			values[i][0] = Integer.parseInt(row[0]);
			values[i][1] = Integer.parseInt(row[1]);
		}

		maxedValues = new int [numRows][3][numRows+1];
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < numRows+1; k++){
					maxedValues[i][j][k]=-1;
				}
			}
		}
		
		int retVal = maxValues();	
		System.out.println(retVal);
	}
	
	public static int maxValues(){
		return maxValues(numRows,-1,numRoomsToClose);
	}
	
	public static int maxValues(int r, int roomsCannotClose, int k){
		if(r == 0){
			return 0;
		}
		if(k==numRows - r){
			if(roomsCannotClose == 0){
				if(maxedValues[r][roomsCannotClose+1][k] == -1){
					maxedValues[r][roomsCannotClose+1][k] = values[r][0] + maxValues(r+1, 0, k-1);
				}
				return maxedValues[r][roomsCannotClose+1][k];
			}
			else if(roomsCannotClose == 1){
				if(maxedValues[r][roomsCannotClose+1][k] == -1){
					maxedValues[r][roomsCannotClose+1][k] = values[r][1] + maxValues(r+1, 1, k-1);
				}
				return maxedValues[r][roomsCannotClose+1][k];
			}
			else{ //roomsCannotClose = -1
				if(maxedValues[r][roomsCannotClose+1][k] == -1){
					maxedValues[r][roomsCannotClose+1][k] = Math.max(values[r][0] + maxValues(r+1, 0, k-1), values[r][1] + maxValues(r+1, 1, k-1));
				}
				return maxedValues[r][roomsCannotClose+1][k];
			}
		}
		else if(k < numRows - r){
			if(roomsCannotClose == 0){
				if(maxedValues[r][roomsCannotClose+1][k] == -1){
					maxedValues[r][roomsCannotClose+1][k] = Math.max(values[r][0] + maxValues(r+1, 0, k-1), values[r][1] +values[r][0]+ maxValues(r+1, -1, k));
				}
				return maxedValues[r][roomsCannotClose+1][k];
			}
			else if(roomsCannotClose == 1){
				if(maxedValues[r][roomsCannotClose+1][k] == -1){
					maxedValues[r][roomsCannotClose+1][k] = Math.max(values[r][1] + maxValues(r+1, 1, k-1), values[r][1] +values[r][0]+ maxValues(r+1, -1, k));
				}
				return maxedValues[r][roomsCannotClose+1][k];
			}
			else{ //roomsCannotClose = -1
				if(maxedValues[r][roomsCannotClose+1][k] == -1){
					maxedValues[r][roomsCannotClose+1][k] = Math.max(
							Math.max(values[r][1] + maxValues(r+1, 1, k-1), values[r][1] +values[r][0]+ maxValues(r+1, -1, k)),
							Math.max(values[r][0] + maxValues(r+1, 0, k-1), values[r][1] +values[r][0]+ maxValues(r+1, -1, k)));
				}
				return maxedValues[r][roomsCannotClose+1][k];
			}
		}
		return 0;
	}

}
