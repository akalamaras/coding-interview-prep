package Companies.TwoSigma;

import java.util.*;

public class LRUCache {

    int capacity;
    int size;
    Hashtable<Integer,DoubleLinkedNode> cache = new Hashtable<>();
    DoubleLinkedNode head;
    DoubleLinkedNode tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();

        head.next = tail;
        tail.previous = head;

    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null)
            return -1;

        node.moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {

        DoubleLinkedNode node = cache.get(key);
        if(node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key,newNode);
            newNode.addNode(newNode);

            size++;

            if(size > capacity) {

                DoubleLinkedNode tail = node.popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            node.moveToHead(node);
        }

    }

    class DoubleLinkedNode {

        int key;
        int value;
        DoubleLinkedNode previous;
        DoubleLinkedNode next;

        private void addNode(DoubleLinkedNode node) {
            node.previous = head;
            node.next = head.next;

            head.next.previous = node;
            head.next = node;
        }

        private void deleteNode(DoubleLinkedNode node) {

            DoubleLinkedNode previous = node.previous;
            DoubleLinkedNode next = node.next;

            previous.next = next;
            next.previous = previous;

        }

        private void moveToHead(DoubleLinkedNode node) {

            deleteNode(node);
            addNode(node);

        }

        private DoubleLinkedNode popTail() {

            DoubleLinkedNode newTail = tail.previous;
            deleteNode(tail);
            return newTail;


        }
    }
}
