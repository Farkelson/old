package assignment8;

import java.util.LinkedList;

public class ChainingHashTable extends HashTable {

	HashFunctor _functor;
	int totalCollisions;
	private LinkedList<String>[] storage;

	@SuppressWarnings("unchecked")
	public ChainingHashTable(int capacity, HashFunctor functor) {

		this._functor = functor;
		totalCollisions = 0;
		storage = (LinkedList<String>[]) new LinkedList[capacity];
		for (int i = 0; i < capacity; i++){
			storage[i] = new LinkedList<String>();
		}
	}

	public boolean add(String item) {
		int hashcode = _functor.hash(item);

		int index = Math.abs(hashcode % storage.length);		
		if(!storage[index].isEmpty()){
			totalCollisions++;
		}
		return storage[index].add(item);
	}

		public void clear()
		{
			for(int i = 0; i < storage.length; i++)
			{
				if(storage[i] != null){
					storage[i] = new LinkedList<String>();
				}
			}
	}

		public boolean contains(String item) 
		{
			boolean retVal = false;
			int hashcode = _functor.hash(item);
			
			int index = Math.abs(hashcode % storage.length);
			if(storage[index]==null){
				return false;
			}
			if(storage[index].contains(item)){
				retVal = true;
			}
			return retVal;
		}
}
