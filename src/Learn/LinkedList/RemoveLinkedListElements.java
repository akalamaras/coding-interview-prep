package Learn.LinkedList;

import Support.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode current = head, prev = fakeHead;

        while(current != null) {

            if(current.val == val)
                prev.next = current.next;
            else
                prev = prev.next;

            current = current.next;

        }
        return fakeHead.next;
    }
}
