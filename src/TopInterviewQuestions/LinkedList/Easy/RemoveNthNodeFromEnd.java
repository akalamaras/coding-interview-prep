package TopInterviewQuestions.LinkedList.Easy;

import Support.ListNode;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthTwoPass(ListNode head, int n) {

        int count = 0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode current = head;
        while(current != null) {
            current = current.next;
            count++;
        }

        current = head;
        while(count - n > 0) {
            current = current.next;
            n--;
        }

        current.next = current.next.next;

        return dummyHead.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        // Move fast n spots in front of slow
        for(int i = 0; i <= n; i++)
            fast = fast.next;

        // Move fast and slow to the end
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the node
        slow.next = slow.next.next;
        
        
        return dummyHead.next;
    }
}
