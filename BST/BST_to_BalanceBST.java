import java.util.*;

public class BST_to_BalanceBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int Data) {
            this.data = Data;
            this.left = this.right = null;

        }

    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;

        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;

        }
        int m = (st + end) / 2;
        Node root = new Node(inorder.get(m));
        root.left = createBST(inorder, st, m - 1);
        root.right = createBST(inorder, m + 1, end);
        return root;
    }

    public static Node balanceBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;

    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.right = new Node(12);
        root.right.left = new Node(10);

        root = balanceBST(root);
        preorder(root);

    }

}
