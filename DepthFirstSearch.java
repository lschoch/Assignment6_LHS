/**
 * A class that performs a depth first, pre-order traversal 
 * of a binary tree.
 * 
 * @author Lawrence Schoch
 * @version 1.0
 */
public class DepthFirstSearch {       
	// Node root;
	String str = "  Node value   Height   Number of nodes\n"
			+ "  ----------   ------   ---------------\n";
	
	public DepthFirstSearch() {}
	public String DFS(Node node) {
		// depth first pre-order traversal
		if (node != null) {
			// Print the value of each node as you traverse it.
			str += String.format("     %3d         %2d           %2d\n",
					node.getData(), node.getHeight(), node.numberOfNodes());
			DFS(node.getlChild());
			DFS(node.getrChild());
		}// end if
		return str;
		
	}// end DFS

}// end class

