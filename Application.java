/**
 * A driver class that generates a binary tree of specified height,
 * or defaults to height of 5 if height is not specified and then
 * outputs data from a depth-first in order traversal of the tree. 
 * 
 * @author Nathan Johnson, Bellarmine University
 * @author Lawrence Schoch
 * @version 1.1
 */
public class Application {
	/**
	 * Main class, specification of the height of the tree to be 
	 * generated is optional.
	 * @param args Tree Height
	 */
	public static void main(String[] args) {
		int height = 5;
		if (args.length > 0)
			height = Integer.parseInt(args[0]);
		System.out.println("Creating a tree of height " + height + ".");
		Tree aTree = new Tree();//Creates a tree with root
		Node root = aTree.generatePracticeTree(height);
		DepthFirstSearch aSearch = new DepthFirstSearch();
		System.out.println(aSearch.DFS(root));
	}// end main

}// end class