package Learn.LinkedList;

import Support.MultiLevelNode;

public class FlattenLinkedList {

    public MultiLevelNode flatten(MultiLevelNode head) {
        flattenTail(head);
        return head;
    }


    // flatten tail: flatten the node "head" and return the tail in its child (if exists)
    // the tail means the last node after flattening "head"

    // Five situations:
    // 1. null - no need to flatten, just return it
    // 2. no child, no next - no need to flatten, it is the last element, just return it
    // 3. no child, next - no need to flatten, go next
    // 4. child, no next - flatten the child and done
    // 5. child, next - flatten the child, connect it with the next, go next

    private MultiLevelNode flattenTail(MultiLevelNode head) {
        // case 1
        if(head == null)
            return head;


        if(head.child == null) {
            // case 2
            if(head.next == null)
                return head;
            // case 3
            return flattenTail(head.next);
        }

        MultiLevelNode child = head.child;
        head.child = null;
        MultiLevelNode next = head.next;

        MultiLevelNode childTail = flattenTail(child);
        head.next = child;
        child.prev = head;
        if(next != null) {
            // case 5
            childTail.next = next;
            next.prev = childTail;
            return flattenTail(next);
        }
        // case 4
        return childTail;

    }
}
