package Learn.HashTable.HashMap;

/**
 * Note:
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */

class MyHashMap {

    class ListNode {

        int key,val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final ListNode[] nodes;

    ListNode find(ListNode bucket, int key) {

        ListNode node = bucket, prev = null;
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    int idx(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int i = idx(key);

        if(nodes[i] == null)
            nodes[i] = new ListNode(-1,-1);

        ListNode prev = find(nodes[i],key);

        if(prev.next == null)
            prev.next = new ListNode(key,value);
        else
            prev.next.val = value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int i = idx(key);

        if(nodes[i] == null)
            return -1;

        ListNode node = find(nodes[i],key);
        return (node.next == null) ? -1 : node.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int i = idx(key);

        if(nodes[i] == null)
            return;

        ListNode prev = find(nodes[i],key);

        if(prev.next == null)
            return;

        prev.next = prev.next.next;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
