package ds.linear.linkedlist;

class ListNode {
    private int data;
    ListNode next;

    private ListNode(int payload) {
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

    int getCountOfNodes(ListNode node) {
        ListNode current = node;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * For example, if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5
     */
    private ListNode swapAdjacentNodes(ListNode head) {
        // If linked list is empty or there is only one node in list
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize previous and current pointers
        ListNode previous = head;
        ListNode current = head.next;

        head = current; // Change head before proceeeding

        // Traverse the list
        while (true) {
            ListNode next = current.next;
            current.next = previous; // Change next of current as previous node

            // If next is NULL or the last node
            if (next == null || next.next == null) {
                previous.next = next;
                break;
            }
            // Change next of previous to next next
            previous.next = next.next;

            // Update previous and curr
            previous = next;
            current = previous.next;
        }
        return head;
    }
}
