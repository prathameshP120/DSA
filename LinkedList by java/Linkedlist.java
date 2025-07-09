/*public class Linkedlist {
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
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data) {

        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public static void print() {
        if (head == null) {
            System.out.println("ll is empty");
            return;

        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.println("null");

    }

    public void add(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;

        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("linkedList is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("linkedList is empty");

            return Integer.MIN_VALUE;

        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev: i=size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;

        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.print();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2, 3);
        ll.print();
        ll.removeFirst();
        ll.print();
        ll.removeLast();
        ll.print();

        ll.print();

        // Detect a cycle in a linked List
        /*
         * head = new Node(1);
         * head.next = new Node(2);
         * 
         * head.next.next = new Node(3);
         * head.next.next.next = head;
         */ // //1->2->3->1

/*
 * // Detect and remove a cycle in linked list
 * 
 * head = new Node(1);
 * Node temp = new Node(2);
 * head.next = temp;
 * head.next.next = new Node(3);
 * head.next.next.next = temp;
 * // 1->2->3->2
 * // for removing a cycle in a linked list
 * System.out.println(isCycle());
 * removeCycle();
 * System.out.println(isCycle());


}
}*/

public class Linkedlist {
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
    public static int size;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        size++;

        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public static int removeFirst() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int removeLast() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        size--;
        return val;

    }

    public static void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head = prev;

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
        Linkedlist ll = new Linkedlist();

        // add first
        ll.addFirst(0);
        // addlast
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.print();
        System.out.println();
        System.out.println(ll.size);
        ll.removeLast();

        System.out.println("after removing last ");
        ll.print();
        System.out.println();
        System.out.println(ll.size);
        ll.reverse();
        ll.print();

    }
}
