package Companies.Cisco.SecondGo.LinkedList;

import Support.ListNode;

import java.util.Stack;

public class ReorderList {

    public void reorderStack(ListNode head) {

        if(head == null || head.next == null)
            return;

        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;
        while(current != null) {
            stack.push(current);
            current = current.next;
        }

        int count = (stack.size() - 1) / 2;

        current = head;
        while(count > 0) {

            ListNode top = stack.pop();

            ListNode temp = current.next;
            current.next = top;
            top.next = temp;

            current = temp;
            count--;
        }
        stack.pop().next = null;
    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the right half
        ListNode middle = slow;
        ListNode current = middle.next;

        while(current.next != null) {

            ListNode next = current.next;
            current.next = next.next;
            next.next = middle.next;
            middle.next = next;
        }

        // Start reordering one-by-one
        ListNode left = head;
        ListNode right = middle.next;

        while(left != middle) {

            middle.next = right.next;

            right.next = left.next;
            left.next = right;
            left = right.next;

            right = middle.next;
        }
    }
}
