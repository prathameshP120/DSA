
public class SortedToBalanceBST {
    static class Node {
        int data;

        Node left;
        Node right;

        public Node(int Data) {
            this.data = Data;

        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static Node createBST(int arr[], int st, int end) {
        if (st > end) {
            return null;
        }
        int m = (st + end) / 2;
        Node root = new Node(arr[m]);
        root.left = createBST(arr, st, m - 1);
        root.right = createBST(arr, m + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = createBST(arr, 0, arr.length - 1);
        preorder(root);

    }

}
