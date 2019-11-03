package Companies.Cisco.SecondGo.ArraysAndStrings;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] array = {};
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        System.out.println(search.search(array, 4));
    }

    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return -1;

        int pivotIndex = findPivotIndex(nums);

        int left = 0, right = nums.length - 1;
        while(left <= right) {

            int mid = left + (right - left) / 2;
            int actualMid = (mid + pivotIndex) % nums.length;

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

        int left = 0, right = nums.length - 1;

        if(nums[left] < nums[right])
            return 0;

        while(left <= right) {

            int mid = left + (right - left) / 2;
            if(mid < nums.length - 1 && nums[mid + 1] < nums[mid])
                return mid + 1;
            else {
                if(nums[mid] < nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return 0;
    }
}
