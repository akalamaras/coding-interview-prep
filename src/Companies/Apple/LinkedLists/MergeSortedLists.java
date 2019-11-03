package Companies.Apple.LinkedLists;

import Support.ListNode;

public class MergeSortedLists {

    public ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null)
            current.next = l1;
        else if(l2 != null)
            current.next = l2;

        return dummyHead.next;
    }
}
