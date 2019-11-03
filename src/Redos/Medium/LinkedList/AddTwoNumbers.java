package Redos.Medium.LinkedList;

import Support.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        ListNode first = l1;
        ListNode second = l2;

        int carry = 0;
        while(first != null || second != null) {

            int sum = carry;

            if(first != null)  sum += first.val;
            if(second != null) sum += second.val;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);

            if(first != null) first = first.next;
            if(second != null) second = second.next;
            current = current.next;
        }
        if(carry != 0)
            current.next = new ListNode(carry);

        return dummyHead.next;
    }
}
