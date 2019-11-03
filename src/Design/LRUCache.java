package Design;

import java.util.HashMap;
import java.util.Map;

class LRUCache {



    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = map.get(key);
        if(node == null)
            return -1;

        moveToHead(node);
        return node.val;

    }

    public void put(int key, int value) {

        Node node = map.get(key);

        if(node == null) {

            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            map.put(key, newNode);
            addNode(newNode);
            size++;

            if(size > capacity) {
                // Pop the tail
                Node tail = popTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            // update the value
            node.val = value;
            moveToHead(node);
        }
    }

    class Node {

        int key;
        int val;
        Node next;
        Node prev;

        public Node() {}

        public Node(int key,int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    // Add it to the right of head
    private void addNode(Node node) {

        Node temp = head.next;

        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    private void removeNode(Node node) {

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private Node popTail() {

        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(Node node) {

        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */