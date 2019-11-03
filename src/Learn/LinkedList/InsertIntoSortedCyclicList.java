package Learn.LinkedList;


// linked list is sorted

public class InsertIntoSortedCyclicList {

    class Node {

        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
            next = null;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {

        if(head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node current = head.next;
        Node prev = head;

        // move until we find the cycle
        while(current != head) {

            // if we find the insertion position before that, insert and return

            if(insertVal == prev.val
                    || insertVal <= current.val && insertVal > prev.val
                    || current.val < prev.val && insertVal > prev.val
                    || current.val < prev.val && insertVal < current.val) {

                Node node = new Node(insertVal);
                prev.next = node;
                node.next = current;
                return head;
            }
            prev = current;
            current = current.next;
        }
        // if we don't find it, add it to the end of the cycle
        Node node = new Node(insertVal);
        prev.next = node;
        node.next = current;
        return head;
    }
}
