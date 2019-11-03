package LinearProgress.Week4.Day3;

import java.util.*;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums) {
            if(!set.add(n)) {
                set.remove(n);
                list.add(n);
            }
        }
        return list;
    }

    /**
     * Since 1 <= A[i] <= n where n = the size of the array, the concept is to negate each number's index
     * Once a value is negated, if it needs to be negated again, then it is a duplicate
     * O(n) time O(1) space
     */
    public List<Integer> findDupes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length;i++) {
            int index = Math.abs(nums[i]);
            if( nums[index-1] > 0) nums[index-1] = - nums[index-1];
            else list.add(index);
        }
        return list;

    }

    public static void main(String[] args) {
        FindAllDuplicates fad = new FindAllDuplicates();
        int[] array = {4,3,2,7,8,2,3,1};
        List<Integer> l = fad.findDuplicates(array);
        for(int n:l) System.out.println(n);
    }
}
