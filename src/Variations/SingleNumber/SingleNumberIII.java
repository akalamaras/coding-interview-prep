package Variations.SingleNumber;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int n: nums) {

            if(!set.add(n))
                set.remove(n);
        }

        Object[] array = set.toArray();
        return new int[] {(int) array[0],(int)array[1]};
    }

    // Bit manipulation
    public int singleNum(int[] nums) {

        int a = 0;
        for(int n : nums)
            a ^= n;

        return a;
    }

    /* Explanation

         If we take the XOR of 0 and some bit, it returns that bit.
         If we take the XOR of two same bits, it returns 0.

         So if we take the XOR of all numbers, it will give us the only one that doesnt repeat
         because the XOR does not cancel it out.
     */
}
