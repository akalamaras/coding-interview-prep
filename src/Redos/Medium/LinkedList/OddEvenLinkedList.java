package Redos.Medium.LinkedList;

import Support.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode odd  = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null) {

            odd.next = even.next;
            even.next = odd.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenLinkedList(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;

        ListNode odd = head;
        while (odd != null && odd.next != null) {

            current.next = odd;

            odd = odd.next.next;
            current = current.next;
        }

        ListNode even = head.next;
        while(even != null && even.next != null) {

            current.next = even;

            even = even.next.next;
            current = current.next;
        }

        return dummyHead.next;
    }
}
