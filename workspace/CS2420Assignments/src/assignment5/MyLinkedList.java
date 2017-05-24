//Scott Glass
//Jordon Phillips
package assignment5;

import java.util.NoSuchElementException;

/**
 * Represents a generic doubly linked list.
 * 
 * @author Paymon Saebi
 * @param <E>
 *            - the type of elements contained in the linked list
 */
public class MyLinkedList<E> implements List<E> {
	// Instance variables
	int size;
	Node head;
	Node tail;

	/**
	 * Constructor. Creates a blank linked list.
	 */
	public MyLinkedList() {
		size = 0;
		head = new Node(null);
		tail = new Node(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * @param element
	 *            - The element to add at the beginning of the list.
	 * 
	 *            Inserts the specified element at the beginning of the list.
	 *            O(1) for a doubly-linked list.
	 */
	public void addFirst(E element) {
		Node n = new Node(element);
		head.next.prev = n;
		n.next = head.next;
		n.prev = head;
		head.next = n;
		size++;
	}

	/**
	 * @param element
	 *            - The element to add at the end of the list.
	 * 
	 *            Inserts the specified element at the end of the list. O(1) for
	 *            a doubly-linked list.
	 */
	public void addLast(E o) {
		Node n = new Node(o);
		tail.prev.next = n;
		n.next = tail;
		n.prev = tail.prev;
		tail.prev = n;
		size++;
	}

	/**
	 * Inserts the specified element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range. O(N) for a
	 * doubly-linked list.
	 */
	public void add(int index, E element) throws IndexOutOfBoundsException {
		Node temp = new Node(null);
		Node newNode = new Node(element);
		if (index <= (size / 2)) {
			try {
				temp = head;
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
				temp.next.prev = newNode;
				newNode.next = temp.next;
				newNode.prev = temp;
				temp.next = newNode;
				size++;
			} catch (Exception IndexOutOfBoundsException) {
				System.out.print("error at add(), Index out of Bounds");
			}
		} else {
			try {
				temp = tail;
				for (int i = size - 1; i >= index; i--) {
					temp = temp.prev;
				}
				temp.next.prev = newNode;
				newNode.next = temp.next;
				newNode.prev = temp;
				temp.next = newNode;
				size++;
			} catch (Exception IndexOutOfBoundsException) {
				System.out.print("error at add(), Index out of Bounds");
			}
		}
	}

	/**
	 * Returns the first element in the list. Throws NoSuchElementException if
	 * the list is empty. O(1) for a doubly-linked list.
	 */
	public E getFirst() throws NoSuchElementException {
		E item = null;
		try {
			return head.next.data;
		} catch (Exception NoSuchElementException) {
			System.out.print("error at getFirst(), No Such Element");
		}
		return item;
	}

	/**
	 * Returns the last element in the list. Throws NoSuchElementException if
	 * the list is empty. O(1) for a doubly-linked list.
	 */
	public E getLast() throws NoSuchElementException {
		E item = null;
		try {
			return tail.prev.data;
		} catch (Exception NoSuchElementException) {
			System.out.print("error at getLast(), No Such Element");
		}
		return item;
	}

	/**
	 * Returns the element at the specified position in the list. Throws
	 * IndexOutOfBoundsException if index is out of range. O(N) for a
	 * doubly-linked list.
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		E item = null;
		Node temp = new Node(null);
		if (index <= (size / 2)) {
			try {
				temp = head;
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
				return temp.next.data;
			} catch (Exception IndexOutOfBoundsException) {
				System.out.print("error at get(), Index Out Of Bounds");
			}
		} else {
			try {
				temp = tail;
				for (int i = size - 1; i >= index; i--) {
					temp = temp.prev;
				}
				return temp.data;
			} catch (Exception IndexOutOfBoundsException) {
				System.out.print("error at get(), Index Out Of Bounds");
			}
		}
		return item;
	}

	/**
	 * Removes and returns the first element from the list. Throws
	 * NoSuchElementException if the list is empty. O(1) for a doubly-linked
	 * list.
	 */
	public E removeFirst() throws NoSuchElementException {
		try {
			E re = head.next.data;
			head.next.next.prev = head;
			head.next = head.next.next;
			size--;
			return re;
		} catch (Exception NoSuchElementException) {
			System.out.print("error at removeFirst(), No Such Element");
		}
		return null;
	}

	/**
	 * Removes and returns the last element from the list. Throws
	 * NoSuchElementException if the list is empty. O(1) for a doubly-linked
	 * list.
	 */
	public E removeLast() throws NoSuchElementException {
		try {
			E re = tail.prev.data;
			tail.prev.prev.next = tail;
			tail.prev = tail.prev.prev;
			size--;
			return re;
		} catch (Exception NoSuchElementException) {
			System.out.print("error at removeLast(), No Such Element");
		}
		return null;
	}

	/**
	 * Removes and returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range. O(N) for a
	 * doubly-linked list.
	 */
	public E remove(int index) throws IndexOutOfBoundsException {
		Node temp = new Node(null);
		try {
			if (index <= (size / 2)) {
				temp = head;
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
				E re = temp.next.data;
				temp.next.prev = temp.prev;
				temp.prev.next = temp.next;
				size--;
				return re;
			} else {
				temp = tail;
				for (int i = size - 1; i >= index; i--) {
					temp = temp.prev;
				}
				E re = temp.data;
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				size--;
				return re;
			}
		} catch (Exception NoSuchElementException) {
			System.out.print("error at remove(), Index Out Of Bounds");
		}
		return null;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in the
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * doubly-linked list.
	 */
	public int indexOf(E element) {
		Node temp = new Node(null);
		temp = head;
		for (int i = 0; i < size; i++) {
			if (temp.next.data == element) {
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * doubly-linked list.
	 */
	public int lastIndexOf(E element) {
		Node temp = new Node(null);
		temp = tail;
		for (int i = size-1; i > 0; i--) {
			if (temp.prev.data == element) {
				return i;
			}
			temp=temp.prev;
		}
		return -1;
	}

	/**
	 * Returns the number of elements in this list. O(1) for a doubly-linked
	 * list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if this collection contains no elements. O(1) for a
	 * doubly-linked list.
	 */
	public boolean isEmpty() {
		return (head.next.data == null);
	}

	/**
	 * Removes all of the elements from this list. O(1) for a doubly-linked
	 * list.
	 */
	public void clear() {
		size = 0;
		head.next = tail;
		tail.prev = head;

	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element). O(N) for a doubly-linked list.
	 */
	public Object[] toArray() {
		Object[] result = new Object[size];
		Node temp = new Node(null);
		temp = head;
		for (int i = 0; i<size;i++){
			temp = temp.next;
			result[i]=temp.data;
		}
		return result;
	}

	private class Node {
		E data;
		Node next;
		Node prev;

		public Node(E element) {
			data=element;
		}
	}
}