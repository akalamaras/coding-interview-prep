package Companies.Apple.SortingAndSearching;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int pivot = findPivot(nums, target);

        int left = 0, right = nums.length - 1;
        while(left <= right) {

            int mid = left + (right - left) / 2;
            int actualMid = (pivot + mid) % nums.length;
            if(actualMid == target)
                return actualMid;
            else if(actualMid < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    private int findPivot(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        if(nums[left] < nums[right])
            return 0;

        while(left < right) {

            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
