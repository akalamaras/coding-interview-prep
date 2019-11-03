package Learn.ArrayAndString.TwoPointer;

import java.util.HashMap;

public class TwoSumII {

    public int[] twoSumII(int[] nums, int target) {

        int[] ret = new int[2];

        if(nums == null || nums.length == 0)
            return ret;

        int left = 0, right = nums.length-1;

        while(left < right) {

            long v = nums[left] + nums[right];
            if(v == target) {
                ret[0] = left + 1;
                ret[1] = right + 1;
                return ret;
            } else if( v < target)
                left++;
            else
                right--;
        }
        return ret;
    }

    public int[] classicTwoSum(int[] numsSorted, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < numsSorted.length; i++) {

            int complement = target - numsSorted[i];

            if(map.containsKey(complement))
                return new int[] {map.get(complement),i};
            map.put(numsSorted[i],i);
        }
        return null;
    }
}
