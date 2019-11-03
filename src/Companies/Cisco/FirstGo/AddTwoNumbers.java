package Companies.Cisco.FirstGo;

import Support.ListNode;

public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     *  You are given 2 non-empty linked lists representing two non-negative integers. The
     *  digits are stored in reverse order and each of their nodes contains a single digit.
     *  Add the two numbers and return it as a linked list.
     *
     *  You may assume the two numbers do not contain any leading 0, except the number 0 itself.
     *
     *  Example.  Input:        (2 -> 4 -> 3) + (5 -> 6 -> 4)
     *            Output:       7 -> 0 -> 8
     *            Explanation:  342 + 465 = 807
     */


    // Approach #1 Mine (Math)
    //        (Accepted, O(max(m,n) time complexity, O(max(m,n) space complexity)
    //        where m is the number of digits of l1 and n is the number of digits of l2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // dummyZero is used to return the correct ListNode
        ListNode dummyZero = new ListNode(0);
        ListNode current = dummyZero;
        int over = 0;
        while(l1 != null || l2 != null) {
            // sum is either 0 or 1 depending on whether we carried over anything
            int sum = over;
            // if the node is null we treat it as a zero
            sum += (l1 != null) ? l1.val : 0;
            sum += (l2 != null) ? l2.val : 0;
            if(sum < 10)
                current.val = sum;
            else
                // if the sum is e.g. 14 we keep the 4
                current.val = sum%10;
            // over is either 1 or 0 depending on whether sum was more or less than 10
             over = sum/10;

            // move on to the next digit
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        // If we have carried a 1 to the end then we need a new digit
        if(over > 0)
            current.next = new ListNode(over);
        return dummyZero.next;
    }
}
