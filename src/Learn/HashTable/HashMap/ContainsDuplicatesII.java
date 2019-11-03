package Learn.HashTable.HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicatesII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            // map.put returns the previous value associated with the key (or null)
            Integer ord = map.put(nums[i],i);
            if(ord != null && i - ord <= k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ContainsDuplicatesII cd2 = new ContainsDuplicatesII();
        int[] nums = {1,2,3,1,2,3};
        System.out.println(cd2.containsNearbyDuplicate(nums,2));
    }
}
