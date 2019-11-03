package Learn.HashTable.HashSet;

import java.util.HashSet;

public class SingleNumber {

    public int singleNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int n:nums) {
            if(set.contains(n))
                set.remove(n);
            else
                set.add(n);
        }
        Object[] array = set.toArray();
        return (int) array[0];
    }

    public static void main(String[] args) {

        SingleNumber sn = new SingleNumber();
        int[] nums = {4,1,2,1,2};
        System.out.println(sn.singleNumber(nums));
    }
}
