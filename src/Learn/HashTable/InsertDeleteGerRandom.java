package Learn.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

public class InsertDeleteGerRandom {

    class RandomizedSet {

        private Random random;
        private Set<Integer> set;
        private List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            set = new HashSet<>();
            list = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(!list.contains(val)) {
                list.add(val);
                set.add(val);
                return true;
            } else
                return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(list.contains(val)) {
                list.remove(val);
                set.remove(val);
                return true;
            } else
                return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
