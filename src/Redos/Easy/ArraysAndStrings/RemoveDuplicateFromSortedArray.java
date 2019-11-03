package Redos.Easy.ArraysAndStrings;

public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[i] != nums[j])
                nums[++i] = nums[j];
        }
        return i + 1;
    }
}
