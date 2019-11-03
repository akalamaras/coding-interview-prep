package TopInterviewQuestions.LinkedList.Easy;

import Support.ListNode;

public class MergeTwoLists {

    public ListNode mergeIterative(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode handler = dummyHead;

        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }
        if(l1 != null)
            handler.next = l1;
        else if(l2 != null)
            handler.next = l2;

        return dummyHead.next;
    }

    public ListNode mergeRecursive(ListNode l1, ListNode l2) {

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        ListNode handler;
        if(l1.val < l2.val) {
            handler = l1;
            handler.next = mergeRecursive(l1.next, l2);
        } else {
            handler = l2;
            handler.next = mergeRecursive(l1, l2.next);
        }
        return handler;
    }
}
