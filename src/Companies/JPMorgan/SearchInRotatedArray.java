package Companies.JPMorgan;

public class SearchInRotatedArray {


    private int[] nums;
    private int target;


    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return (this.nums[0] == target) ? 0 : -1;

        int rotationIndex = findRotationIndex(0,nums.length-1);

        // if the target is the smallest element
        if(nums[rotationIndex] == target)
            return rotationIndex;
        // if array is not rotated, search in the entire array
        if(rotationIndex == 0)
            return binarySearch(0,nums.length-1);
        if(target < nums[0])
            // search the right side
            return binarySearch(rotationIndex,nums.length-1);
        // search the left side
        return binarySearch(0,rotationIndex);

    }


    public int binarySearch(int left, int right) {
        while(left <= right) {
            int pivot = (left + right) / 2;
            if( nums[pivot] == target)
                return pivot;
            else {
                if(nums[pivot] > target)
                    right = pivot -1;
                else
                    left = pivot+1;
            }

        }
        return -1;
    }


    public int findRotationIndex(int left, int right) {
        if(nums[left] < nums[right])
            return 0;
        while( left <= right) {
            int pivot = (left + right) / 2;
            if(nums[pivot] > nums[pivot+1])
                return pivot+1;
            else {
                if(nums[pivot] < nums[left])
                    right = pivot-1;
                else
                    left = pivot+1;
            }
        }
        return 0;
    }
}
