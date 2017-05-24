package ceiling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.tree.TreeModel;

import ceiling.BinarySearchTree.BinaryNode;

public class Ceiling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String[] numADepth = input.split(" ");
		int numTrees = Integer.parseInt(numADepth[0]);
		int treeDepth = Integer.parseInt(numADepth[1]);
		
		ArrayList<BinarySearchTree<Integer>> solutions = new ArrayList<BinarySearchTree<Integer>>();
		
		ArrayList<BinarySearchTree<Integer>> trees = new ArrayList<BinarySearchTree<Integer>>();
		for(int i = 0; i < numTrees; i++){
			input = scanner.nextLine();
			String[] treeString = input.split(" ");
			BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
			for(int j = 0; j<treeString.length; j++){
				newTree.add(Integer.parseInt(treeString[j]));
			}
			trees.add(newTree);
		}
		for (int i = 0; i < trees.size(); i++){
			BinaryNode firstTree = trees.get(i).getRoot();
			if(solutions.size() == 0){
				solutions.add(trees.get(i));
				continue;
			}
			for(int j = 0; j < solutions.size(); j++){
				BinaryNode secondTree = solutions.get(j).getRoot();
				if(!firstTree.isSameTree(secondTree)){
					solutions.add(trees.get(i));
				}
				else{
//					solutions.remove(j);
				}
			}
		}
		
		System.out.println(solutions.size());

	}

}
