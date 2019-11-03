package Learn.BinarySearch.Template2;

public class Template2 {

    public int binarySearch(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left < right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        // Post processing
        // End condition : left == right
        if(left != nums.length && nums[left] == target)
            return left;
        return -1;
    }
}
