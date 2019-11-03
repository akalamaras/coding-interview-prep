package TopInterviewQuestions.LinkedList.Hard;

import Support.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int minIndex = 0;

        while(true) {

            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i++) {

                if(lists[i] != null) {

                    isBreak = false;

                    if(lists[i].val < min) {
                        minIndex = i;
                        min = lists[i].val;
                    }
                }
            }
            if(isBreak)
                break;

            current.next = new ListNode(lists[minIndex].val);
            current = current.next;
            lists[minIndex] = lists[minIndex].next;
        }
        current.next = null;
        return dummyHead.next;
    }
}
