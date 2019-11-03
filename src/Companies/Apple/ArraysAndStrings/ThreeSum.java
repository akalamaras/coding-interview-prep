package Companies.Apple.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        final int TARGET = 0;
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0)
                break;

            if(i == 0 || nums[i] != nums[i - 1]) {

                int sum = TARGET - nums[i];

                int left = i + 1, right = nums.length - 1;
                while (left < right) {

                    if (nums[left] + nums[right] == sum) {
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while(left < right && nums[left] == nums[left + 1])
                            left++;

                        while(left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;

                    } else if (nums[left] + nums[right] < sum)
                        left++;
                    else
                        right--;
                }
            }
        }
        return list;
    }
}
