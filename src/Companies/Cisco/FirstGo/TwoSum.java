package Companies.Cisco.FirstGo;

import java.util.HashMap;

public class TwoSum {

    /**
     * Given an array of integers, return the indices of the two numbers such that they add up to
     * the specific target.
     * You may assume that each input would have exactly one solution, and you may not use the
     * same element twice.
     *
     **/


    // Best Approach. One pass HashMap (Accepted, O(n) Time Complexity, O(n) space complexity
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[] {map.get(complement),i};
            else
                map.put(nums[i],i);
        }
        return null;
    }
}
