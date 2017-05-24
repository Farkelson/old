package assignment4;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * 
 *  
 */
public class SortUtil {
	private static int threshold = 0;
	private static int pivotNum;
	private static int pivotIndex;

	/**
	 * Helper insertion sort method.
	 * 
	 * @param arr
	 *            - input ArrayList of objects
	 * @param left
	 *            - start of the subarray
	 * @param right
	 *            - end of the subarray
	 */
	// Set to private
	public static <T extends Comparable<? super T>> void insertionsort(
			ArrayList<T> arr, int left, int right) {
		for (int i = left + 1; i < right + 1; i++) {
			T val = arr.get(i);
			int j;
			for (j = i - 1; j >= 0 && (arr.get(j).compareTo(val) > 0); j--)
				arr.set(j + 1, arr.get(j));
			arr.set(j + 1, val);
		}
	}

	/**
	 * MergSort algorithm driver.
	 * 
	 * @param arr
	 *            - input ArrayList of objects
	 */
	public static <T extends Comparable<? super T>> void mergesort(
			ArrayList<T> arr) {
		ArrayList<T> temp = new ArrayList<T>();
		mergesort(arr, temp, 0, arr.size()-1);
	}

	/**
	 * Main mergeSort method. Makes recursive calls.
	 * 
	 * @param arr
	 *            - input ArrayList of objects
	 * @param temp
	 *            - temporary ArrayList to hold the merged result
	 * @param left
	 *            - start of the subarray
	 * @param right
	 *            - end of the subarray
	 */
	// Change back to private!!
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr, ArrayList<T> temp, int left, int right) {
		if ((right - left) <= threshold) {
			insertionsort(arr, left, right);
		} 
		else if(temp.size()==1){
			return;
		}
		else {
			ArrayList<T> check = new ArrayList<T>();
			for (int i = left; i <= right; i++){
				check.add(arr.get(i));
			}
			
			int mid = (left + right) / 2;

			mergesort(arr, check, left, mid);
			mergesort(arr, check, mid + 1, right);

			merge(arr, temp, left, right);
		}
	}

	/**
	 * Internal method for merging two sorted subarrays
	 * 
	 * @param arr
	 *            - input ArrayList of objects
	 * @param temp
	 *            - temporary ArrayList in which the result with be placed
	 * @param left
	 *            - start of the subarray
	 * @param right
	 *            - end of the subarray
	 */
	// Change back to private!!
	public static <T extends Comparable<? super T>> void merge(
			ArrayList<T> arr, ArrayList<T> temp, int left, int right) {
		for (int i = left; i < right; i++) {
			temp.add(arr.get(i));
		}

		int middle = (left + right) / 2;
		int midplus = middle + 1;
		int tempStart = 0;
		int tempMid = middle - left;

		while (left + tempStart < middle && right > midplus + tempMid) {
			if (arr.get(left + tempStart).compareTo(arr.get(midplus + tempMid)) < 0) {
				temp.set(tempStart, arr.get(left + tempStart));
				tempStart++;
			} else if (arr.get(left + tempStart).compareTo(temp.get(midplus + tempMid)) > 0) {
				temp.set(tempMid, arr.get(midplus + tempMid));
				tempMid++;
			}
		}
		while (left + tempStart < middle) {
			temp.set(tempStart, arr.get(left + tempStart));
			tempStart++;
		}
		while (midplus + tempMid < right) {
			temp.set(midplus - left, arr.get(midplus + tempMid));
			tempMid++;
		}
	}

	/**
	 * Quicksort algorithm driver
	 * 
	 * @param arr
	 *            - input ArrayList of objects
	 */
	public static <T extends Comparable<? super T>> void quicksort(
			ArrayList<T> arr) {
		quicksort(arr, 0, arr.size() - 1);
	}
	
	/**
	 * Sets the value of pivotNum to choose a pivot Strategy
	 * @param setter the number assossiated with the desired pivot Strategy
	 */
	public static void setPivotNum(int setter){
		switch (setter){
		case 1:
			pivotNum=1;
			break;
		case 2:
			pivotNum=2;
			break;
		case 3:
			pivotNum=3;
			break;
		}
	}

	/**
	 * Main quicksort method. Makes recursive calls.
	 * 
	 * @param arr
	 *            - input ArrayList of objects.
	 * @param left
	 *            - start of the subarray
	 * @param right
	 *            - end of the subarray
	 */
	public static <T extends Comparable<? super T>> void quicksort(
			ArrayList<T> arr, int left, int right) {
//		if ((right - left) <= threshold) {
//			insertionsort(arr, left, right);
//			return;
//		}

		if(right<=left){
			return;
		}
		
		switch (pivotNum){
		case 1:
			pivotIndex = pivotStrategy1(arr, left, right);
			break;
		case 2:
			pivotIndex = pivotStrategy2(arr, left, right);
			break;
		case 3:
			pivotIndex = pivotStrategy3(arr, left, right);
			break;
		}
		//HERE WAS THE PROBLEM!!!
		//With my code it reqired you declare a pivotnumber before running
		//
		//
		T pivotVal = arr.get(pivotStrategy1(arr, left, right));
		int index = pivotStrategy1(arr, left, right);
		//Origonal: T pivotVal = arr.get(pivotIndex);
		//int index = pivotIndex;
		T end = arr.get(right);
		arr.set(right, pivotVal);
		arr.set(index, end);
		index = left;
		for (int i = left; i < right; i++) {
			T a = arr.get(i);
			if (a.compareTo(pivotVal) <= 0) {
				arr.set(i, arr.get(index));
				arr.set(index, a);
				index++;
			}
		}
		arr.set(right, arr.get(index));
		arr.set(index, pivotVal);
		quicksort(arr, left, index);
		quicksort(arr, index + 1, right);

	}

	/**
	 * First pivot strategy
	 * 
	 * @param arr
	 *            - input ArrayList of objects.
	 * @param left
	 *            - start of the subarray
	 * @param right
	 *            - end of the subarray
	 * @return index of chosen pivot
	 */
	public static <T extends Comparable<? super T>> int pivotStrategy1(
			ArrayList<T> arr, int left, int right) {
		int mid = (right - left) / 2;
		return (left + mid);
	}

	/**
	 * Second pivot strategy
	 * 
	 * @param arr
	 *            - input ArrayList of objects.
	 * @param left
	 *            - start of the subarray
	 * @param right
	 *            - end of the subarray
	 * @return index of chosen pivot
	 */
	public static <T extends Comparable<? super T>> int pivotStrategy2(
			ArrayList<T> arr, int left, int right) {
		int mid = left + (right - left) / 2;
		int winner = left;
		// Find the median
		if (arr.get(left).compareTo(arr.get(mid)) < 0
				&& arr.get(mid).compareTo(arr.get(right)) < 0) {
			winner = mid;
		} else if (arr.get(left).compareTo(arr.get(mid)) > 0
				&& arr.get(mid).compareTo(arr.get(right)) > 0) {
			winner = mid;
		} else if (arr.get(right).compareTo(arr.get(mid)) < 0
				&& arr.get(right).compareTo(arr.get(left)) > 0) {
			winner = right;
		} else if (arr.get(right).compareTo(arr.get(mid)) > 0
				&& arr.get(right).compareTo(arr.get(left)) < 0) {
			winner = right;
		}
		return winner;
	}

	/**
	 * Third pivot strategy
	 * 
	 * @param arr
	 *            - input ArrayList of objects.
	 * @param left
	 *            - start of the subarray
	 * @param right
	 *            - end of the subarray
	 * @return index of chosen pivot
	 */
	public static <T extends Comparable<? super T>> int pivotStrategy3(
			ArrayList<T> arr, int left, int right) {
		// Set Random Seed
		Random rnd = new Random();
		// Choose three random indexes within the indexes of the array
		int first = left + rnd.nextInt(right - left);
		int second = left + rnd.nextInt(right - left);
		int third = left + rnd.nextInt(right - left);
		int winner = first;
		// Find the median
		if (arr.get(first).compareTo(arr.get(second)) < 0
				&& arr.get(second).compareTo(arr.get(third)) < 0) {
			winner = second;
		} else if (arr.get(first).compareTo(arr.get(second)) > 0
				&& arr.get(second).compareTo(arr.get(third)) > 0) {
			winner = second;
		} else if (arr.get(third).compareTo(arr.get(second)) < 0
				&& arr.get(third).compareTo(arr.get(first)) > 0) {
			winner = third;
		} else if (arr.get(third).compareTo(arr.get(second)) > 0
				&& arr.get(third).compareTo(arr.get(first)) < 0) {
			winner = third;
		}
		return winner;
	}

	/**
	 * Generates the BestCase (ascending sorted ArrayList) for input into
	 * sorting algorithms.
	 * 
	 * @param size
	 *            size of the returned ArrayList
	 * @return an ArrayList of integers in sorted, ascending order.
	 */
	public static ArrayList<Integer> generateBestCase(int size) {
		ArrayList<Integer> ascend = new ArrayList<Integer>(size);
		for (int i = 1; i <= size; i++)
			ascend.add(i);
		return ascend;
	}

	/**
	 * Generates the AverageCase (permuted ArrayList) for input into sorting
	 * algorithms.
	 * 
	 * @param size
	 *            the size of the returned ArrayList
	 * @return An ArrayList of random integers from 0-size in permuted order
	 */
	public static ArrayList<Integer> generateAverageCase(int size) {
		// Set Random Seed
		Random rnd = new Random();
		ArrayList<Integer> temp = new ArrayList<Integer>(size);
		for (int i = 1; i <= size; i++) {
			temp.add(i);
		}
		for (int i = 0; i < size; i++)
			swap(temp, i, rnd.nextInt(size));

		return temp;
	}

	/**
	 * Swaps two numbers in an array.
	 * 
	 * @param arr
	 *            the array to get the numbers to be swapped
	 * @param i
	 *            the first number to swap with...
	 * @param j
	 *            the second number
	 */
	public static void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

	/**
	 * Generates a WorstCase (descending sorted ArrayList) for input into
	 * sorting algorithms.
	 * 
	 * @param size
	 *            the size of the returned ArrayList
	 * @return An ArrayList of integers in descending order
	 */
	public static ArrayList<Integer> generateWorstCase(int size) {
		ArrayList<Integer> ascend = new ArrayList<Integer>(size);
		for (int i = size; i > 0; i--)
			ascend.add(i);
		return ascend;
	}

}
