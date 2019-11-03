package Learn.RecursionII.DivideAndConquer;

public class QuickSort {

    public int[] quickSort(int[] nums) {

        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {

        if(left < right) {
            int pivot = partition(nums,left,right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {

        int pivot = nums[right];

        for(int i = left; i < right; i++) {

            if(nums[i] < pivot) {

                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        return left;
    }
}
