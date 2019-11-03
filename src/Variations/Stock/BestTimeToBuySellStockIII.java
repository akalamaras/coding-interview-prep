package Variations.Stock;

/** At most 2 transactions */

public class BestTimeToBuySellStockIII {

    public int maxProfit(int[] prices) {

        int buyFirst = Integer.MIN_VALUE;
        int sellFirst = 0;
        int buySecond = Integer.MIN_VALUE;
        int sellSecond = 0;

        for(int i = 0; i < prices.length; i++) {
            buyFirst = Math.max(buyFirst, -prices[i]);
            sellFirst = Math.max(sellFirst, buyFirst + prices[i]);

            buySecond = Math.max(buySecond, sellFirst - prices[i]);
            sellSecond = Math.max(sellSecond, buySecond + prices[i]);
        }
        return sellSecond;


    }
}
