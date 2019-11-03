package TopInterviewQuestions.Arrays.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumberII {

    public int hashMap(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();

        for(int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);

        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    public int hashSet(int[] nums) {

        Set<Long> set = new HashSet<>();
        long sumArray = 0;
        for(int n : nums) {
            set.add((long) n);
            sumArray += n;
        }

        int sumSet = 0;
        for(Long n : set)
            sumSet += n;

        return (int) ((3 * sumSet - sumArray) / 2);
    }

    public int bitManipulation(int[] nums) {

        // Two bit masks
        int seenOnce = 0;
        int seenTwice = 0;

        for(int n : nums) {
            // First Appearance : Add n to seeOnce
            // Second Appearance : Remove n from seenOnce, add n to seenTwice
            // Third Appearance : Remove from seenTwice
            seenOnce = ~ seenTwice & (seenOnce ^ n);
            seenTwice = ~ seenOnce & (seenTwice ^ n);
        }
        return seenOnce;
    }
}
