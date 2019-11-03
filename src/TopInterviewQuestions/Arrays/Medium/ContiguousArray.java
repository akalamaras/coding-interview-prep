package TopInterviewQuestions.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> countToIndex = new HashMap<>();
        int maxLength = 0, count = 0;

        for(int i = 0; i < nums.length; i++) {

            count += (nums[i] == 1) ? 1 : - 1;
            if(countToIndex.containsKey(count))
                maxLength = Math.max(maxLength, i - countToIndex.get(count));
            else
                countToIndex.put(count, i);
        }
        return maxLength;
    }
}
