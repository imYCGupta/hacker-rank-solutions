import java.util.*;
import java.io.*;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Solution {

	/*
	 * you only have to complete the function given below. Node is defined as
	 * 
	 * class Node { int data; Node left; Node right; }
	 * 
	 */

	/*
	 * process left tree
	 * process root
	 * process right tree
	 */
	public static void postOrder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		
		while(!stack.isEmpty() || root!=null) {
			if(root!=null) {
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				System.out.print(root.data+" ");
				root = root.right;
			}
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		postOrder(root);
	}
}