package Variations.TwoSum;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/** Two Sum III Data Structure Design
 *
 * Approach #1 Use of HashMap
 *
 * It is possible to make our find method faster (Solution #2) */
class TwoSumIII {

    HashMap<Integer,Integer> map;

    /** Initialise the data structure */
    public TwoSumIII() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure. */
    public void add(int number) {
        if(map.containsKey(number))
            map.put(number,map.get(number)+1);
        else
            map.put(number,1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int target) {

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int current = entry.getKey();
            int complement = target - current;

            // Allows for two of the same number
            if (current == complement && entry.getValue() > 1)
                return true;

            if (current != complement && map.containsKey(complement))
                return true;
        }
        return false;
    }
}

/**
 *
 * Approach #2 Use of HashMap & ArrayList
 *
 * We trade off space (ArrayList) for time (faster find method)
 * Iterating a count map is slower than iterating a list.
 *
 * 'Iteration over collection views requires time proportional
 * to the "capacity" of the HashMap instance (the number of buckets)
 * plus its size (the number of key-value mappings).' - JavaDoc
 *
 * The list will only contain distinct elements
 *
 */
class TwoSum2 {

    List<Integer> list;
    Map<Integer,Integer> map;

    /** Initialise the data structures here */
    public TwoSum2() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }


    /** Add the number to an internal data structure. */
    public void add(int number) {
        if(map.containsKey(number))
            map.put(number,map.get(number)+1);
        else {
            map.put(number, 1);
            list.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int target) {
        for(int i = 0; i < list.size(); i++) {

            int current = list.get(i);
            int complement = target - current;

            if(current == complement && map.get(current) > 1)
                return true;

            if(current != complement && map.containsKey(complement))
                return true;
        }
        return false;
    }

}
