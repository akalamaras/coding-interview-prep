package LinearProgress.Week2.Day11;

import Support.*;

public class ReverseLinkedList {

    private ListNode reverseListIterative(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while(current != null) {
            ListNode nextTemp = current.next; // store the element before changing the pointer
            current.next = previous; // swap the pointer from -> to <-
            previous = current;
            current = nextTemp;
        }
        return previous; // return the new head
    }

    private ListNode reverseListRecursive(ListNode head) {
        if (head.next == null || head == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
