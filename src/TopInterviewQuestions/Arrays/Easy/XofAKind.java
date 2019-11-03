package TopInterviewQuestions.Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class XofAKind {

    public boolean hasGroupSizeX(int[] deck) {

        if(deck.length < 2)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : deck)
            map.put(n, map.getOrDefault(n, 0) + 1);

        int g = - 1;
        for(Integer val : map.values()) {
            if(g == - 1)
                g = val;
            else
                g = gcd(g, val);
        }
        return g >= 2;
     }

     private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
     }
}
