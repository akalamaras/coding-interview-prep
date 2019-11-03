package Companies.Cisco.FirstGo;

import java.util.*;

/**
 *  Design and implement a data structure for Least Recently Used (LRU) cache.
 *  It should support the following operations: get and put
 *  get(key)       - Get the value (will always be positive) of the key if the
 *                   key exists in the cache, otherwise return -1.
 *  put(key,value) - Set or insert the value if the key is not already present.
 *                   When the cache reached its capacity, it should invalidate the
 *                   least recently used item before inserting a new item
 *  The cache is initialised with a positive  capacity
 */

// Approach #1 HashTable + Double linked list
//  (Accepted, O(n) Time Complexity for put and get, O(capacity) space complexity)
// Video : https://www.youtube.com/watch?v=S6IfqDXWa10
public class LRUCache {

    // We need to create a Double Linked List and the methods we need
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /*
     * Always add the new node right after the head
     */
    private void addNode(DLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /*
     * Remove an existing node from the linked list
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /*
     * Move certain node in between to the head
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /*
     * Pop the current tail
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }




    private Hashtable<Integer,DLinkedNode> cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;

    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null)
            return -1;
        // move the accessed node to head since it was used
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key,newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value
            node.value = value;
            this.moveToHead(node);
        }
    }
}

// Approach #2 Lazy Ordered Dictionary
//  (Accepted, O(n) Time Complexity for put and get, O(capacity) space complexity)
class LRUCache2 extends LinkedHashMap<Integer,Integer> {
    // In this approach we use an ordered dictionary (called LinkedHashMap in java)

    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
     }
}