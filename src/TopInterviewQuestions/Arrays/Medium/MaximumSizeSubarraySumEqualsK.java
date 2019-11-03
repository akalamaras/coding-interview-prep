package TopInterviewQuestions.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

    public int maxSubarray(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxSize = 0;

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if(sum == k)
                maxSize = i + 1;
            else if(map.containsKey(sum - k))
                maxSize = Math.max(maxSize, i - map.get(sum - k));
            map.putIfAbsent(sum, i);
        }
        return maxSize;
    }
}
