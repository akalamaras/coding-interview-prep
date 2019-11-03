package Learn.LinkedList;

import Support.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        helper(current, l1, l2);
        return dummyHead.next;
    }

    private void helper(ListNode current, ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) {
            current.next = null;
            return;
        } else if(l1 == null) {
            current.next = l2;
            helper(current.next, l1, l2.next);
        } else if(l2 == null) {
            current.next = l1;
            helper(current.next, l1.next, l2);
        } else {

            if(l1.val < l2.val) {
                current.next = l1;
                helper(current.next, l1.next, l2);
            } else {
                current.next = l2;
                helper(current.next, l1, l2.next);
            }
        }
    }

    public ListNode iterative(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while(l1 != null || l2 != null) {

            if(l1 == null) {
                current.next = l2;
                l2 = l2.next;
            } else if(l2 == null) {
                current.next = l1;
                l1 = l1.next;
            } else {

                if(l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
            }
            current = current.next;
        }
        return dummyHead.next;
    }
}
