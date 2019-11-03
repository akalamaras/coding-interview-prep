package TopInterviewQuestions.Arrays.Medium;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {

    Map<Integer, Integer> mapToMaxValue = new HashMap<>();

    public int arrayNesting(int[] nums) {

        int max = 0;
        for(int i = 0; i < nums.length; i++) {

            Set<Integer> visitedIndices = new HashSet<>();
            int current = i;
            visitedIndices.add(current);

            int currentMax = 0;
            while(!visitedIndices.contains(nums[current])) {

                currentMax++;
                visitedIndices.add(current);
                current = nums[current];

                if(mapToMaxValue.containsKey(nums[current])) {
                    currentMax = mapToMaxValue.get(nums[current]);
                    break;
                }
            }
            updateMap(mapToMaxValue, visitedIndices, currentMax);
            max = Math.max(max, currentMax);
        }
        return max;
    }

    private void updateMap(Map<Integer, Integer> map, Set<Integer> visited, int currentMax) {

        for(Integer i : visited)
            map.put(i, Math.max(map.getOrDefault(i, 0), currentMax));
    }
}
