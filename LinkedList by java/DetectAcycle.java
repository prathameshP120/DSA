public class DetectAcycle {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean Cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Cycle = true;
                break;
            }
        }
        if (Cycle = false) {
            return;
        }

        // finding meeting point
        Node s = head;

        Node prev = null;
        while (s != fast) {
            prev = fast;
            s = s.next;
            fast = fast.next;
        }
        prev.next = null;

    }

    public static void main(String[] args) {
        DetectAcycle ll = new DetectAcycle();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

        System.out.println(ll.isCycle());
        ll.removeCycle();

        System.out.println(ll.isCycle());
    }

}
