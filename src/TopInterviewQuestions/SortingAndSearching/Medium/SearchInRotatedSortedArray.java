package TopInterviewQuestions.SortingAndSearching.Medium;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int pivot = findPivotIndex(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {

            int mid = left + (right - left) / 2;
            int actualMid = (mid + pivot) % nums.length;

            if(nums[actualMid] == target)
                return actualMid;
            else if(nums[actualMid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    private int findPivotIndex(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

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
