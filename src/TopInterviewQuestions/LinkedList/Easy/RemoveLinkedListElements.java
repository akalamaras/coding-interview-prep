package TopInterviewQuestions.LinkedList.Easy;

import Support.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;

        while(current.next != null) {
            if(current.next.val == val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return dummyHead.next;
    }
}
