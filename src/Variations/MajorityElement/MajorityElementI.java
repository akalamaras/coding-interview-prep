package Variations.MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementI {

    public int majorityElement(int[] nums) {

        final int MAJORITY_COUNT = nums.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {

            if(map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);

            if(map.get(n) == MAJORITY_COUNT)
                return n;
        }
        return -1;
    }
}
