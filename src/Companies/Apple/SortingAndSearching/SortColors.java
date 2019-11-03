package Companies.Apple.SortingAndSearching;

public class SortColors {


    public void sortColors(int[] nums) {

        int[] buckets = new int[3];
        for(int n : nums)
            buckets[n]++;

        int pointer = 0;
        int current = 0;
        while(pointer < nums.length) {
            while(buckets[current] > 0) {
                nums[pointer++] = current;
                buckets[current]--;
            }
            current++;
        }
    }


    public void sortColors2(int[] nums) {

        int left = 0, right = nums.length - 1, i = 0;

        while(i <= right) {

            if      (nums[i] == 0)  swap(nums, left++, i++);
            else if (nums[i] == 1)  i++;
            else if (nums[i] == 2)  swap(nums, i, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
