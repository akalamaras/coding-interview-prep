package Learn.LinkedList;

import Support.ListNode;

public class RemoveNthNodeFromList {

    public ListNode removeNthNode(ListNode head, int n) {


        ListNode start = new ListNode(0);
        ListNode fast = start;
        ListNode slow = start;
        slow.next = head;

        for(int i = 0; i < n; i++)
            fast = fast.next;

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }

}
