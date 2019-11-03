package Learn.HashTable.HashMap;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int n: nums1) {
            if(map.containsKey(n))
                // increment by 1
                map.put(n,map.get(n)+1);
            else
                map.put(n,1);
        }

        for(int n: nums2) {
            if(map.containsKey(n) && map.get(n) > 0) {
                // add to results and decrement by 1
                result.add(n);
                map.put(n,map.get(n)-1);
            }
        }

        // change from ArrayList to array
        int[] ret = new int[result.size()];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = result.get(i);
        }

        return ret;
    }
}
