package assignment9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Represents a priority queue of generically-typed items. 
 * The queue is implemented as a min heap. 
 * The min heap is implemented implicitly as an array.
 * 
 * @author Paymon Saebi & ??
 */
public class PriorityQueueHEAP<AnyType> 
{
	private int currentSize;
	private AnyType[] array;
	private Comparator<? super AnyType> cmp;

	/**
	 * Constructs an empty priority queue. Orders elements according
	 * to their natural ordering (i.e., AnyType is expected to be Comparable)
	 * AnyType is not forced to be Comparable.
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueueHEAP() 
	{
		currentSize = 0;		
		array = (AnyType[]) new Object[10]; // safe to ignore warning
		cmp = null;
	}

	/**
	 * Construct an empty priority queue with a specified comparator.
	 * Orders elements according to the input Comparator 
	 * (i.e., AnyType need not be Comparable).
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueueHEAP(Comparator<? super AnyType> c) 
	{
		currentSize = 0;		
		array = (AnyType[]) new Object[10]; // safe to ignore warning
		cmp = c;
	}

	/**
	 * @return the number of items in this priority queue.
	 */
	public int size() 
	{
		return currentSize;
	}

	/**
	 * Makes this priority queue empty.
	 */
	public void clear() 
	{
		currentSize = 0;
	}

	/**
	 * @return the minimum item in this priority queue.
	 * @throws NoSuchElementException if this priority queue is empty.
	 * 
	 * (Runs in constant time.)
	 */
	public AnyType findMin() throws NoSuchElementException 
	{
		if(currentSize==0){
			throw new NoSuchElementException();
		}
		return array[0];
	}

	/**
	 * Removes and returns the minimum item in this priority queue.
	 * 
	 * @throws NoSuchElementException if this priority queue is empty.
	 * 
	 * (Runs in logarithmic time.)
	 */
	public AnyType deleteMin() throws NoSuchElementException 
	{
		// if the heap is empty, throw a NoSuchElementException
		if(currentSize==0){
			throw new NoSuchElementException();
		}
		// store the minimum item so that it may be returned at the end
		AnyType retVal = array[0];

		// replace the item at minIndex with the last item in the tree
		array[0]=array[currentSize-1];
		array[currentSize-1] = null;

		// update size
		currentSize--;

		// percolate the item at minIndex down the tree until heap order is restored
		// It is STRONGLY recommended that you write a percolateDown helper method!
		percolateDown();

		// return the minimum item that was stored
		return retVal;
	}

	public void percolateDown(){

		int curr = 0;
		boolean retval = true;

		//starts percolating at root, i'm not sure we want a for loop here.
		//while(array[curr*2 + 1] != null && array[curr*2 +2] != null){	
			while(retval){
				//check all base cases
				if(curr*2 +1 >= currentSize){
					retval = false;
					continue;
				}
				if(array[curr*2 +1] == null){
					retval = false;
					continue;
				}
				if(compare(array[curr*2 +1],array[curr])>0 && curr*2 + 2 >= currentSize){
					retval = false;
					continue;
				}
				if(compare(array[curr*2 +1],array[curr])>0 && array[curr*2 + 2] == null){
					retval = false;
					continue;
				}
				if(compare(array[curr*2 +1],array[curr])>0 && compare(array[curr*2 + 2], array[curr])<0){
					retval = false;
					continue;
				}
				//check which child to go down
				if(array[curr*2 + 2] == null  || compare(array[curr*2 + 1], array[curr*2 + 2])<0){
					//checks if the item we are percolating down is smaller than the left child
					if(compare(array[curr],array[curr*2 +1])>0){
						//swaps the parent with the left child
						AnyType temp;
						temp = array[curr];
						array[curr] = array[curr*2 + 1];
						array[curr*2 +1] = temp;	
						curr = curr*2 + 1;
					}
					//percolation complete, return.
					else retval = false;
					continue;
				}
				//if the right child is smaller than the left child
				else{
					//checks if the item we are percolating down is smaller than the right child
					if(compare(array[curr],array[curr*2 +2])>0){
						//swaps the parent with the right child
						AnyType temp;
						temp = array[curr];
						array[curr] = array[curr*2 + 2];
						array[curr*2 + 2] = temp;	
						curr = curr*2 + 2;
					}
					//percolation complete, return.
					else retval = false;
				}
			}
		}
	
	/**
	 * Adds an item to this priority queue.
	 * 
	 * (Runs in constant time, worst case logarithmic)
	 * 
	 * @param x -- the item to be inserted
	 */
	public void add(AnyType x) 
	{
		// if the array is full, double its capacity
		if(array.length == currentSize){
			AnyType[] temp = (AnyType[]) new Object[currentSize*2];
			for(int i =0; i<array.length;i++){
				temp[i]=array[i];
			}
			array=temp;
		}

		// add the new item to the next available node in the tree, so that
		// complete tree structure is maintained
		array[currentSize]=x;

		// update size
		currentSize++;

		// percolate the new item up the levels of the tree until heap order is restored
		// It is STRONGLY recommended that you write a percolateUp helper method!
		percolateUp();

	}

	public void percolateUp(){

		int curr = currentSize - 1;
		{
			//if the parent is smaller than the child continue percolating
			while(curr != 0 && compare(array[curr], array[(curr -1)/2])<0){
				//swaps the item with the left child
				AnyType temp;
				temp = array[(curr -1)/2];
				array[(curr -1)/2] = array[curr];
				array[curr] = temp;
				curr = (curr -1)/2;
			}
			//percolation complete, return.
		}
	}

	/**
	 * Generates a DOT file for visualizing the binary heap.
	 */
	public void generateDotFile(String filename) 
	{
		try 
		{
			PrintWriter out = new PrintWriter(filename);
			out.println("digraph Heap {\n\tnode [shape=record]\n");

			for(int i = 0; i < currentSize; i++) {
				out.println("\tnode" + i + " [label = \"<f0> |<f1> " + array[i] + "|<f2> \"]");
				if(((i*2) + 1) < currentSize)
					out.println("\tnode" + i + ":f0 -> node" + ((i*2) + 1) + ":f1");
				if(((i*2) + 2) < currentSize)
					out.println("\tnode" + i + ":f2 -> node" + ((i*2) + 2) + ":f1");
			}

			out.println("}");
			out.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		}
	}

	/**
	 * Internal method for comparing lhs and rhs using Comparator if provided by the
	 * user at construction time, or Comparable, if no Comparator was provided.
	 */
	@SuppressWarnings("unchecked")
	private int compare(AnyType lhs, AnyType rhs) 
	{
		if (cmp == null)
			return ((Comparable<? super AnyType>) lhs).compareTo(rhs); // safe to ignore warning
		// We won't test your code on non-Comparable types if we didn't supply a Comparator

		return cmp.compare(lhs, rhs);
	}

	//LEAVE IN for grading purposes. TODO, in reading the assignment, did this need to be changed?
	public Object[] toArray() {    
		Object[] ret = new Object[currentSize];
		for(int i = 0; i < currentSize; i++)
			ret[i] = array[i];
		return ret;
	}
}