package Companies.Apple.Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private DLNode head;
    private DLNode tail;
    private Map<Integer, DLNode> map;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {

        this.head = new DLNode();
        this.tail = new DLNode();
        head.next = tail;
        tail.prev = head;

        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;

    }

    public int get(int key) {

        DLNode node = map.get(key);
        if(node == null)
            return -1;
        else {
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {

        DLNode node = map.get(key);

        if(node != null) {
            node.val = value;
            moveToHead(node);
        } else {

            DLNode newNode = new DLNode();
            newNode.key = key;
            newNode.val = value;

            map.put(key, newNode);
            addAtHead(newNode);
            size++;

            if(size > capacity) {

                DLNode tail = removeTail();
                map.remove(tail);
                size--;
            }
        }
    }

    class DLNode {

        private int key;
        private int val;
        private DLNode next;
        private DLNode prev;

        public DLNode() {
        }

        public DLNode(int key, int val, DLNode next, DLNode prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void addAtHead(DLNode node) {

        DLNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    public void removeNode(DLNode node) {

        DLNode prev = node.prev;
        DLNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public DLNode removeTail() {

        DLNode prev = tail.prev;
        removeNode(prev);
        return prev;
    }

    public void moveToHead(DLNode node) {

        removeNode(node);
        addAtHead(node);
    }
}


