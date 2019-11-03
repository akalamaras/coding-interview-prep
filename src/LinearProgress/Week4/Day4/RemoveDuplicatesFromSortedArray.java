package LinearProgress.Week4.Day4;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            int length = 0;
            for(int n: nums) if(set.add(n)) nums[length++] = n;
            return length;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rem = new RemoveDuplicatesFromSortedArray();
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(rem.removeDuplicates(array));
    }
}
