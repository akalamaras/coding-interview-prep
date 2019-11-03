package Learn.LinkedList;

import Support.DoublyListNode;

public class MyDoublyLinkedList {

    private DoublyListNode head;

    /** Initialize your data structure here. */
    public MyDoublyLinkedList() {
        head = null;
    }

    /** Add a node of value val before the first element of the linked list.
      * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        DoublyListNode current = new DoublyListNode(val);
        current.next = head;

        if(head != null)
            head.prev = current;

        head = current;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
            return;
        }

        DoublyListNode prev = getTail();
        DoublyListNode current = new DoublyListNode(val);

        prev.next = current;
        current.prev = prev;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended
     * to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }

        DoublyListNode prev = getNode(index-1);
        if(prev == null)
            return;

        DoublyListNode current = new DoublyListNode(val);
        DoublyListNode next = prev.next;

        current.prev = prev;
        current.next = current;
        prev.next = current;
        if(next != null)
            next.prev = current;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        DoublyListNode current = getNode(index);
        if(current == null)
            return;

        DoublyListNode prev = current.prev;
        DoublyListNode next = current.next;
        if(prev != null)
            prev.next = next;
        else
            // modify head when deleting the first node.
            head = next;

        if(next != null)
            next.prev = prev;
    }

    /** Helper function to return the index-th node in the linked list. */
    private DoublyListNode getNode(int index) {
        DoublyListNode current = head;
        for(int i = 0; i < index && current != null; i++)
            current = current.next;

        return current;
    }

    /** Helper function to return the last node in the linked list */
    private DoublyListNode getTail() {
        DoublyListNode current = head;
        while(current != null && current.next != null)
            current = current.next;
        return current;
    }


}
