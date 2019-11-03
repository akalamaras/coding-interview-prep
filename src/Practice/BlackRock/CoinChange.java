package Practice.BlackRock;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] table = new int[amount + 1];
        Arrays.fill(table, Integer.MAX_VALUE);

        table[0] = 0;
        for(int i = 1; i < coins.length; i++) {

            for(int coin: coins) {

                if (coin <= i)
                    table[i] = Math.min(table[i], table[i - coin] + 1);
            }
        }
        return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
     }
}
