package TopInterviewQuestions.SortingAndSearching.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {

        KthLargestElement k = new KthLargestElement();
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(k.findKthLargest(array, 4));
    }


    /* O(n log n) time complexity, O(1) space complexity */
    public int findKth(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /* O(n log k) time complexity, O(k) space complexity*/
    public int findKthLargest(int[] nums, int k) {

        // Use of min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // In Java, priority queues are implemented as complete binary trees, therefore the time
        // complexities for some operations are O(log k) time.

        for(int n : nums) {


            heap.offer(n);

            if(heap.size() > k)
                System.out.println(heap.poll());
        }
        return heap.peek();
    }
}
