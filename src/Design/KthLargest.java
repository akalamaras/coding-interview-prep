package Design;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        heap = new PriorityQueue<>(k);

        for(int n : nums)
            add(n);
    }

    public int add(int n) {

        if (heap.size() < k)
            heap.offer(n);
        else if (heap.peek() < n) {
            heap.poll();
            heap.offer(n);
        }
        return heap.peek();
    }
}
