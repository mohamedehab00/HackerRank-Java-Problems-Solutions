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

    public static void lcaUtil(Node root, int v1, List<Node> road) {
        if (root.data == v1) {
            road.add(root);
            return;
        } else {
            road.add(root);
            if (root.data < v1) {
                lcaUtil(root.right, v1, road);
            } else {
                lcaUtil(root.left, v1, road);
            }
        }
    }

    public static Node lca(Node root, int v1, int v2) {
        List<Node> roadV1 = new ArrayList<>();
        lcaUtil(root, v1, roadV1);
        List<Node> roadV2 = new ArrayList<>();
        lcaUtil(root, v2, roadV2);

        Node lowestNode = null;

        for (Node node : roadV1) {
            if (roadV2.contains(node)) {

                lowestNode = node;

            }
        }

        return lowestNode;
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}