import java.util.HashMap;
import java.util.Map;

// Define TreeNode class
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
    left = null;
    right = null;
  }
}

// Main class
public class BinaryTreeFromPreorderInOrderTraversal {

  // Method to build tree from preorder and inorder arrays
  TreeNode buildTree(int[] preOrder, int[] inOrder) {
    // Create a map to store the index of each value in inorder array
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++)
      inOrderIndexMap.put(inOrder[i], i);

    // Call the recursive function to build the tree
    return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
  }

  // Recursive method to split the tree
  private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
      int rootIndex, int left, int right) {

    // Create the root node with the current rootIndex from preorder array
    TreeNode root = new TreeNode(preOrder[rootIndex]);

    // Get the index of the root in the inorder array
    int mid = inOrderIndexMap.get(preOrder[rootIndex]);

    // Recursively create the left subtree
    if (mid > left)
      root.left = splitTree(preOrder, inOrderIndexMap,
          rootIndex + 1, left, mid - 1);

    // Recursively create the right subtree
    if (mid < right)
      root.right = splitTree(preOrder, inOrderIndexMap,
          rootIndex + mid - left + 1, mid + 1, right);

    // Return the root node of the subtree
    return root;
  }

  // Main method to test the tree construction
  public static void main(String[] args) {
    // Example arrays
    int[] preOrder = { 3, 9, 20, 15, 7 };
    int[] inOrder = { 9, 3, 15, 20, 7 };

    // Create an instance of the class and build the tree
    BinaryTreeFromPreorderInOrderTraversal solution = new BinaryTreeFromPreorderInOrderTraversal();
    TreeNode root = solution.buildTree(preOrder, inOrder);

    // Print the tree in inorder to verify (Should match the inOrder array)
    printInOrder(root);
  }

  // Helper method to print the tree in inorder
  public static void printInOrder(TreeNode root) {
    if (root != null) {
      printInOrder(root.left);
      System.out.print(root.val + " ");
      printInOrder(root.right);
    }
  }
}
