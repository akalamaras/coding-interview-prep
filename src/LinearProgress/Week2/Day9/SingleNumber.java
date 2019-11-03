package LinearProgress.Week2.Day9;

import java.util.*;

public class SingleNumber {

    // I use a HashSet because it does not allow for duplicates
    private int findNum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            if(!set.add(i)) set.remove(i);
        }
        // since all the duplicates will be removed, the only one left will be the single one
        return set.iterator().next();

    }

    public static void main(String[] args) {

        int[] array = {2,2,1};
        SingleNumber s = new SingleNumber();
        System.out.println(s.findNum(array));
    }
}
