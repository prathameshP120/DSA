import java.util.*;

// public class CheckisPallindrome {
//     public static class Node {
//         int data;
//         Node next;

//         public Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     public static Node head;
//     public static Node tail;

//     public static void print() {
//         Node temp = head;
//         while (temp != null) {
//             System.out.print(temp.data + "->");
//             temp = temp.next;
//         }
//         System.out.println("null");
//     }

//     public Node findMid(Node head) {
//         Node slow = head;
//         Node fast = head;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;

//     }

//     public boolean CheckPallindrome() {
//         if (head == null || head.next == null) {
//             return true;
//         }
//         Node midNode = findMid(head);
//         Node prev = null;
//         Node curr = midNode;
//         Node next;
//         while (curr != null) {
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         Node right = prev;
//         Node left = head;
//         while (right != null) {
//             if (left.data != right.data) {
//                 return false;
//             }
//             left = left.next;
//             right = right.next;
//         }
//         return true;
//     }
public class CheckisPallindrome {
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

    public Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public boolean CheckisPallindrome(Node head) {
        // base case
        if (head == null || head.next == null) {
            return true;

        }
        // find midNode in ll and reverse the second part
        Node mid = findMidNode(head);
        // we have reverse the second part of the linked list
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node rHead = prev;
        Node lHead = head;
        while (rHead != null) {
            if (rHead.data != lHead.data) {
                return false;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }
        return true;

    }

    public static void main(String[] args) {
        CheckisPallindrome ll = new CheckisPallindrome();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(2);
        ll.head.next.next.next = new Node(1);
        ll.print();
        boolean ans = ll.CheckisPallindrome(head);
        System.out.println(ans);

    }

}
