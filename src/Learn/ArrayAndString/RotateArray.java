package Learn.ArrayAndString;

public class RotateArray {


    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length == 0)
            return;

        if( k >= nums.length)
            k = k%nums.length;

        if( k <= 0)
            return;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {

        int left = start;
        int right = end;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        RotateArray ra = new RotateArray();
        int[] nums = {1,2,3,4,5,6};
        ra.rotate(nums,12);
        for(int n : nums)
            System.out.print(n);
    }
}
