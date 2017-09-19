package hackerrank;

public class IsThisABinarySearchTree {

	

	/*
	 * Hidden stub code will pass a root argument to the function below. Complete
	 * the function to solve the challenge. Hint: you may want to write one or more
	 * helper functions.
	 * 
	 * The Node class is defined as follows: class Node { int data; Node left; Node
	 * right; }
	 */
	boolean checkBST(Node root) {
		if (root == null)
			return true;
		
		Integer maxLeft = this.maxValue(root.left);
		Integer minRight = this.minValue(root.right);
		
		if (maxLeft!=null && root.data <= maxLeft)
			return false;
		
		if (minRight!=null && root.data >= minRight)
			return false;
		
		boolean bstLeft = checkBST(root.left);
		boolean bstRight = checkBST(root.right);
		
		return bstLeft && bstRight;
	}

	Integer maxValue(Node root) {
		if (root==null)
			return null;
		return this.maxValue1(root, null);
	}

	Integer maxValue1(Node root, Integer maxV) {
		if (root==null)
			return maxV;
		if (maxV == null || root.data >= maxV)
			maxV = root.data;
		int maxLeft = maxValue1(root.left, maxV);
		int maxRight = maxValue1(root.right, maxV);
		int temp = (maxLeft > maxRight) ? maxLeft : maxRight;
		return (temp > maxV) ? temp : maxV;
	}

	Integer minValue(Node root) {
		if (root==null)
			return null;
		return this.minValue1(root, null);
	}
	
	Integer minValue1(Node root, Integer minV) {
		if (root==null)
			return minV;
		if (minV == null || root.data <= minV)
			minV = root.data;
		int minLeft = minValue1(root.left, minV);
		int minRight = minValue1(root.right, minV);
		int temp = (minLeft < minRight) ? minLeft : minRight;
		return (temp < minV) ? temp : minV;
	}

	public static void main(String[] args) {
		Node root = new Node();
		root.data = 4;
		root.left = new Node();
		root.left.data = 2;
		root.right = new Node();
		root.right.data = 12;
		root.right.right = new Node();
		root.right.right.data = 13;
		
		root.right.left = new Node();
		root.right.left.data = 7;
		
		System.out.println(new IsThisABinarySearchTree().checkBST(root));
	}
}

class Node {
	int data;
	Node left;
	Node right;
}