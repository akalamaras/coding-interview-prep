package Variations.Stock;

public class BestTimeToBuySellStockII {

    /**
     * Design an algorithm to find the maximum profit. You may complete as many
     * transactions as you like (i.e., buy one and sell one share of the stock multiple times).
     *
     * Note: You may not engage in multiple transactions at the same time
     * (i.e., you must sell the stock before you buy again).
     *
     */

    /** Approach #1 Peak Valley */
    public int maxProfit(int[] prices) {

        int valley;
        int peak;
        int maxProfit = 0;

        int i = 0;
        while(i < prices.length-1) {

            // Find the valley
            while(i < prices.length-1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];

            // Find the peak
            while(i < prices.length-1 && prices[i] <= prices[i+1])
                i++;

            peak = prices[i];

            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}
