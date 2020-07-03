import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*ref
https://www.techiedelight.com/print-top-view-binary-tree/*/
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

public class TreeTopView {

	static class Pair<U, V> {
		public final U first; // first field of a Pair
		public final V second; // second field of a Pair

		// Constructs a new Pair with specified values
		private Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}

		// Factory method for creating a Typed Pair immutable instance
		public static <U, V> Pair<U, V> of(U a, V b) {
			// calls private constructor
			return new Pair<>(a, b);
		}
	}

	// Recursive function to do a pre-order traversal of the tree and fill the map
	// Here node has 'dist' horizontal distance from the root of the
	// tree and level represent level of the node
	public static void printTop(Node root, int dist, int level, Map<Integer, Pair<Integer, Integer>> map) {
		// base case: empty tree
		if (root == null) {
			return;
		}
		// if current level is less than maximum level seen so far
		// for the same horizontal distance or horizontal distance
		// is seen for the first time, update the map
		if (!map.containsKey(dist) || level < map.get(dist).second) {
			// update value and level for current distance
			map.put(dist, Pair.of(root.data, level));
		}

		// recur for left subtree by decreasing horizontal distance and
		// increasing level by 1
		printTop(root.left, dist - 1, level + 1, map);

		// recur for right subtree by increasing both level and
		// horizontal distance by 1
		printTop(root.right, dist + 1, level + 1, map);
	}

	// Function to print the top view of given binary tree
	public static void topView(Node root) {
		// create a TreeMap where
		// key -> relative horizontal distance of the node from root node and
		// value -> pair containing node's value and its level
		Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

		// do pre-order traversal of the tree and fill the map
		printTop(root, 0, 0, map);

		// traverse the TreeMap and print top view
		for (Pair<Integer, Integer> it : map.values()) {
			System.out.print(it.first + " ");
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
		topView(root);
	}
}
