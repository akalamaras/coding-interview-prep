package TopInterviewQuestions.SortingAndSearching.Medium;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        if(nums.length == 1)
            return 0;

        for(int i = 0; i < nums.length; i++) {

            if(i == 0)
                if(nums[i] > nums[i + 1])
                    return i;
                else
                    continue;

            if(i == nums.length - 1)
                if(nums[i] > nums[i - 1])
                    return i;
                else
                    continue;

            if(nums[i] > nums[i-1] && nums[i] > nums[i + 1])
                return i;
        }
        return -1;
    }

    public int findPeakElementB(int[] nums) {
        return search(nums, 0, nums.length -1);
    }

    private int search(int[] nums, int left, int right) {

        if(left == right)
            return left;

        int mid = left + (right - left) / 2;
        if(nums[mid] > nums[mid + 1])
            return search(nums, left, mid);
        return search(nums, mid + 1, right);
    }
}
