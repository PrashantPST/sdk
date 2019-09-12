package ds.linear.linkedlist;



public class Runner {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(40);
        head.next.next.next = new ListNode(50);
        int x = 30;
        ListNode.insertAtMid(head, x);
    }
}
