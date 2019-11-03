package Companies.Bloomberg.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        if(nums == null || nums.length == 0)
            return 0;

        // Use hashmap as counter
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int res = 0;
        map.put(0, 1); // Needed for sub arrays where sum == k

        for(int n : nums) {
            sum += n;
            if(map.containsKey(sum - k))
                res += map.get(sum - k);
            map.put(sum , map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public int other(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (sum == k) {
                count++;
            }

            int target = sum - k;
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}


