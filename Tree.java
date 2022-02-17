import java.util.Queue; // import the Queue class
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;
/**
 * A class that generates a binary tree of specified height.
 * 
 * @author Nathan Johnson, Bellarmine University
 *
 */
public class Tree {
	
	private int height;
	private Node root;
	
	/**
	 * Default constructor. Creates a tree with a single node 
	 * whose data value is 1.
	 * 
	 */
	public Tree() {
		setRoot(new Node(1));
	}// end constructor
	
	/**
	 * Gets the root node.
	 * 
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}// end getRoot
	
	/**
	 * Sets the root node.
	 * 
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}// end setRoot

	/**
	 * Method to generate a binary tree of specified height.
	 * Uses a queue to generate the tree breadth-first.
	 * 
	 * @param height The height of the tree.
	 * @return The root node data.
	 */
	public Node generatePracticeTree(int height)
	{
	   this.height=height;
	   int level=1;
	   //Creating tree breadth-first so
	   //Put the child nodes in a queue
	   Queue <Node> childQ=new LinkedList<Node>();
	   Node pn=root;
	   //Create the children of the root and put some data
	   //Put them in the child queue
	   //int value=pn.getData();
	   childQ.add(pn);
	   System.out.println ("Root Node value: "+pn.getData());
	   int value=pn.getData();
	   		   	
	   //Remove the front of the queue
	   //Create its children
	   //Put them in the queue
	   //Data is just parent data+1 or 2 depending on which child
	   while (level<(height) && !childQ.isEmpty()) {
		   System.out.println("Level is: "+level);
		   for(int i=1;i<=Math.pow(2,(level-1));i++) {
			   pn=childQ.remove();
			   System.out.println("Parent Node value: "+pn.getData());
			   value++;
			   System.out.println("Adding Left Child: "+(value));
			   pn.setlChild(new Node(value));
			   childQ.add(pn.getlChild());
			   value++;
			   System.out.println("Adding Right Child: "+(value));
			   pn.setrChild(new Node(value));
			   childQ.add(pn.getrChild());
		   }
		   level++;
		   System.out.println("Level: "+level);
	   }
	   return root;
	}// end GeneratePracticeTree
	
	public void printTree() {
		System.out.println("Preorder traverse using PreorderIterator:");
		PreorderIterator poi = new PreorderIterator();
		String str = "";
		while (poi.hasNext())
			str+= poi.next() + " ";
		System.out.println(str);
		System.out.println();
		System.out.println("Inorder traverse using InorderIterator:");
		InorderIterator ioi = new InorderIterator();
		str = "";
		while (ioi.hasNext())
			str+= ioi.next() + " ";
		System.out.println(str);
	}
	
	/**
	 * A class to create an iterator that does a preorder traverse 
	 * of the binary tree. 
	 */
	private class PreorderIterator implements Iterator<Integer> {
		private Stack<Node> nodeStack;
		private Node currentNode;
		
		/**
		 * Empty-argument constructor.
		 */
		public PreorderIterator() {
			nodeStack = new Stack<>();
			currentNode = root;
		} // end empty-argument constructor
		
		/**
		 * Method to determine whether the entire tree has been 
		 * traversed.
		 * 
		 * @return True if there are elements remaining.
		 */
		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		} // end hasNext
		
		/**
		 * Method to obtain the next element in the traverse.
		 * 
		 * @return The next element.
		 * @throws NoSuchElementException
		 */
		public Integer next() {
			Integer result = -1;
			while (currentNode != null  || !nodeStack.isEmpty()) {
				// Find leftmost node with no left child
				while (currentNode != null) {
					if (currentNode.getlChild() != null)
						nodeStack.push(currentNode);
					result = currentNode.getData();
					currentNode = currentNode.getlChild();
					return result;
				} // end while	
		
				// Got leftmost node, now move to its right subtree
				if (!nodeStack.isEmpty())
					// Assertion: nextNode != null, since nodeStack was not empty
					// before the pop
					currentNode = nodeStack.pop().getrChild();
				else
					throw new NoSuchElementException();
			}
			return result;
		} // end next
		
		/**
		 * Implementation of remove required by interface but not 
		 * supported by this iterator configuration.
		 * 
		 * @throws UnsupportedOperationException
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
		   
	} // end PreorderIterator
	
	/**
	 * A class to create an iterator that does an inorder traverse 
	 * of the binary tree. 
	 */
	private class InorderIterator implements Iterator<Integer> {
	   private Stack<Node> nodeStack;
	   private Node currentNode;
	   
	   /**
		 * Empty-argument constructor.
		 */
	   public InorderIterator()
	   {
	      nodeStack = new Stack<>();
	      currentNode = root;
	   } // end empty-argument constructor
	   
	   /**
		 * Method to determine whether the entire tree has been 
		 * traversed.
		 * 
		 * @return True if there are elements remaining.
		 */
	   public boolean hasNext() 
	   {
	      return !nodeStack.isEmpty() || (currentNode != null);
	   } // end hasNext
	   
	   /**
		 * Method to obtain the next element in the traverse.
		 * 
		 * @return The next element.
		 * @throws NoSuchElementException
		 */
	   public Integer next()
	   {
	      Node nextNode = null;

	      // Find leftmost node with no left child
	      while (currentNode != null)
	      {
	         nodeStack.push(currentNode);
	         currentNode = currentNode.getlChild();
	      } // end while

	      // Get leftmost node, then move to its right subtree
	      if (!nodeStack.isEmpty())
	      {
	         nextNode = nodeStack.pop();
	         // Assertion: nextNode != null, since nodeStack was not empty
	         // before the pop
	         currentNode = nextNode.getrChild();
	      }
	      else
	         throw new NoSuchElementException();

	      return nextNode.getData(); 
	   } // end next
	   
	   /**
		 * Implementation of remove required by interface but not 
		 * supported by this iterator configuration.
		 * 
		 * @throws UnsupportedOperationException
		 */
	   public void remove()
	   {
	      throw new UnsupportedOperationException();
	   } // end remove
	} // end InorderIterator
	
}// end class