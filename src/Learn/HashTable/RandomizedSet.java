package Learn.HashTable;

import java.util.HashSet;
import java.util.ArrayList;

class RandomizedSet {

    ArrayList<Integer> list;
    HashSet<Integer> set;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!set.add(val))
            return false;
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.remove(val))
            return false;
        list.remove((Object) val);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        double random = Math.random();
        int randomIndex = (int) random * list.size();
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
