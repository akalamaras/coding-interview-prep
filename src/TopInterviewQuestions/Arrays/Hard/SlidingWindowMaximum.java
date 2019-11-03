package TopInterviewQuestions.Arrays.Hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {


    public int[] maxHeap(int[] nums, int k) {

        if(k == 0 || nums.length == 0)
            return new int[0];

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        int[] answer = new int[nums.length - k + 1];

        for(int i = 0; i < k; i++)
            heap.offer(nums[i]);

        for(int i = 0; i < answer.length; i++) {

            answer[i] = heap.peek();
            heap.remove(nums[i]);
            if(i + k < nums.length)
                heap.offer(nums[i + k]);
        }
        return answer;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k == 0)
            return new int[0];

        int[] ans = new int[nums.length - k + 1];

        if(k == 1)
            return nums;

        int index = 0;
        for(int j = k - 1; j < nums.length; j++) {
            ans[index] = findMax(nums, index, j);
            index++;
        }
        return ans;
    }

    private int findMax(int[] nums, int left, int right) {

        int max = nums[left];
        for(int i = left + 1; i <= right; i++)
            max = Math.max(max, nums[i]);
        return max;
    }
}
