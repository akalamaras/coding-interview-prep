package Variations.CoinChange;

public class CoinChangeI {

    private int minAmount = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0)
            return 0;

        backtrack(coins, amount, 0, 0);
        return (minAmount == Integer.MAX_VALUE) ? -1 : minAmount;
    }

    private void backtrack(int[] coins, int amount, int current, int start) {

        // Base case
        if(amount == 0) {
            minAmount = Math.min(minAmount, current);
            return;
        }

        if(amount < 0)
            return;

        for(int i = start; i < coins.length; i++) {

            amount -= coins[i];
            backtrack(coins, amount, current + 1, i);
            amount += coins[i];
        }
    }
}
