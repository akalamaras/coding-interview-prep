package Companies.Goldman;

import java.util.HashMap;
import java.util.Map;

public class PairOfSongsDurationDiv60 {

    public static void main(String[] args) {

        PairOfSongsDurationDiv60 p = new PairOfSongsDurationDiv60();
        int[] array = {30, 20, 150, 100, 40 };
        System.out.println(p.numPairsDivisibleBy60(array));
    }

    public int numPairsDivisibleBy60(int[] time) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int t : time) {

            int div = (60 - (t % 60)) % 60;
            if(map.containsKey(div))
                count += map.get(div);

            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return count;
    }
}
