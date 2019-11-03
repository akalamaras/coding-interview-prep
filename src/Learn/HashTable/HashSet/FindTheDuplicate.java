package Learn.HashTable.HashSet;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicate {

    public int findDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int n : nums) {

            if(!set.add(n))
                return n;
        }
        return Integer.MAX_VALUE;
    }
}
