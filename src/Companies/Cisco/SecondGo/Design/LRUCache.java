package Companies.Cisco.SecondGo.Design;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> map;
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int _capacity) {

        map = new HashMap<>();
        size = 0;
        capacity = _capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = map.get(key);
        if(node == null)
            return -1;

        // Move the accessed node to the head
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        Node node = map.get(key);

        // If the node exists, update it
        if(node != null) {
            node.value = value;
            moveToHead(node);
        } else {

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            map.put(key, newNode);
            addNode(newNode);
            size++;

            // If we are over capacity, pop the tail
            if(size > capacity) {

                Node tail = popTail();
                map.remove(tail.key);
                size--;
            }
        }
    }

    class Node {

        public int key;
        public int value;
        public Node next;
        public Node prev;
    }

    /*
     * Adds the node to the right of head
     */
    private void addNode(Node node) {

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /*
     * Remove the node from the linked list
     */
    private void removeNode(Node node) {

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    /*
     * Move a node to the right of the head
     */
    private void moveToHead(Node node) {

        removeNode(node);
        addNode(node);
    }

    /*
     * Pop the current tail
     */
    private Node popTail() {

        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}
