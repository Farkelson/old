/**
 * Authors: Jordan Phillips & Scott Glass
 * 
 * Date: July 12 2013
 * 
 * Assignment: Assignment 8 - Hash Tables
 * 
 * Class: QuadProbeHashTable
 * 
 * Description: The QuadProbeHashTable class is a child class for the HashTable class.  All of the 
 * 				methods in this class will be implemented from its parent class.
 */
package assignment8;

public class QuadProbeHashTable extends HashTable
{
	String[] storage;
	HashFunctor _functor;
	int totalCollisions;
	double lambda;
	
	public QuadProbeHashTable(int capacity, HashFunctor functor)
	{
		storage = new String[capacity];
		this._functor = functor;
		totalCollisions = 0;
		lambda = 0;
	}

	public boolean add(String item) 
	{
		int A = 0;
		int hashcode = _functor.hash(item);
		
		// Need to use absolute value here.
		// Negative hash codes are perfectly valid
		int first = Math.abs(hashcode % storage.length);
		
		// Loop until we find an empty spot
			
			while(true)
			{
				
				int index = (int) ((first + Math.pow(A, 2)) % storage.length);
				
				if(storage[index] == null)
				{
					storage[index] = item;
					size++;
					lambda = (double)this.size() / (double)storage.length;
					if(lambda >= .5)
						rehash();					
					break;
				}
				// Count collisions
				totalCollisions++;
				A++;
			}
			
		return true;
	}
	
	public void rehash(){
		size = 0;
		totalCollisions = 0;
		String[] temp = new String[storage.length];
		for(int i = 0; i < storage.length; i++)
		{
			if(storage[i] != null)
				temp[i] = storage[i];						
		}
		storage = new String[getNextPrime(storage.length + 1)];
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i] != null){
				add(temp[i]);
			}
		}
	}

	public void clear()
	{
		for(int i = 0; i < storage.length; i++)
		{
			storage[i] = null;
		}
		size = 0;
		totalCollisions = 0;
	}

	@Override
	public boolean contains(String item) 
	{
		int A = 0;
		int hashcode = _functor.hash(item);
		int first = Math.abs(hashcode % storage.length);
		boolean Retval = false;
		
		while(Retval == false)
		{
			
			int index = (int) ((first + Math.pow(A, 2)) % storage.length);
			
			if(storage[index] != null)
			{
				if(storage[index].equals(item))
					Retval = true;
			}
			else{
				break;
			}		
			A++;
		}
		return Retval;
	}	
	
	public static void main(String[] args)
	{
		BadHashFunctor H = new BadHashFunctor();
		QuadProbeHashTable quadT = new QuadProbeHashTable(11, H);
		System.out.println(quadT.storage.length);
		
		quadT.add("baby");
		quadT.add("caby");
		quadT.add("maby");
		quadT.add("raby");
		quadT.add("o");
		quadT.add("pot");
		System.out.println(quadT.lambda);
		System.out.println(quadT.storage.length);
		System.out.println(quadT.lambda);
		String t = "";
		t = t + 26 + 27;
		System.out.println(t);
	}

}