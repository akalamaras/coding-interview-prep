package Practice.JPMorgan;

public class RemoveDuplicatesSorted {


    public int removeDuplicates(int[] nums) {

        int length = 0;
        for(int i = 0; i < nums.length; i++) {

            if(nums[length] != nums[i]) {
                nums[++length] = nums[i];
            }
        }
        return length + 1;
    }
}
