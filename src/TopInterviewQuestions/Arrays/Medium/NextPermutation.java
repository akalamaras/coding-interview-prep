package TopInterviewQuestions.Arrays.Medium;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int index = nums.length - 2;
        while(index >= 0 && nums[index + 1] <= nums[index])
            index--;

        if(index >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[index])
                j--;
            swap(nums, index, j);
        }
        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int start) {

        int i = start, j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++; j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
