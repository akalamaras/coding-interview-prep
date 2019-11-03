package Learn.LinkedList;

import Support.ListNode;

public class MergeKsortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while(true) {

            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            for(ListNode node: lists) {

                if(node != null)
                    if(node.val < minNode.val)
                        minNode = node;
            }

            // Might have to go and do node.next on the min node.

            if(minNode.val == Integer.MAX_VALUE) {
                current.next = null;
                break;
            }

            ListNode next = new ListNode(minNode.val);
            minNode = minNode.next;

            current.next = next;
            current = current.next;
        }
        return dummyHead.next;
    }
}
