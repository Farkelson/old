/**
 * Authors: Daniel Carling & Andrew Consiglio
 * 
 * Date: July 12 2013
 * 
 * Assignment: Assignment 8 - Hash Tables
 * 
 * Interface: HashFunctor
 * 
 * Description: The HashFunctor interface.
 */
package assignment8;

/**
 * Serves as a guide for how to define a functor that contains a hashing
 * function for String items (i.e., the hash method).
 * 
 * @author Paymon Saebi
 */
public interface HashFunctor 
{
	public int hash(String item);
}