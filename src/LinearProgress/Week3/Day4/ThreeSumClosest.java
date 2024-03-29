package LinearProgress.Week3.Day4;

import java.util.*;

public class ThreeSumClosest {

    private int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        for(int i =0; i< nums.length-2;i++) {
            int low = i+1, high = nums.length-1;
            while(low<high) {
                int sum = nums[i] + nums[low] + nums[high];
                if( sum > target) high--;
                else low++;
                if(Math.abs(sum-target) < Math.abs(result-target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
