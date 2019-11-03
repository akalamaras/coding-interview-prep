package Redos.Medium.LinkedList;

import Support.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLInkedLists {

    public ListNode getIntersect(ListNode headA, ListNode headB) {

        ListNode currentA = headA;
        ListNode currentB = headB;

        while(currentA != currentB) {
            currentA = (currentA != null) ? currentA.next : headB;
            currentB = (currentB != null) ? currentB.next : headA;
        }
        return currentA;
    }

    public ListNode getInter(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();

        ListNode current = headA;
        while(current != null) {

            set.add(current);
            current = current.next;
        }

        current = headB;
        while(current != null) {

            if(set.contains(current))
                return current;
            current = current.next;
        }
        return null;
    }


    public ListNode getIntersection(ListNode headA, ListNode headB) {

        ListNode currentA = headA;
        ListNode currentB = headB;

        while(currentA != currentB) {

            if(currentA == null)
                currentA = headB;
            else
                currentA = currentA.next;

            if(currentB == null)
                currentB = headA;
            else
                currentB = currentB.next;
        }
        return currentA;
    }
}
