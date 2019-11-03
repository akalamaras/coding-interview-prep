package TopInterviewQuestions.LinkedList.Hard;

import Support.ListNode;

public class SortList {

    public ListNode sort(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        // Pre is used to split the list in half
        ListNode pre = head;

        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        pre.next = null;

        ListNode h1 = sort(head);
        ListNode h2 = sort(slow);

        return merge(h1, h2);
    }

    private ListNode merge(ListNode h1, ListNode h2) {

        if(h1 == null)
            return h2;

        if(h2 == null)
            return h1;

        if (h1.val < h2.val) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }
}
