package assignment4;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SortUtilTest extends TestCase {

	private ArrayList<Integer> T;
	
	protected void setUp() throws Exception {
		super.setUp();
		T = new ArrayList<Integer>();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testgenerateAverageCase1(){
		T = SortUtil.generateAverageCase(100);
		for (int i =1; i<=T.size();i++){
			if (!T.contains(i)){
				System.out.println("FALSE");
			}
		}
		System.out.println("TRUE");
		
	}
	public void testgenerateAverageCase2(){
		T = SortUtil.generateAverageCase(100);
		assertEquals(100, T.size());		
	}
	public void testgenerateBestCase(){
		for(int i = 1; i <= 1000; i++){
			T.add(i);
		}
		assertEquals(T,SortUtil.generateBestCase(1000));
	}
	public void testgenerateWorstCase(){
		for(int i = 1000; i > 0; i--){
			T.add(i);
		}
		assertEquals(T,SortUtil.generateWorstCase(1000));
	}
	public void testinsertionsort(){
		T = SortUtil.generateBestCase(1000);
		ArrayList <Integer>x = new ArrayList<Integer> (SortUtil.generateAverageCase(1000));
		SortUtil.insertionsort(x,0,x.size()-1);
		assertEquals(T, x);
	}
	public void testquicksort11(){
		T = SortUtil.generateBestCase(1000);
		ArrayList<Integer> x = SortUtil.generateAverageCase(1000);
		SortUtil.setPivotNum(1);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort21(){
		T = SortUtil.generateBestCase(100);
		ArrayList<Integer> x = SortUtil.generateAverageCase(100);
		SortUtil.setPivotNum(1);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort31(){
		T = SortUtil.generateBestCase(1000);
		ArrayList<Integer> x = SortUtil.generateAverageCase(1000);
		SortUtil.setPivotNum(1);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort41(){
		T = SortUtil.generateBestCase(10000);
		ArrayList<Integer> x = SortUtil.generateAverageCase(10000);
		SortUtil.setPivotNum(1);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort12(){
		T = SortUtil.generateBestCase(100);
		ArrayList<Integer> x = SortUtil.generateAverageCase(100);
		SortUtil.setPivotNum(2);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort22(){
		T = SortUtil.generateBestCase(100);
		ArrayList<Integer> x = SortUtil.generateAverageCase(100);
		SortUtil.setPivotNum(2);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort32(){
		T = SortUtil.generateBestCase(1000);
		ArrayList<Integer> x = SortUtil.generateAverageCase(1000);
		SortUtil.setPivotNum(2);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort42(){
		T = SortUtil.generateBestCase(10000);
		ArrayList<Integer> x = SortUtil.generateAverageCase(10000);
		SortUtil.setPivotNum(2);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort13(){
		T = SortUtil.generateBestCase(100);
		ArrayList<Integer> x = SortUtil.generateAverageCase(100);
		SortUtil.setPivotNum(3);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort23(){
		T = SortUtil.generateBestCase(100);
		ArrayList<Integer> x = SortUtil.generateAverageCase(100);
		SortUtil.setPivotNum(3);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort33(){
		T = SortUtil.generateBestCase(1000);
		ArrayList<Integer> x = SortUtil.generateAverageCase(1000);
		SortUtil.setPivotNum(3);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}
	public void testquicksort43(){
		T = SortUtil.generateBestCase(10000);
		ArrayList<Integer> x = SortUtil.generateAverageCase(10000);
		SortUtil.setPivotNum(3);
		SortUtil.quicksort(x);
		assertEquals(T, x);
	}	
	public void testMergeSort1(){
		T = SortUtil.generateAverageCase(10);
		SortUtil.mergesort(T);
		System.out.println(T);		
	}
	public void testMergeSort2(){
		T = SortUtil.generateAverageCase(100);
		SortUtil.mergesort(T);
		System.out.println(T);		
	}public void testMergeSort3(){
		T = SortUtil.generateAverageCase(1000);
		SortUtil.mergesort(T);
		System.out.println(T);		
	}
	public void testBestcase(){
		T = SortUtil.generateAverageCase(100);
		System.out.println(T);
		//This is where it went bad
		//SortUtil.setPivotNum(1);
		SortUtil.quicksort(T);
		System.out.println(T);
		assertEquals(T, SortUtil.generateBestCase(100));
	}
	
}
