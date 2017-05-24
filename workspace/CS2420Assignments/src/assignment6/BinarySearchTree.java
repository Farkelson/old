//Scott Glass
//Jorden Phillips
package assignment6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>{
	
	private int size = 0;
	private BinaryNode root;;
	
	private class BinaryNode 
	{
		// Since the outer BST class declares <Type>, we can use it here without redeclaring it for BinaryNode
		Type data;

		BinaryNode left;

		BinaryNode right;

		// Adding a parent reference breaks the definition of a tree,
		// but some people find it makes BST management easier.
		// If you choose to use them, remember to update parent pointers
		// when adding/removing nodes!
		BinaryNode parent;

		/**
		 * Construct a new node with known children
		 * 
		 */
		public BinaryNode(Type _data, BinaryNode _left, BinaryNode _right) 
		{
			data = _data;
			left = _left;
			right = _right;
		}

		/**
		 * Construct a new node with no children
		 * 
		 */
		public BinaryNode(Type _data) 
		{
			this(_data, null, null);
		}

		/**
		 * Construct a new node with a known parent
		 * 
		 */
		public BinaryNode(Type _data, BinaryNode _parent)
		{
			this(_data, null, null);
			parent = _parent;
		}

		/**
		 * Getter method.
		 * 
		 * @return the node data.
		 */
		public Type getData() 
		{
			return data;
		}

		/**
		 * Setter method.
		 * 
		 * @param _data
		 *          - the node data to be set.
		 */
		public void setData(Type _data) 
		{
			data = _data;
		}

		/**
		 * Getter method.
		 * 
		 * @return the left child node.
		 */
		public BinaryNode getLeft() 
		{
			return left;
		}

		/**
		 * Setter method.
		 * 
		 * @param _left
		 *          - the left child node to be set.
		 */
		public void setLeft(BinaryNode _left) 
		{
			left = _left;
		}

		/**
		 * Getter method.
		 * 
		 * @return the right child node.
		 */
		public BinaryNode getRight() 
		{
			return right;
		}

		/**
		 * Setter method.
		 * 
		 * @param _right
		 *          - the right child node to be set.
		 */
		public void setRight(BinaryNode _right) 
		{
			right = _right;
		}

		/**
		 * Getter method.
		 * 
		 * @return the parent of this node.
		 */
		public BinaryNode getParent()
		{
			return parent;
		}

		/**
		 * Setter method.
		 * 
		 * @param _parent
		 *          - the parent node to be set.
		 */
		public void setParent(BinaryNode _parent)
		{
			parent = _parent;
		}

		/**
		 * Number of children
		 * Use this to help figure out which BST deletion case to perform
		 * 
		 * @return The number of children of this node
		 */
		public int numChildren()
		{
			int numChildren = 0;
			
			if(getLeft() != null)
				numChildren++;
			if(getRight() != null)
				numChildren++;
			
			return numChildren;
		}

		/**
		 * @return The leftmost node in the binary tree rooted at this node.
		 */
		public BinaryNode getLeftmostNode() 
		{
			// Base case, done for you
			if(getLeft() == null)
				return this; // returns "this" node
			else{
				this.getLeft();
				this.getLeftmostNode();
			}			
			return null;
		}

		/**
		 * @return The rightmost node in the binary tree rooted at this node.
		 */
		public BinaryNode getRightmostNode() 
		{
			// Base case, done for you
			if(getRight() == null)
				return this; // returns "this" node
			else{
				this.getRight();
				this.getRightmostNode();
			}
			return null;
		}		

		/** 
		 * This method applies to binary search trees only (not general binary trees).
		 * 
		 * @return The successor of this node.
		 *  
		 * The successor is a node which can replace this node in a case-3 BST deletion.
		 * It is either the smallest node in the right subtree,
		 * or the largest node in the left subtree.
		 */
		public BinaryNode getSuccessor() 
		{
			if(getRight()==null){
				return getLeft();
			}
			return getRight().getLeftmostNode();
		}
		
		/**
		 * @return The height of the binary tree rooted at this node. The height of a
		 * tree is the length of the longest path to a leaf node. Consider a tree with
		 * a single node to have a height of zero.
		 *  
		 * The height of a tree with more than one node is the greater of its two subtrees'
		 * heights, plus 1
		 */
		public int height() 
		{
			int left = 0;
			int right = 0;
			if(getRight()!=null){
				right = getRight().height() +1;
			}
			else if(getLeft()!=null){
				left = getLeft().height() +1;
			}
			return Math.max(left, right);
		}
	}

	//driver method to add
	public boolean add(Type item){
		
		if(item == null)
			throw new NullPointerException();
		
		if(isEmpty()){
			root = new BinaryNode(item);
			size++;
			return true;
		}
		else {
			return adding(root, item);
		}
	}
	
	//actually adds the item to the Binary Search Tree
	private boolean adding(BinaryNode node, Type thingy){
		
		if(node.getLeft()!=null){
			if(node.getLeft().getData() == thingy){
				return false;
			}
		}
		if(node.getRight()!=null){
			if(node.getRight().getData() == thingy){
				return false;
			}
		}
		
		if (node.getData().compareTo(thingy) > 0) {
			if (node.getLeft() == null) {
				node.setLeft(new BinaryNode(thingy));
				size++;
				return true;
			} else {
				this.adding(node.getLeft(), thingy);
			}

		} else if (node.getData().compareTo(thingy) < 0) {
			if (node.getRight() == null) {
				node.setRight(new BinaryNode(thingy));
				size++;
				return true;
			} else {
				this.adding(node.getRight(), thingy);
			}
		} else {
			node.setData(thingy);
			size++;
			return true;
		}
		return false;
	}

	public boolean addAll(Collection<? extends Type> items) {
		for(Type t : items)
		{
			add(t);
		}
		return false;
	}

	//sets size to 0 and creates a new tree
	public void clear() {
		size = 0;
		root = null;
	}

	//driver method
	public boolean contains(Type item) {		
		BinaryNode dummy = new BinaryNode(item);
		return containing(dummy, item);
		}	
	
	//method that finds if the item is contained in the tree
	private boolean containing(BinaryNode node,Type thingy){
		
		if(node.getLeft() == thingy || node.getRight() == thingy)
			return true;
		
		if(node.getData().compareTo(thingy)<0){
			if(node.getLeft() == null){
				return false;
			}
			else{
				this.containing(node.getLeft(), thingy);
			}
			
		}
		else if(node.getData().compareTo(thingy)>0){
			if(node.getRight() == null){
				return false;
			}
			else{
				this.containing(node.getRight(), thingy);
			}
		}
		else if(node.getData().compareTo(thingy)==0)
			return true;
			
		return false;
	}

	public boolean containsAll(Collection<? extends Type> items) {
		for(Type t : items)
		{
			contains(t);
		}
		return false;
	}

	public Type first() throws NoSuchElementException {
		
		if(this.isEmpty())
			throw new NoSuchElementException();
		
		return root.getLeftmostNode().getData();
	}

	public boolean isEmpty() {
		
		if(root == null)
			return true;
		return false;
	}

	@Override
	public Type last() throws NoSuchElementException {
		
		if(this.isEmpty())
			throw new NoSuchElementException();
		
		return this.root.getRightmostNode().data;
	}
	
	private BinaryNode search(Type target) throws NoSuchElementException{
		
		if(!contains(target)){
			throw new NoSuchElementException();
		}
		BinaryNode dummy = new BinaryNode(target);
		return searching(dummy, target);
	}
		
	private BinaryNode searching (BinaryNode result, Type target){		
		if (result.getLeft().getData() == target) {
			result = result.getLeft();
		}
		if (result.getRight().getData() == target) {
			result = result.getRight();
		}
		if(result.getData().compareTo(target)>0){
				result = searching(result.getLeft(), target);
		}
		else if(result.getData().compareTo(target)<0){
				result = searching(result.getRight(), target);
		}
		return result;
	}

	public boolean remove(Type item){
		if (isEmpty()){
			return false;
		}
		if(size==1){
			root=null;
			size--;
			return true;
		}
		Type storage;
		storage = search(item).getSuccessor().getData();
		if (search(item).getSuccessor().numChildren()==0){
			search(item).getSuccessor().parent.setLeft(null);
			search(item).setData(storage);
			size--;
			return true;
		}
		if (search(item).getSuccessor().numChildren()==1){
			search(item).getSuccessor().parent.setLeft(search(item).getSuccessor().getRight());
			search(item).setData(storage);
			size--;
			return true;
		}
		if(search(item).getSuccessor().numChildren() == 2){
			search(item).parent.setLeft(search(item).getSuccessor());
			search(item).setData(storage);
			size--;
			return true;
		}
		return false;		
	}

	public boolean removeAll(Collection<? extends Type> items) {
		for(Type t : items)
		{
			remove(t);
		}
		return false;
	}

	public int size() {
		return size;
	}


	public ArrayList<Type> toArrayList() {
		
		return null;
	}	
}