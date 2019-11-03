package Companies.Goldman;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {

        int[] array = {3, 4, 5, 1, 2};
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
        System.out.println(f.findMin(array));
    }

    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[left])
                left = mid + 1;
            else
                right = mid;

        }
        return nums[left];
    }
}
