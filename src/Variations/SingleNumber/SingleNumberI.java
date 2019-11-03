package Variations.SingleNumber;

import java.util.*;

public class SingleNumberI {

    public int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int n: nums) {

            if(!set.add(n))
                set.remove(n);
        }

        Object[] array = set.toArray();
        return (int) array[0];
    }
}
