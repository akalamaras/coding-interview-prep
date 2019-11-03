package Redos.Easy.ArraysAndStrings;

public class BestTimeToBuySellStockII {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int i = 0;
        while(i < prices.length - 1) {

            while(i < prices.length - 1 && prices[i + 1] <= prices[i])
                i++;
            int low = prices[i];

            while(i < prices.length - 1 && prices[i + 1] >= prices[i])
                i++;
            int high = prices[i];

            maxProfit += (high - low);
        }
        return maxProfit;
     }
}
