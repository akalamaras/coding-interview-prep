package TopInterviewQuestions.SortingAndSearching.Medium;

import java.util.*;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> ans = new ArrayList<>();

        if(nums == null || nums.length == 0 || k == 0)
            return ans;

        Map<Integer,Integer> map = new HashMap<>();

        int max = 0;
        for(int n : nums) {

            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
                max = Math.max(max, map.get(n));
            }
            else
                map.put(n, 1);
        }

        // Max Heap
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap =
                new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));

        // Add all entries to the max heap
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            maxHeap.add(entry);

        while(ans.size() < k ) {
            Map.Entry<Integer,Integer> entry = maxHeap.poll();
            ans.add(entry.getKey());
        }
        return ans;
    }
}
