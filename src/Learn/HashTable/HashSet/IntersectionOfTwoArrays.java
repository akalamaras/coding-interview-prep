package Learn.HashTable.HashSet;

import java.util.HashSet;
import java.util.Arrays;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int n : nums1)
            set1.add(n);

        for(int n: nums2)
            set2.add(n);

        if(set1.size() < set2.size())
            return set_intersection(set1,set2);
        else
            return set_intersection(set2,set1);
    }

    private int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {

        int[] output = new int[set1.size()];
        int index = 0;

        for(int n: set1) {
            if(set2.contains(n))
                output[index++] = n;
        }

        return Arrays.copyOf(output,index);
    }
}

class Approach2 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int n: nums1)
            set1.add(n);

        for(int n: nums2)
            set2.add(n);

        // use built in retainAll() function
        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int index = 0;
        for(int n: set1)
            output[index++] = n;
        return output;
    }
}
