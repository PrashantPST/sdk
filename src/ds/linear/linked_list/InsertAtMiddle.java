package src.ds.linear.linked_list;

class InsertAtMiddle {
    private static Node head;
     static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    private static void insertAtMid(int x) {
        if (head == null)
            head = new Node(x);
        else {
            Node newNode = new Node(x);
            Node slow = head;
            Node fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            newNode.next = slow.next;
            slow.next = newNode;
        }
    }
    private static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main (String[] args) {
        head = null;
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(40);
        head.next.next.next = new Node(50);
        System.out.println("Linked list before insertion: ");
        display();
        int x = 30;
        insertAtMid(x);
        System.out.println("\nLinked list after insertion: ");
        display();
    }
}
