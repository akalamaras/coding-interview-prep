package Design;

public class SinglyLinkedList {

    /** Definition of a singly linked list node */
    class SinglyLinkedNode {

        int val;
        SinglyLinkedNode next;

        SinglyLinkedNode(int x) {
            val = x;
        }
    }

    private SinglyLinkedNode head;

    public SinglyLinkedList() {

        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        SinglyLinkedNode current = head;
        for(int i = 0; i <= index; i++) {

            if(current == null)
                return -1;

            current = current.next;
        }
        return current.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        SinglyLinkedNode node = new SinglyLinkedNode(val);
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        SinglyLinkedNode tail = findTail();
        tail.next = new SinglyLinkedNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index == 0)
            addAtHead(val);


        SinglyLinkedNode node = new SinglyLinkedNode(val);
        SinglyLinkedNode pre = getNode(index-1);
        SinglyLinkedNode next = getNode(index+1);

        pre.next = node;
        node.next = next;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(index == 0) {
            head = head.next;
            return;
        }

        SinglyLinkedNode nodeToDelete = getNode(index);
        if(nodeToDelete == null)
            return;

        if(nodeToDelete.next == null) {
            SinglyLinkedNode prev = getNode(index-1);
            prev.next = null;
        } else {
            SinglyLinkedNode prev = getNode(index-1);
            prev.next = nodeToDelete.next;
        }
    }

    /** Helper Methods */

    private SinglyLinkedNode findTail() {

        SinglyLinkedNode current = head;
        while(current.next != null)
            current = current.next;
        return current;
    }

    private SinglyLinkedNode getNode(int index) {

        SinglyLinkedNode current = head;
        for(int i = 0; i <= index; i++) {

            if(current == null)
                return null;

            current = current.next;
        }
        return current;
    }
 }
