package LinearProgress.Week1.Day5;

import Support.*;

public class RemDupesFromSortedList{


    private ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null) {
            if (current.next.val == current.val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }

}
