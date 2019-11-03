package LinearProgress.Week2.Day10;

import java.util.*;

public class MajorityElement {

    private int majority(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
