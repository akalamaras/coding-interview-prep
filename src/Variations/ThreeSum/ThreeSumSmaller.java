package Variations.ThreeSum;

import java.util.Arrays;

public class ThreeSumSmaller {

    /**
     *  Given an array of n integers nums and a target, find the number of
     *  index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition
     *  nums[i] + nums[j] + nums[k] < target */


    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);

        int num = 0;
        for(int i = 0; i < nums.length - 2; i++) {

            int left = i+1;
            int right = nums.length-1;

            while(left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target) {
                    num += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return num;
    }
}
