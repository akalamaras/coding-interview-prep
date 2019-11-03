package Companies.Cisco.FirstGo;

import Support.ListNode;

public class ReverseLinkedList {


    // Approach 1 Recursive (Accepted, O(n) time complexity, O(n) space complexity because
    // of the recursive stack)
    // VISUAL REPRESENTATION https://www.youtube.com/watch?v=MRe3UsRadKw
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // Approach 2 Iterative (Accepted, O(n) time complexity, O(1) space complexity
    // VISUAL REPRESENTATION https://www.youtube.com/watch?v=uJZMxWhYTJk
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next =  prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }



}
