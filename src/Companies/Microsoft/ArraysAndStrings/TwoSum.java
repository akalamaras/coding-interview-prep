package Companies.Microsoft.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {

            if(map.containsKey(target - i))
                return new int[] {map.get(target - i), i};

            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No answer");
    }
}
