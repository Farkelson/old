package assignment8;

public class BadHashFunctor implements HashFunctor
{
	public int hash(String item) 
	{
		return item.length();
	}

}