package TopInterviewQuestions.DynamicProgramming.Medium;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if(amount == 0)
            return 0;

        int res = amount + 1;
        for(int coin : coins) {

            int current = 0;
            if(amount >= coin) {

                int next = coinChange(coins, amount - coin);
                if(next >= 0)
                    current = 1 + next;
            }

            if(current > 0)
                res = Math.min(res, current);
        }
        return (res == amount + 1) ? -1 : res;
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public int coinChange2(int[] coins, int amount) {

        if(amount == 0)
            return 0;

        if(map.containsKey(amount))
            return map.get(amount);

        int n = amount + 1;
        for(int coin : coins) {

            int current = 0;
            if(amount >= coin) {

                int next = coinChange2(coins, amount - coin);
                if(next >= 0)
                    current = 1 + next;
            }
            if(current > 0)
                n = Math.min(n, current);
        }
        int finalCount = (n == amount + 1) ? -1 : n;
        map.put(amount, finalCount);
        return finalCount;
    }
}
