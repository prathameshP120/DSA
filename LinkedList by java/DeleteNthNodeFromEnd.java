// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;

public class DeleteNthNodeFromEnd {
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

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public static void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public static void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("ll is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void deleteNthNodeFromEnd(int n) {
        Node prev = head;
        int sz = 0;

        while (prev != null) {
            prev = prev.next;
            sz++;
        }
        System.out.println(sz);
        if (n == sz) {
            head = head.next;
            return;
        }

        Node temp = head;
        int i = 1;
        int itoFind = sz - n; // Nth Node from the start=size-n+1
        while (i < itoFind) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return;

    }

    public static void main(String[] args) {

        DeleteNthNodeFromEnd ll = new DeleteNthNodeFromEnd();

        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.deleteNthNodeFromEnd(3);
        ll.print();

    }

}