package TopInterviewQuestions.LinkedList.Hard;

import Support.ListNode;

public class ReverseNodesInKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        int count = 0;

        while(current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count == k) {

            current = reverseKGroup(current, k);

            while(count-- > 0) {

                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }
}
