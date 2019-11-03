package Companies.Apple.SortingAndSearching;

import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class TopKFrequentWords {

    public static void main(String[] args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        TopKFrequentWords topK = new TopKFrequentWords();
        System.out.println(topK.topKFrequentWords(words, 2));

    }

    public List<String> topKFrequentWords(String[] words, int k) {

        // Populate the hash map with the words and their numbers in the array
        Map<String, Integer> map = new HashMap<>();
        for (String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);

        // If the count of two words is the same, we insert based on the keys
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue())
                        ? b.getKey().compareTo(a.getKey())
                        : a.getValue() - b.getValue());

        // Populate the priority queue
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        List<String> result = new ArrayList<>();
        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}
