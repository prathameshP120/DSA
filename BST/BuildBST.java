import java.util.ArrayList;

public class BuildBST {
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // searching a particular key in the given tree
    public static boolean search(Node root, int key) { // o(H)
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;

        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {

        if (root.data < val) {
            root.right = delete(root.right, val);

        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else { // voila(root==val)

            // Case 1--> leaf-Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2--> Single child

            if (root.left == null) {
                return root.right;

            } else if (root.right == null) {
                return root.left;
            }
            // Case 3--> Both child
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    // Print in range
    public static void PrintInrange(Node root, int k1, int k2) {
        // base case
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            PrintInrange(root.left, k1, k2);
            System.out.print(root.data + " ");
            PrintInrange(root.right, k1, k2);
        } else if (root.data <= k1) {
            PrintInrange(root.left, k1, k2);
        } else {
            PrintInrange(root.right, k1, k2);
        }
    }

    // print root to leaf path
    // public static void printPath(ArrayList<Integer> path) {
    // for (int i = 0; i <= path.size(); i++) {
    // System.out.print(path.get(i) + "->");
    // }
    // System.out.println("Null");

    // if(root==null)

    // {
    // return;
    // }path.add(root.data);if(root.left==null&&root.right==null)
    // {
    // printPath(path);
    // }

    // }

    public static void PrintRootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        PrintRootToLeaf(root.left, path);
        PrintRootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    // VALIDATE BST

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        } else if (max != null && root.data >= max.data) {

            return false;
        } else if (min != null && root.data <= min.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root, root, max);

    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);

        // For Searching a key
        System.out.println();

        /*
         * if (search(root, 1)) {
         * System.out.println("found");
         * } else {
         * System.out.println("NOt found");
         * }
         */

        // Delete a node

        // root = delete(root, 3);
        System.out.println();
        // inorder(root);

        // For print in Range
        // PrintInrange(root, 5, 12);

        // For print Root To Leaf
        // PrintRootToLeaf(root, new ArrayList<>());

        // For a validate BST
        if (isValidBST(root, null, null)) {
            System.out.println("valid");

        } else {
            System.out.println("Not valid");
        }

    }

}
