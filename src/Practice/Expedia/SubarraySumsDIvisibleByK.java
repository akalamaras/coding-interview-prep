package Practice.Expedia;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDIvisibleByK {

    public int subarraysDivisibleByK(int[] A, int K) {

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Empty array equals to 0 so the count is 1 from the very beginning

        int sum = 0;
        for(int a : A) {

            sum += a;
            if(K != 0)
                sum %= K;

            if(sum < 0)
                sum += K; // For example,  -1 % 16 = -1 BUT we need the positive mod 15

            result += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
