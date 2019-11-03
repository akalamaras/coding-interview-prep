package Companies.Apple.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int target) {

        Map<Integer, Integer> sumCounts = new HashMap<>();
        int res = 0;

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int complement = sum - target;
            if(sumCounts.containsKey(complement))
                res += sumCounts.get(complement);

            sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);

            if(sum == target)
                res++;
        }
        return res;
    }
}
