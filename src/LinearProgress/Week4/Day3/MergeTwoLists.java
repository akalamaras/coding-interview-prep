package LinearProgress.Week4.Day3;


import Support.ListNode;

public class MergeTwoLists {

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

    }
}
