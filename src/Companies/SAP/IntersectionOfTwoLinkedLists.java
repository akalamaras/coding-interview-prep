package Companies.SAP;

public class IntersectionOfTwoLinkedLists {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        ListNode currentA = headA;
        ListNode currentB = headB;

        while(currentA != null || currentB != null) {

            if(currentA == null)
                currentA = headB;

            if(currentB == null)
                currentB = headA;

            if(currentA == currentB)
                return currentA;

            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }
}
