/**
 * A class to define a node in a binary tree.
 * 
 * @author Nathan Johnson, Bellarmine University
 * @author Lawrence Schoch
 * @version 1.0
 */
public class Node {
	private int data;
	private Node lChild;
	private Node rChild;
	
	/**
	 * Constructor
	 * 
	 * @param data The data for this node.
	 */
	public Node(int data) {
		lChild=null;
		rChild=null;
		this.data=data;
	}// end constructor
	
	/**
	 * Returns height of the tree rooted at this node. Uses private
	 * helper method to hide this node from client.
	 * 
	 * @return the height
	 */
	public int getHeight() {
		int height = 1;
		if (this.lChild != null && this.rChild != null) 
			return 1 + Math.max(this.lChild.getHeight(), 
				this.rChild.getHeight());
		else if (this.rChild != null)
			return 1 + this.rChild.getHeight();
		else if (this.lChild != null)
			return 1 + this.lChild.getHeight();
		else
			return height;
	}
	
	/**
	 * Private helper method to hide this node from client. 
	 * Returns height of tree rooted at this node.
	 * 
	 * @param data The root of this node.
	 */
//	private int getHeight(Node data) {
//		int height = 0;
//		if (data != null) {
//			height = 1 + Math.max(this.lChild.getHeight(), 
//					this.rChild.getHeight());
//		}
//		return height;
//	}// end getHeight
	
	/**
	 * Calculates the number of nodes in the tree rooted at this node. 
	 * 
	 * @return The number of nodes.
	 */
	public int numberOfNodes() {
		int lNumber = 0;
		int rNumber = 0;
		if (this.getlChild() != null)
			lNumber = this.getlChild().numberOfNodes();
		if (this.getrChild() != null)
			rNumber = this.getrChild().numberOfNodes();
		return 1 + lNumber + rNumber;
	}// end numberOfNodes
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}// end getData
	
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}// end setData
	
	/**
	 * @return the lChild
	 */
	public Node getlChild() {
		return lChild;
	}// end getlChild
	
	/**
	 * @param lChild the lChild to set
	 */
	public void setlChild(Node lChild) {
		this.lChild = lChild;
	}// end setlChild
	
	/**
	 * @return the rChild
	 */
	public Node getrChild() {
		return rChild;
	}// end getrChild
	
	/**
	 * @param rChild the rChild to set
	 */
	public void setrChild(Node rChild) {
		this.rChild = rChild;
	}// end setrChild
	
	/**
	 * Generates a string that lists this object's fields.
	 * @return The string
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + ", lChild=" + lChild + ", rChild=" 
				+ rChild + "]";
	}// end toString
	
	
	
}// end class