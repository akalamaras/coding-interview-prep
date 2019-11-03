package Learn.Recursion;

import Support.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }


    // Dont even try to understand this shit
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null) {
            ListNode l1 = head.next, l2 = head.next.next;
            head.next = l2;
            l1.next = l2.next;
            l2.next =l1;
            head = l1;
            // kill me now wtf is this shit
        }
        return dummy.next;

    }
}
