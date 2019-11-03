package Redos.Medium.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> list = new ArrayList<>();
        int next = lower;
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] < next)
                continue;

            if(nums[i] == next) {
                next++;
                continue;
            }

            // Get the missing range string format
            list.add(getRange(next, nums[i] - 1));

            next = nums[i] + 1;
        }
        if(next <= upper)
            list.add(getRange(next, upper));

        return list;
    }

    private String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d -> %d", n1, n2);
    }
}
