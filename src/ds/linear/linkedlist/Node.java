package ds.linear.linkedlist;

class ListNode {
    private int data;
    ListNode next;

    ListNode(int payload) {
        data = payload;
    }

    static ListNode insertAtMid(ListNode head, int x) {
        if (head == null)
            return new ListNode(x);
        else {
            ListNode newListNode = new ListNode(x);
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            newListNode.next = slow.next;
            slow.next = newListNode;
        }
        return head;
    }

    private Object[] detectLoop(ListNode loopedList) {
        boolean loopFound = false;
        ListNode fastNode = loopedList;
        ListNode slowNode = loopedList;

        while (fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (slowNode == fastNode) {
                loopFound = true;
                break;
            }
        }
        return new Object[]{loopFound, fastNode};
    }

    private ListNode loopDetectionNode(ListNode loopedList) {
        ListNode P1 = loopedList;
        if ((boolean) detectLoop(loopedList)[0]) {
            ListNode P2 = (ListNode) detectLoop(loopedList)[1];
            while (P1 != P2) {
                P1 = P1.next;
                P2 = P2.next;
            }
            return P1;
        }
        return null;
    }

    int countNodesIfLoop(ListNode n) {
        int res = 0;
        if (loopDetectionNode(n) != null) {
            res = 1;
            ListNode temp = loopDetectionNode(n);
            ListNode t = temp;
            assert temp != null;
            while (temp.next != t) {
                res++;
                temp = temp.next;
            }
        }
        return res;
    }
}
