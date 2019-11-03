package Companies.Apple.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        CoinChange c = new CoinChange();
        int[] coins = new int[] {10, 5, 2, 1};
        int amount = 50;
        System.out.println(c.coinChangeBottomUp(coins, amount));
    }

    public int coinChangeBottomUp(int[] coins, int amount) {

        int max = Integer.MAX_VALUE;
        int[] table = new int[amount + 1];
        Arrays.fill(table, max);

        table[0] = 0;
        for(int subproblem = 1; subproblem <= amount; subproblem++) {
            for(int currentCoin : coins) {

                if(currentCoin <= subproblem)
                    table[subproblem] = Math.min(table[subproblem], table[subproblem - currentCoin] + 1);
            }
        }
        return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
    }

    public int coinChange(int[] coins, int amount) {

        if(amount == 0)
            return 0;

        int leastAmountNeeded = Integer.MAX_VALUE;
        for(int n : coins) {

            int currentAmountNeeded = 0;
            if(amount >= n) {

                int next = coinChange(coins, amount - n);
                if(next >= 0)
                    currentAmountNeeded = next + 1;
            }

            if(currentAmountNeeded != 0)
                leastAmountNeeded = Math.min(leastAmountNeeded, currentAmountNeeded);

        }
        return leastAmountNeeded == Integer.MAX_VALUE ? -1 : leastAmountNeeded;
    }
}
