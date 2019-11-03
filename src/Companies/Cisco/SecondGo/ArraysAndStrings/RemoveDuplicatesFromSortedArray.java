package Companies.Cisco.SecondGo.ArraysAndStrings;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] array = {1,1,2,3,3,4,5};
        RemoveDuplicatesFromSortedArray rm = new RemoveDuplicatesFromSortedArray();
        System.out.println(rm.removeDupes(array));
        System.out.println(Arrays.toString(array));
    }

    public int removeDupes(int[] nums) {

        int insertPos = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[insertPos]) {
                insertPos++;
                nums[insertPos] = nums[i];
            }
        }
        return insertPos + 1;
    }
}
