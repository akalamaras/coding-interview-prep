package Companies.Bloomberg.LinkedList;

import Support.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // Find the node m
        ListNode current = dummyHead;
        for(int i = 0; i < m - 1; i++)
            current = current.next;

        ListNode start = current.next;
        ListNode then = start.next;

        for(int i = 0; i < n - m; i++) {

            start.next = then.next;
            then.next = current.next;
            current.next = then;
            then = start.next;
        }
        return dummyHead.next;
    }
}
