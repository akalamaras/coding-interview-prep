package Learn.LinkedList;

import Support.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head;

        while(fast.next != slow) {

            if(fast.next == null || fast.next.next == null)
                return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
