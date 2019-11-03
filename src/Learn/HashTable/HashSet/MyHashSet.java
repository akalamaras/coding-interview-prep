package Learn.HashTable.HashSet;

import java.util.*;

/**
 *
 *   Note:
 *        All values will be in the range of [0, 1000000].
 *        The number of operations will be in the range of [1, 10000].
 *        Please do not use the built-in HashSet library.
 *
 */

public class MyHashSet {

    boolean[] booleanArray;

    /** Initialize your data structure here. */
    public MyHashSet() {
        booleanArray = new boolean[1000000];
    }

    public void add(int key) {
        booleanArray[key] = true;
    }

    public void remove(int key) {
        booleanArray[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return booleanArray[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



class NoCheatingHashSet {

    class Buckets {

        private int itemsNum;
        private int[] items;

        public Buckets() {

            itemsNum = 1001;
            items = new int[itemsNum];
            init();

        }

        void init() {

            for(int i = 0; i < itemsNum; i++)
                items[i] = -1;

        }

        public void setItem(int key, int value) {

            int index = hashItem(key);
            items[index] = value;
        }

        public int getItem(int key) {
            int index = hashItem(key);
            return items[index];

        }

        public int hashItem(int key) {
            return key / bucketsNum;
        }
    }

    private int bucketsNum;
    private Buckets[] buckets;

    /** Initialize your data structure here */
    public NoCheatingHashSet() {
        bucketsNum = 1000;
        buckets = new Buckets[bucketsNum];
    }

    public void add(int key) {
        int bucketID = hashBucket(key);
        if(buckets[bucketID] == null)
            buckets[bucketID] = new Buckets();
        buckets[bucketID].setItem(key,key);
    }

    public void remove(int key) {

        int bucketID = hashBucket(key);
        if(contains(key))
            buckets[bucketID].setItem(key,-1);
    }

    public boolean contains(int key) {
        int bucketID = hashBucket(key);
        return buckets[bucketID] != null && buckets[bucketID].getItem(key) != -1;
    }

    public int hashBucket(int key) {
        return key % bucketsNum;
    }

}

