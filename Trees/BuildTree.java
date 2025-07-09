import java.util.*;

public class BuildTree {
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

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            // Build Tree Preorder
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        System.out.println(root.data);

    }

}

/*
 * Instantiation:
 * 
 * BinaryTree tree declares a variable tree of type BinaryTree.
 * new BinaryTree() creates an instance (object) of the BinaryTree class and
 * assigns it to the variable tree.
 * This demonstrates the process of creating objects from a class, which is a
 * core principle of OOP.
 * Encapsulation:
 * 
 * The BinaryTree class encapsulates data (like the idx variable) and methods
 * (like buildTree()) related to building and handling the binary tree
 * structure.
 * These are bundled together to allow controlled access via objects.
 * 
 */