package Companies.Apple.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for(int n : nums1)
            set.add(n);

        List<Integer> list = new ArrayList<>();
        for(int n : nums2) {
            if(set.contains(n) && !list.contains(n))
                list.add(n);
        }

        int[] res = new int[list.size()];
        int pointer = 0;
        for(int n : list)
            res[pointer] = list.get(pointer++);

        return res;
    }
}
