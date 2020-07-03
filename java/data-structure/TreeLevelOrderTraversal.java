package com.geekwise.hackerrank.solutions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

class TreeLevelOrderTraversal {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	
	static class NodeLevel implements Comparable<NodeLevel>{
		int data;
		int level;
		int side;//0 ->root, 1->left, 2->right
		
		public NodeLevel(int data, int level, int side) {
			this.data = data;
			this.level = level;
		}

		@Override
		public int compareTo(NodeLevel o) {
			if(o.level < this.level) return 1;
			else if(o.level > this.level) return -1;
			else if(o.side < this.side) return -1;
			else if(o.side > this.side)return 1;
			return 0;
		}
	}
	public static void levelOrder(Node root) {
		List<NodeLevel> list = new ArrayList<>();
		if(root == null) return;
		
		buildList(root, 0, list,0);
		Collections.sort(list);
		
		for(NodeLevel node: list)
			System.out.print(node.data+" ");
    }

	private static void buildList(Node root, int i, List<NodeLevel> list, int side) {
		if(root == null) return;
		list.add(new NodeLevel(root.data, i,side));
		
		buildList(root.left, i+1, list,1);
		buildList(root.right, i+1, list,2);
	}

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}