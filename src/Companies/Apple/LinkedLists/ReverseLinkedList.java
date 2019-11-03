package Companies.Apple.LinkedLists;

import Support.ListNode;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode p = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return p;
    }
}
