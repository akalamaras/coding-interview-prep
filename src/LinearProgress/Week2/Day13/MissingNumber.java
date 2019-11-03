package LinearProgress.Week2.Day13;

import java.util.*;

public class MissingNumber {

    private int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int n: nums) {
            if(n>max) max = n;
            set.add(n);
        }
        for(int i=0;i<max;i++) {
            if(set.add(i)) return i;
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] array = {0};
        MissingNumber m = new MissingNumber();
        System.out.println(m.missingNumber(array));
    }
}
