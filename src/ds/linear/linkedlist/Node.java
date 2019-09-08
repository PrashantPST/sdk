package ds.linear.linkedlist;

class Node {
        private int data;
        Node next;
        Node(int payload) {
            data = payload;
        }

    static Node insertAtMid(Node head, int x) {
        if (head == null)
            return new Node(x);
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
        return head;
    }
}
