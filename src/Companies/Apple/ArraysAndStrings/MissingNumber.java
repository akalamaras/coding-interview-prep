package Companies.Apple.ArraysAndStrings;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        int[] copy = nums.clone();
        Arrays.sort(copy);
        for(int i = 0; i < copy.length; i++)
            if(i != copy[i])
                return i;
        return copy.length;
    }

    public int missingNumber2(int[] nums) {

        int xor = 0, i;
        for(i = 0; i < nums.length; i++)
            xor = xor ^ i ^ nums[i];
        return xor;
    }
}
