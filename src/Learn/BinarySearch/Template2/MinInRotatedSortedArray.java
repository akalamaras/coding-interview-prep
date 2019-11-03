package Learn.BinarySearch.Template2;

public class MinInRotatedSortedArray {

    public static void main(String[] args) {

        MinInRotatedSortedArray msa = new MinInRotatedSortedArray();
        int[] array = {4, 5, 6, 0};
        System.out.println(msa.findMin(array));
    }

    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0)
            return -1;

        if(nums.length == 1)
            return nums[0];

        int left = 0, right = nums.length - 1;
        while(left < right) {

            int mid = left + (right - left) / 2;

            if(mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];

            if(nums[left] <= nums[mid] && nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[left];
    }
}
