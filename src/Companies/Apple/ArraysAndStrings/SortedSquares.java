package Companies.Apple.ArraysAndStrings;

import java.util.Arrays;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length];
        int insertPos = 0;

        for(int n : nums)
            res[insertPos++] = n * n;

        Arrays.sort(res);
        return res;
    }

    class Solution {

        public int[] sortedSquares(int[] nums) {

            int[] result = new int[nums.length];

            int left = 0, right = nums.length - 1;
            for(int position = nums.length - 1; position >= 0; position--) {

                if(Math.abs(nums[left]) > Math.abs(nums[right]))
                    result[position] = nums[left] * nums[left++];
                else
                    result[position] = nums[right] * nums[right--];
             }
            return result;
        }
    }
}
