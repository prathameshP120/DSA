public class HeightOfTree {
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

    public static int count(Node root) {
        if (root == null) {
            return 0;

        }
        int lcnt = count(root.left);
        int rcnt = count(root.right);
        return (lcnt + rcnt) + 1;

    }

    static int height(Node root) {
        if (root == null) {
            return 0;

        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int lsum = sum(root.left);
        int rsum = sum(root.right);
        return (lsum + rsum) + root.data;

    }

    /*
     * public static int diameter(Node root) { //O(n^2)
     * if (root == null) {
     * return 0;
     * }
     * int ld = diameter(root.left);
     * int lh = height(root.left);
     * int rd = diameter(root.right);
     * int rh = height(root.right);
     * 
     * int selfDiam = lh + rh + 1;
     * 
     * 
     * 
     * }
     */
    // Calculating the diameter with O(n)
    // static class Info {
    // int dm;
    // int ht;

    // public Info(int diam, int height) {
    // this.dm = diam;
    // this.ht = height;
    // }
    // }

    // public static Info diameter(Node root) {
    // if (root == null) {
    // return new Info(0, 0);

    // }
    // Info leftInfo = diameter(root.left);
    // Info rightInfo = diameter(root.right);

    // int diam = Math.max((Math.max(leftInfo.dm, rightInfo.dm)), leftInfo.ht +
    // rightInfo.ht + 1);
    // int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

    // return new Info(diam, height);

    // }
    static class Info {
        int ht;
        int dia;

        public Info(int height, int diameter) {
            this.ht = height;
            this.dia = diameter;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int diameter = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
        int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diameter, height);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.left.right.left = new Node(9);
        Info dia = (diameter(root));
        System.out.println(dia.dia);

    }

}
