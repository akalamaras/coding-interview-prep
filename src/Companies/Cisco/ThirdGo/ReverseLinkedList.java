package Companies.Cisco.ThirdGo;

import Support.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode p = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return p;
    }
}
