public class mergeSortOnLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2) {
        Node mergedll = new Node(-1);
        Node temp = mergedll;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;

            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        // now we have to returned the merged linked list head
        return mergedll.next;
    }

    public Node mergeSort(Node head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // make right head next to the mid node
        Node rHead = mid.next;
        // separate the left part from the right
        mid.next = null;

        // Recursively sort both halves
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rHead);

        // Merge newLeft and newRight
        return merge(newLeft, newRight);
    }

    public static void print() {
        if (head == null) {
            System.out.println("ll is empty");
            return;

        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        mergeSortOnLL ll = new mergeSortOnLL();

        ll.head = new Node(1);

        ll.head.next = new Node(5);
        ll.head.next.next = new Node(2);
        ll.head.next.next.next = new Node(3);
        ll.print();
        ll.mergeSort(head);
        System.out.println("after applying the mergeSort");
        ll.print();
    }

}
