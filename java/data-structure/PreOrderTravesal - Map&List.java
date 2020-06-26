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

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/
/*1. print root
2. Check for left, if exist, go to left side and store the parent and go to point 1
3. check for right, if exist, go to right side and store the parent and go to point 1
4. if both side not exist then check for parent and go to point 1

*/
    public static void preOrder(Node root) {
        Map<Node, Node> childParentMap = new HashMap<>();
        List<Node> processedNode = new ArrayList<>();
        while(root!=null){
            System.out.print(root.data+" ");            
            if(root.left!=null){
                childParentMap.put(root.left, root);
                root = root.left;
            }else if(root.right !=null){
                root = processRightSide(root, childParentMap, processedNode);                
            }else{
                root = findParent(root, childParentMap, processedNode);
            }
        }
    }

    private static Node findParent(Node root, Map<Node, Node> childParentMap, List<Node> processedNode) {
        root = childParentMap.get(root);
        while(root!=null && processedNode.contains(root)){
            root = childParentMap.get(root);
        }
        if(root!=null && root.right!=null)
            root = processRightSide(root, childParentMap, processedNode);
        else if(root!=null){
            processedNode.add(root);
            root = findParent(root, childParentMap, processedNode);
        }
        return root;
    }

    private static Node processRightSide(Node root, Map<Node, Node> childParentMap, List<Node> processedNode) {
        childParentMap.put(root.right, root);
        processedNode.add(root);
        root = root.right;
        return root;
    }

	public static Node insert(Node root, int data) {