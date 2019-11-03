package Variations.ContainsDuplicate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {


    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNADuplicate(int[] nums, int k, int t) {

        if (t < 0)
            return false;

        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1; // width
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the neighbor buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in neighbor buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    // Time Limit Exceeded
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums.length < 2 || k == 0)
            return false;

        HashMap<Long,Long> map = new HashMap<>();
        int first = -1;
        for(int i = 0; i < nums.length; i++) {

            for(Map.Entry<Long,Long> entry : map.entrySet()) {
                if(Math.abs(nums[i] - entry.getKey()) <= t)
                    return true;
            }

            if(map.size() == k) {
                map.remove((long) nums[first]);
                first++;
            }

            if(map.isEmpty())
                first = i;
            map.put((long) nums[i],(long) i);
        }
        return false;
    }

    public static void main(String[] args){

        ContainsDuplicateIII cd = new ContainsDuplicateIII();
        System.out.println(cd.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3));
    }
}
