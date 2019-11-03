package Companies.JPMorgan;

import java.util.*;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        if(nums[nums.length-1] != nums.length)
            return nums.length;

        for(int i = 0; i < nums.length; i++) {
            if(i != nums[i])
                return i;
        }
        return -1;
    }
 }
