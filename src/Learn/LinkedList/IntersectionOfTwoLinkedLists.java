package Learn.LinkedList;

import Support.ListNode;
import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {


    // O(n)
    public ListNode getIntersectionIndex(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode currentA = headA;
        while(currentA != null) {
            set.add(currentA);
            currentA = currentA.next;
        }

        ListNode currentB = headB;
        while( currentB != null) {
            if(set.contains(currentB))
                return currentB;
            currentB = currentB.next;
        }
        return null;
    }

    // O(1)
    public ListNode getIntersectionIndexO1(ListNode headA, ListNode headB) {

        ListNode pA = headA;
        ListNode pB = headB;

        // even though lists A and B might have different lengths, the length A+B is constant
        while(pA != pB) {

            if(pA != null)
                pA = pA.next;
            else
                pA = headB;

            if(pB != null)
                pB = pB.next;
            else
                pB = headA;
        }

        if(pA == pB)
            return pA;
        else
            return null;
    }

}
