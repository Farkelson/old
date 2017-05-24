/**
 * Authors: Jordan Phillips & Scott Glass
 * 
 * Date: July 12 2013
 * 
 * Assignment: Assignment 8 - Hash Tables
 * 
 * Class: HashTable
 * 
 * Description: The HashTable class the parent class for the QuadProbeHashTable and ChainingHashTable classes.  All of the 
 * 				methods in this class will be implemented in its children classes.
 */
package assignment8;

import java.util.*;

/**
 * An abstract class facilitating the implementation of a concrete hash table. 
 * @author Paymon Saebi & ??
 *
 */
public abstract class HashTable implements Set<String> 
{
	/**
	 * FILL IN MEMBER VARIABLES!
	 * 
	 * Any member variables that you would maintain in both your QuadProbeHashTable and
	 * your ChainingHashTable (such as, say, a size variable) probably belong here in
	 * the parent class. Should the variable(s) be public, private, or protected?
	 */
	protected int size = 0;
	
	/**
	 * Returns true if an item is added to the hashTable when this method is called.
	 */
	public final boolean addAll(Collection<? extends String> items) 
	{
		boolean returnValue = false;
		for(String o : items)
		{

			if(!this.contains(o))
			{
				this.add(o);
				returnValue = true;				
			}
		}
		return returnValue;
	}
	
	public static int getNextPrime(int primeN)
	{
		 if(primeN <= 0)
			 primeN = 3;
	     if(primeN % 2 == 0)
	         primeN++;
	     for(; !isPrime(primeN); primeN += 2)
	           ;

	     return primeN;
	}
	
	private static boolean isPrime(int primeN)
	{
		if(primeN == 2 || primeN == 3)
			return true;
		if(primeN == 1 || primeN % 2 == 0)
			return false;
		for(int i = 3; i * i <= primeN; i +=2)
			if(primeN % i == 0)
				return false;
		return true;
	}

	/**
	 * Checks to see if an item is contained in a HashTable, if not returns false.
	 */
	public final boolean containsAll(Collection<? extends String> items) 
	{
		boolean returnValue = true;
		
		for(String o : items)
		{
			
			if(!this.contains(o))
			{
				returnValue = false;
			}		
			
		}
		return returnValue;
	}

	/**
	 * Checks whether a HashTable is empty, if so returns true.
	 */
	public final boolean isEmpty() 
	{
		if(size == 0)
			return true;
		return false;
	}

	/**
	 * Returns the size of the HashTable.
	 */
	public final int size() 
	{
		return size;
	}
}