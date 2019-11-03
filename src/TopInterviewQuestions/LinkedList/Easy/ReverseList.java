package TopInterviewQuestions.LinkedList.Easy;

import Support.ListNode;

public class ReverseList {

    public ListNode reverse(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode p = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }
}
