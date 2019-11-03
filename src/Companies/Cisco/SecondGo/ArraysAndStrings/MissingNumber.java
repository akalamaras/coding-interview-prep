package Companies.Cisco.SecondGo.ArraysAndStrings;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(i != nums[i])
                return i;
        }
        return -1;
    }
}
