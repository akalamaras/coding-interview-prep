package Companies.Apple.ArraysAndStrings;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int[] array = {- 1, 2, 1, -4};
        int target = 0;
        ThreeSumClosest ts = new ThreeSumClosest();
        System.out.println(ts.threeSumClosest(array, target));
    }

    public int threeSumClosest(int[] nums, int target) {

        if(nums == null || nums.length < 3)
            return 0;

        int[] copy = nums.clone();
        int closestDifference = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(copy);

        for(int i = 0; i < copy.length; i++) {

            int left = i + 1, right = copy.length - 1;
            while(left < right) {

                int sum = copy[i] + copy[left] + copy[right];

                if(Math.abs(target - sum) < closestDifference) {
                    closestDifference = Math.abs(target - sum);
                    closestSum = sum;
                }
                if(closestDifference == 0)
                    return closestSum;

                if(sum < target)
                    left++;
                else
                    right--;
            }
        }
        return closestSum;
    }
}
