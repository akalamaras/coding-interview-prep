package Companies.Goldman;

import java.util.*;

public class HighFive {

    public static void main(String[] args) {

        int[][] input = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87},
                {1, 100}, {2, 100}, {2, 76}, {3, 15}};

        HighFive hf = new HighFive();
        int[][] output = hf.highFive(input);
        for(int i = 0; i < output.length; i++)
            System.out.println(output[i][0] + " " + output[i][1]);

    }

    public int[][] highFive(int[][] items) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] n : items) {
            List<Integer> temp = map.getOrDefault(n[0], new ArrayList<>());
            temp.add(n[1]);
            map.put(n[0], temp);
        }

        for(List<Integer> lists : map.values())
            Collections.sort(lists, Collections.reverseOrder());

        int[][] answer = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            answer[i][0] = entry.getKey();
            answer[i][1] = findHighFive(entry.getValue());
            i++;
        }
        return answer;
    }

    private int findHighFive(List<Integer> list) {
        int sum = 0;
        for(int i = 0; i< list.size() && i < 5; i++)
            sum += list.get(i);
        return sum / 5;
    }
}
