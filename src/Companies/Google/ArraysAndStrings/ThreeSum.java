package Companies.Google.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        final int TARGET = 0;

        List<List<Integer>> answer = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return answer;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {

            if(i != 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1;
            while(left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if(sum == TARGET) {
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1])
                        left++;

                    while(left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if(sum < TARGET)
                    left++;
                else
                    right--;
            }
        }
        return answer;
    }
}
