package TopInterviewQuestions.Arrays.Hard;

import java.util.Arrays;

public class FindMissingPositive {

    public static void main(String[] args) {

        FindMissingPositive fmp = new FindMissingPositive();
        int[] array = {-1, -2, 1, 2, 3, 5};
        System.out.println(fmp.findMissingPositiveConstantSpace(array));
    }

    public int findMissingPositiveConstantSpace(int[] nums) {

        // the algorithm sorts the positives in the beginning of the array and checks
        // which is missing incrementally

        int i = 0;
        while(i < nums.length) {
            // if the number is bigger than the length, we have no place to put it
            if(nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        i = 0;
        while(i < nums.length && nums[i] == i + 1)
            i++;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
