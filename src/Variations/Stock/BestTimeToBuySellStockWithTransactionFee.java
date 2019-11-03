package Variations.Stock;

public class BestTimeToBuySellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {

        int cash = 0;
        int hold = - prices[0];

        for(int i = 1; i < prices.length; i++) {
            // we either sell our stock or do nothing
            cash = Math.max(cash, hold + prices[i] - fee);
            // or buy a stock or do nothing
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
