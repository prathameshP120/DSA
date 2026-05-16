import org.w3c.dom.Node;

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


    //add the node to the particular index=i
    public static void add(int data,int idx){
         if(idx==0){
            addFirst(data);
            size++;
            return;
         }
         Node newNode=new Node(data);
         size++;
         int i=0;
         Node temp=head;
         while(i<idx-1){
             temp=temp.next;
             i++;
         }
         //now your temp.next is nothing but the address of the node which is at an index=idx
         //join the newNode.next to the node which is index=idx
         newNode.next=temp.next;
         temp.next=newNode;
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

    public static void reverse() {   //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr= next;

        }
        head = prev;
    }

    public static int iterativeSearch(int key){
         Node temp=head;
         int i=0;
         while(temp!=null){
              if(temp.data==key){
                  return i;
              }
              temp=temp.next;
              i++;
         }
         return -1;
    }
    public static int helper(Node head,int key){
        //Base case
        if(head==null){
             return -1;
        }
        if(head.data==key){
             return 0;
        }
        int idx=helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public static int recursiveSearch(int key){
         return helper(head,key);
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
        ll.add(4, 2);
        
        ll.print();
        System.out.println();
        System.out.println(ll.size);
        System.out.println("Iterative search : The key 6 is at :"+ll.iterativeSearch(6));
        System.out.println("Recursive search : The key 6 is at :"+ll.recursiveSearch(6));

         System.out.println("after removing last Node "+ll.removeLast());
        //System.out.println("after removing first Node "+ll.removeFirst());
        ll.print();
        System.out.println();
        System.out.println(ll.size);
        ll.reverse();
        ll.print();

  }
}
