package Companies.Cisco.FirstGo;

import Support.ListNode;


/**
 *
 *  Reverse a linked list from position n to m. Do it in 1 pass.
 *
 *  Note: 1 <= m <= n <= length of list
 *
 *  Example. Input:   1 -> 2 -> 3 -> 4 -> 5 -> NULL, m = 2, n = 4.
 *           Output:  1 -> 4 -> 3 -> 2 -> 5 -> NULL
 */

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // Reach node m
        ListNode current = head;
        int x = 1;
        while(x < m) {
            x++;
            current = current.next;
        }
        // call the helper function
        helper(current,n - m);
        return head;
    }

    public void helper(ListNode current,int diff) {
        // if i reach m, start swapping
        if(diff == 0) {
            current.next.next = current;
            current.next = null;
        } else {
            // go all the way to m
            helper(current,diff-1);
            // then swap when returning
            current.next.next = current;
            current.next = null;
        }
    }
}
