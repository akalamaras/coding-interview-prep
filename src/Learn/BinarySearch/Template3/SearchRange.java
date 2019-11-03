package Learn.BinarySearch.Template3;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {

        SearchRange sr = new SearchRange();
        int[] array = {1,1,1,1,1,1,1};
        System.out.println(Arrays.toString(sr.searchRange(array,1)));
    }

    public int[] searchRange(int[] nums, int target) {

        int[] ret = {-1,-1};

        int left = 0, right = nums.length -1;
        while(left + 1 < right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                ret = linearSearch(nums, target, mid);
                return ret;
            }
            else if(nums[mid] < target)
                left = mid;
            else
                right = mid;
        }

        if(nums[left] ==  target && nums[right] == target)
            return new int[] {left, right};
        else if(nums[left] == target)
            return new int[] {left, left};
        else if(nums[right] == target)
            return new int[] {right, right};
        else
            return ret;
    }

    private int[] linearSearch(int[] nums, int target, int mid) {

        int leftIndex = mid;
        int rightIndex = mid;

        while(leftIndex > 0 && nums[leftIndex] == nums[leftIndex - 1])
            leftIndex--;

        while(rightIndex < nums.length - 1 && nums[rightIndex] == nums[rightIndex + 1])
            rightIndex++;

        return new int[] {leftIndex, rightIndex};
    }
}
