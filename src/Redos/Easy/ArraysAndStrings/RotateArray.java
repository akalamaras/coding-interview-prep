package Redos.Easy.ArraysAndStrings;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        int L = left, R = right;
        while(L < R) {
            int temp = nums[L];
            nums[L++] = nums[R];
            nums[R--] = temp;
        }
    }
}
