package datastructures.linear.linkedlist;

import static datastructures.linear.linkedlist.Node.insertAtMid;

public class Runner {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(40);
        head.next.next.next = new Node(50);
        int x = 30;
        insertAtMid(head, x);
    }
}
