package LinearProgress.Week3.Day5;

import Support.ListNode;

public class ReverseListIterative {

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
