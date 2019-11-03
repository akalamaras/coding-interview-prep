package TopInterviewQuestions.Design.Easy;



public class DesignHashMap {

    class ListNode {

        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private ListNode[] nodes;

    class MyHashMap {

        /** Initialize your data structure here. */
        public MyHashMap() {
            nodes = new ListNode[10000];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {

            ListNode bucket = nodes[getIndex(key)];

            if(bucket == null)
                bucket = new ListNode(-1, -1);

            ListNode prev = find(bucket, key);
            // add new node
            if(prev.next == null)
                prev.next = new ListNode(key, value);
            // or update
            else
                prev.next.val = value;

        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {

            ListNode bucket = nodes[getIndex(key)];

            if(bucket == null)
                return -1;

            ListNode node = find(bucket, key);
            return node.next == null ? -1 : node.next.val;

        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {

            ListNode bucket = nodes[getIndex(key)];

            if(bucket == null)
                return;

            ListNode prev = find(bucket, key);
            if(prev.next == null)
                return;

            prev.next = prev.next.next;

        }

        private int getIndex(int key) {
            return Integer.hashCode(key) % nodes.length;
        }

        private ListNode find(ListNode bucket, int key) {

            ListNode node = bucket, prev = null;
            while(node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

    }

}
