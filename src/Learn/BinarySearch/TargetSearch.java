package Learn.BinarySearch;

public class TargetSearch {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;
        while(left <= right) {

            int mid = (left+right)/2;

            if(nums[mid] < target)
                left = mid+1;
            else if (nums[mid] > target)
                right = mid-1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        TargetSearch ts = new TargetSearch();
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(ts.search(array,9));
    }
}
