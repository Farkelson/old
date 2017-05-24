//Scott Glass
//Jordon Phillips
package assignment3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Daniel Kopta and Paymon Saebi Implements the Collection interface
 *         using an array as storage. The array must grow as needed. All methods
 *         should be implemented as defined by the Java API, unless otherwise
 *         specified in the assignment.
 * 
 *         It is your job to fill in the missing implementations and to comment
 *         this class. Every method should have comments (Javadoc-style
 *         prefered, but not necessary). The comments should at least indicate
 *         what the method does, what the arguments mean, and what the returned
 *         value is. It should specify any special cases that the method
 *         handles. Any code that is not self-explanatory should be commented.
 * 
 * @param <E>
 *            - generic type placeholder
 */
public class CollectionArray<E> implements Collection<E> {
	E data[]; // Storage for the items in the collection
	int size; // Keep track of how many items we hold
	int cursor; // Keep track of where the iterator cursor is located

	// There is no clean way to convert between E and Object, the text book
	// discusses this.
	@SuppressWarnings("unchecked")
	public CollectionArray() {
		size = 0;
		// We can't instantiate an array of unknwon type E, so we must create an
		// Object array, and typecast
		data = (E[]) new Object[10]; // Start with an initial capacity of 10
	}

	/**
	 * This is a helper function specific to ArrayCollection Doubles the size of
	 * the data storage array, retaining its current contents.
	 */
	@SuppressWarnings("unchecked")
	private void grow() {
		E[] newArray = (E[]) new Object[size * 2];

		for (int i = 0; i < size; i++)
			newArray[i] = data[i];
		data = newArray;
	}

	// adds an element to the end of the element array, and returns a boolean
	public boolean add(E arg0) {
		if (this.size == data.length)
			this.grow();
		if (contains(arg0))
			return false;
		data[size] = arg0;
		size++;
		return true;
	}

	/*
	 * adds all of the elements within a specified collection returns a boolean
	 */
	public boolean addAll(Collection<? extends E> arg0) {
		boolean retval = false;
		for (E element : arg0) {
			if (element == null) {
				break;
			}
			retval = add(element) || retval;
		}
		return retval;
	}

	/*
	 * removes every item in the element array by changing its value to null
	 * returns void
	 */
	public void clear() {
		for (int i = 0; i < data.length; i++)
			this.data[i] = null;
		size = 0;

	}

	/*
	 * iterates through the array checking if any element in the array is equal
	 * to the specified element returns a boolean
	 */
	public boolean contains(Object arg0) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * iterates through the array, and iterates through a specified collection
	 * checking if each item has an equivalent item in the element array returns
	 * a boolean
	 */
	public boolean containsAll(Collection<?> arg0) {
		boolean retval = true;
		for (Object element : arg0) {
			retval = contains(element) && retval;
		}
		return retval;
	}

	/*
	 * iterates through the element array checking if each value is null returns
	 * a boolean
	 */
	public boolean isEmpty() {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i] != null)
				return false;
		}
		if (size != 0) {
			return false;
		}
		return true;
	}

	/*
	 * instantiates a new instance of CollectionArrayIterator so that it can be
	 * used in element arrays returns reference type CollectionArrayIterator
	 */
	public Iterator<E> iterator() {

		return new CollectionArrayIterator();
	}

	/*
	 * iterates through the element array checking if a specified object is in
	 * the array, if it is in the array the element is set to null returns a
	 * boolean
	 */
	public boolean remove(Object arg0) {
		for (int i = 0; i < this.size; i++) {
			if (data[i] == arg0) {
				data[i] = null;
				for (int j = i; j < this.size; j++)
					data[j] = data[j + 1];
				size--;
				cursor--;
				return true;
			}
		}
		return false;
	}

	/*
	 * iterates through the element array, and iterates through a specified
	 * collection checking if each element is in the array, if it is in the
	 * array that element is set to null
	 */
	public boolean removeAll(Collection<?> arg0) {
		boolean retval = false;
		for (Object element : arg0) {
			retval = remove(element) || retval;
		}
		return retval;
	}

	/*
	 * iterates through the element array, and iterates through a specified
	 * collection checking if each element is in the array, if it is not in the
	 * array that element is set to null
	 */
	public boolean retainAll(Collection<?> arg0) {
		boolean retval = false;
		for (int i = 0; i < size; i++) {
			if (!arg0.contains(data[i])) {
				retval = remove(data[i]) || retval;
				i--;
			}
		}
		return retval;
	}

	/*
	 * Returns the number of elements in the collection array
	 */
	public int size() {
		return size;
	}

	/*
	 * Returns an object array of the elements inside the collection array
	 */
	public Object[] toArray() {
		Object[] result = new Object[size];
		for (int i = 0; i < size; i++)
			result[i] = data[i];

		return result;
	}

	/*
	 * Don't implement this method (unless you want to). It must be here to
	 * complete the Collection interface. We will not test this method.
	 */
	public <T> T[] toArray(T[] arg0) {
		return null;
	}

	/*
	 * Sorting method specific to ArrayCollection - not part of the Collection
	 * interface Must implement an insertion sort (see lecture 6 for code
	 * ideas).
	 */
	public ArrayList<E> toSortedList(Comparator<? super E> cmp) {
		ArrayList<E> copy = new ArrayList<E>();
		for (int i = 0; i < size; i++)
			copy.add(data[i]);

		for (int i = 1; i < copy.size(); i++) {
			E val = copy.get(i);
			int j;
			for (j = i - 1; j >= 0 && (cmp.compare(copy.get(j), val) > 0); j--)
				copy.set(j + 1, copy.get(j));
			copy.set(j + 1, val);
		}
		return copy;
	}

	/*
	 * This class creates a CollectionArray iterator
	 */
	public class CollectionArrayIterator implements Iterator<E> {

		public CollectionArrayIterator() {
			cursor = 0;
		}

		/*
		 * Tests to see if there is an element in the next index
		 */
		public boolean hasNext() {
			try {
				next();
				cursor--;
			} catch (Exception e) {
				return false;
			}
			return true;
		}

		/*
		 * Passes the element in the next index
		 */
		public E next() {

			if (cursor > size) {
				throw new NoSuchElementException();
			}
			cursor++;
			if (data[cursor - 1] != null) {
				return data[cursor - 1];
			} else {
				throw new NoSuchElementException();
			}
		}

		/*
		 * Removes the element that was last passed by next
		 */
		public void remove() {
			if (data[cursor] != null) {
				data[cursor] = null;
				size--;
				for (int i = cursor; i < size; i++) {
					data[i] = data[i + 1];
				}

			}

		}
	}
}