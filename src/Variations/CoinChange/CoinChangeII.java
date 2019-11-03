package Variations.CoinChange;

public class CoinChangeII {

    public static void main(String[] args) {

        CoinChangeII cc = new CoinChangeII();
        System.out.println(cc.change(5, new int[] {1,2,5}));
    }

    private int count = 0;

    public int change(int amount, int[] coins) {

        if(amount == 0 || coins == null || coins.length == 0)
            return 0;

        backtrack(coins,amount,0);
        return count;

    }

    private void backtrack(int[] coins, int amount, int start) {

        // Base case
        if(amount == 0) {
            count++;
            return;
        }

        if(amount < 0)
            return;

        // Backtracking
        for(int i = start; i < coins.length; i++) {


            amount -= coins[i];
            backtrack(coins, amount, i);
            amount += coins[i];
        }

    }
}
