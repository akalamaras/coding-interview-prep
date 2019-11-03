package LinearProgress.Week5.Day2;

import Support.*;

public class RemDupesFromSortedList {

    public ListNode deleteDupes(ListNode head) {
        if(head == null || head.next == null) return null;
        head.next = deleteDupes(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public ListNode straightforward(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null) {
            if(current.next.val == current.val) current.next = current.next.next;
            else current = current.next;
        }
        return head;
    }
}