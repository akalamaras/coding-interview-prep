package TopInterviewQuestions.LinkedList.Medium;

import Support.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;
        while(l1.next != null || l2.next != null) {

            int value = carry;
            if(l1 != null)
                value += l1.val;

            if(l2 != null)
                value += l2.val;

            value = value % 10;
            carry = value / 10;

            current.next = new ListNode(value);

            current = current.next;

            if(l1 != null && l1.next != null)
                l1 = l1.next;

            if(l2 != null && l2.next != null)
                l2 = l2.next;
        }
        if(carry > 0)
            current.next = new ListNode(carry);

        return dummyHead.next;

    }
}
