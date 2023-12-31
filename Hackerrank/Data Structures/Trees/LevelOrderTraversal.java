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
	public static void levelOrder(Node root) {
        Queue<Node> nodes = new ArrayDeque<>();
        if (root == null){
            return;
        }
        
        nodes.add(root);
        
        while (!nodes.isEmpty()){
            Node currNode = nodes.poll();
            
            if (currNode.left != null){
                nodes.add(currNode.left);
            }
            
            if (currNode.right != null){
                nodes.add(currNode.right);
            }

            System.out.print(currNode.data+" ");
        }
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