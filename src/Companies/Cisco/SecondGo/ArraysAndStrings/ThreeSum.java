package Companies.Cisco.SecondGo.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] array = {-1, 0, 1, 2, 0, -1, 4};
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(array));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        final int TARGET = 0;
        List<List<Integer>> list = new ArrayList<>();

        if(nums == null || nums.length < 3)
            return list;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++) {

            if(i == 0 || nums[i] != nums[i - 1]) {

                int sum = TARGET - nums[i];

                int left = i + 1, right = nums.length - 1;
                while (left < right) {

                    if (nums[left] + nums[right] == sum) {

                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1])
                            left++;

                        while (left < right && nums[right] == nums[right - 1])
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
