package Companies.Cisco.SecondGo.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWIthRandomPointer {

    class Node {

        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public Node copyRandomList(Node head) {

        if(head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        Node oldNode = head;
        Node newNode = new Node(head.val, null, null);
        while(oldNode != null) {

            newNode.random = getClonedNode(oldNode.random, map);
            newNode.next = getClonedNode(oldNode.next, map);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(head);
    }

    private Node getClonedNode(Node node, Map<Node,Node> map) {

        if(node == null)
            return null;

        if(map.containsKey(node))
            return map.get(node);
        else {
            map.put(node, new Node(node.val, null, null));
            return map.get(node);
        }
    }
}
