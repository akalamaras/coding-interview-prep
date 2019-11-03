package Companies.Cisco.FirstGo;

/** Definition of a singly-linked list
 *  public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) { val = x; }
 *  }
 */

import Support.*;

public class ReorderList {

    public void reorder(ListNode head) {
        // null check
        if(head == null || head.next == null) return;

        // find the middle of the list which will be p1
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // reverse the half after middle
        // e.g. 1 -> 2 -> 3 -> 4 -> 5 -> 6 becomes 1 -> 2 -> 3 -> 6 -> 5 -> 4
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while(preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        // start reorder 1 by 1
        p1 = head;
        p2 = preMiddle.next;
        while(p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        /*
            Step 1. Cut the list in half.

            prev is the tail of the 1st half
            slow is the head of the 2nd half

            Basically 'fast' goes twice as fast as 'slow' so we find the middle.
            prev is just the slow.previous (but we can't find it like that
            cause the list is singly-linked).
         */
        ListNode prev = null, slow = head, fast = head, l1 = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // Step 2. Reverse the second half
        ListNode l2 = reverse(slow);

        // Step 3. Merge the two halves 1 by 1
        merge(l1, l2);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
        while( l1 != null ) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if( n1 == null) break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }




    }








}
