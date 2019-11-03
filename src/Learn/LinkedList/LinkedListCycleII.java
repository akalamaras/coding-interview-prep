package Learn.LinkedList;

import Support.*;
import java.util.HashSet;

public class LinkedListCycleII {


    // O(n) space
    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null)
            return null;

        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur.next != null) {
            if(!set.add(cur))
                return cur;
            cur = cur.next;
        }
        return null;

    }

    // O(1) space
    public ListNode findCycleO1(ListNode head) {

        if(head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;

        while(slow != null && fast != null) {
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
            else
                return null;

            slow = slow.next;
            if(slow == fast)
                break;

        }

        if(fast == null)
            return null;

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
