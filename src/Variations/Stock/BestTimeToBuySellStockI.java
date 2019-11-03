package Variations.Stock;

public class BestTimeToBuySellStockI {

    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {

            if(prices[i] < min)
                min = prices[i];

            int profit = prices[i] - min;
            if(profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }

    public int maxProfitKadane(int[] prices) {

        int currMax = 0, totalMax = 0;
        for(int i = 1; i < prices.length; i++) {

            currMax = Math.max(0, currMax + prices[i] - prices[i - 1]);
            totalMax = Math.max(totalMax, currMax);
        }
        return totalMax;

    }
}
