import java.util.ArrayList;

public class MinDist {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;

        }

    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;

    }

    public static Node getLca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n1, path1);

        int i = 0;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }

        }

        Node lca = path1.get(i - 1);

        return lca;

    }

    // public static int LcaDist(Node root, int n) {
    // if (root == null) {
    // return -1;
    // }
    // if (root.data == n) {
    // return 0;
    // }

    // int leftDist = LcaDist(root.left, n);
    // int rightDist = LcaDist(root.right, n);

    // if (leftDist == -1 && rightDist == -1) {
    // return -1;
    // } else if (leftDist == -1) {
    // return rightDist + 1;

    // } else {
    // return leftDist + 1;

    // }

    // }
    public static int LcaDist(Node root, int n) {
        if (root == null) {
            return -1;

        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = LcaDist(root.left, n);
        int rightDist = LcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }

    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = getLca(root, n1, n2);
        int lcadist1 = LcaDist(lca, n1);
        int lcadist2 = LcaDist(lca, n2);

        return lcadist1 + lcadist2;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        System.out.println(minDist(root, 5, 6));

    }

}
