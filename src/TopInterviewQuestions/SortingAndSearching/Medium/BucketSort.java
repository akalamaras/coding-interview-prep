package TopInterviewQuestions.SortingAndSearching.Medium;

import java.util.*;

public class BucketSort {

    public void bucketSort(int[] nums, int bucketNum) {

        /** Create the buckets */
        List<Integer>[] buckets = new List[bucketNum];
        for(int i = 0; i < bucketNum; i++)
            buckets[i] = new LinkedList<>();

        /** Add numbers to buckets */
        for(int n : nums)
            buckets[hash(n)].add(n);

        /** Sort each bucket individually */
        for(List<Integer> bucket : buckets)
            Collections.sort(bucket);

        /** Merge the sorted array */
        int i = 0;
        for(List<Integer> bucket : buckets)
            for(int n : bucket)
                nums[i++] = n;

    }

    private static int hash(int num) {
        return num / 10;
    }
}
