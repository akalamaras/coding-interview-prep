package Learn.BinarySearch.Template3;

public class Template3 {

    public static void main(String[] args){

        Template3 t = new Template3();
        int[] array = {0,1,2,3,4,5,6,7};
        System.out.println(t.binarySearch(array,6));
    }

    public int binarySearch(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid;
            else
                right = mid;
        }

        if(nums[left] == target)
            return left;
        if(nums[right] == target)
            return right;
        return -1;
    }
}
