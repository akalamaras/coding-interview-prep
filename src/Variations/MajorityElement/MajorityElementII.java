package Variations.MajorityElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {

        final int MAJORITY_COUNT = nums.length / 3 + 1;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int n : nums) {

            if(map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);

            if(map.get(n) ==  MAJORITY_COUNT)
                res.add(n);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(8/3);
    }
}
