package TopInterviewQuestions.LinkedList.Easy;

import Support.ListNode;

public class DeleteNode {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
