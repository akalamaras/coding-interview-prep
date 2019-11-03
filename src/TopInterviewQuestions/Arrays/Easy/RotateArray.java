package TopInterviewQuestions.Arrays.Easy;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k <= 0)
            return;

        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int left, int right) {

        while(left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
