package Companies.Cisco.SecondGo.LinkedList;

import Support.ListNode;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;


        ListNode current = head;
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }

        count = count - n;
        current = dummyHead;
        while(count > 0) {
            count--;
            current = current.next;
        }
        current.next = current.next.next;

        return dummyHead.next;
    }
}
