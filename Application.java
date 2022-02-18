/**
 * A driver class that generates a binary tree of specified height, or
 * defaults to height of 5 if height is not specified. Outputs data from 
 * a depth first in order traversal of the tree. 
 * 
 * @author Nathan Johnson, Bellarmine University
 * @author Lawrence Schoch
 * @version 1.0
 */
public class Application {
	/**
	 * Main class, optional specification of the height of the tree 
	 * as first parameter.
	 * 
	 * @param args Tree Height
	 */
	public static void main(String[] args) {
		int height = 5;
		if (args.length > 0)
			height = Integer.parseInt(args[0]);
		System.out.println("Creating a tree of height " + height + ".");
		Tree aTree = new Tree(); // Creates a tree with a single node of value 1.
		Node root = aTree.generatePracticeTree(height); // root of practice tree
		DepthFirstSearch aSearch = new DepthFirstSearch();
		System.out.println("------------------------------------------------------------");
		System.out.println("Call DFS with root node to do a Depth First Preorder Search.");
		System.out.println(aSearch.DFS(root));
		aTree.printTraverses();
	}// end main

}// end class