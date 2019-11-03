package Learn.LinkedList;

import Support.ListNode;

import java.util.List;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        int count = 0;

        /** Get the total length */
        while(fast.next != null) {
            fast = fast.next;
            count++;
        }

        /** Find the (i - k%i)'th node */
        for(int j = count - k%count; j > 0; j--)
            slow = slow.next;

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;


        return dummy.next;


    }
}
