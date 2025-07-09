public class kthAncestor_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;

        }

    }

    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;

        }
        int leftAns = kthAncestor(root.left, n, k);
        int rightAns = kthAncestor(root.right, n, k);
        if (leftAns == -1 && rightAns == -1) {
            return -1;
        }
        int max = Math.max(leftAns, rightAns);
        if ((max + 1) == k) {
            return root.data;
        }
        return max + 1;

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int ans = kthAncestor(root, 5, 2);
        System.out.println(ans);

    }
}
