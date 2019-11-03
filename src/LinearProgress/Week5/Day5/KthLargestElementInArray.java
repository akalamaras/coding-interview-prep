package LinearProgress.Week5.Day5;

import java.util.*;

public class KthLargestElementInArray {

    // Approach #1 Naive ( O(nlogn) time complexity, O(1) space complexity)
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return(nums[nums.length - k]);
    }

    // Approach #2 Heap ( O(nlogk)* time complexity, O(k) space complexity)
    // * where k < n
    public int findKthHeap(int[] nums, int k) {


        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }

}
