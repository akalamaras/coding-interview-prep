package TopInterviewQuestions.Arrays.Hard;

import java.util.Arrays;

public class FindTheDuplicate {

    public int findDuplicate(int[] nums) {

        if(nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1])
                return nums[i];
        }
        return -1;
    }

    public int pigeonhole(int[] nums) {

        int left = 0, right = nums.length - 1;
        while(left < right) {

            int mid = left + (right - left) / 2;

            int count = 0;
            for(int n : nums) {
                if(n <= mid)
                    count++;
            }

            if(count <= mid)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
