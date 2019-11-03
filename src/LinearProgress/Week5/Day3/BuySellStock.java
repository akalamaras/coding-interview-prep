package LinearProgress.Week5.Day3;

public class BuySellStock {


    // We need max(price[j] - price[i]) where i < j

    // Naive, Time complexity O(n^2)
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        for(int i=0; i< prices.length; i++) {
            for(int j = i+1; j<prices.length; j++) {
                int profit = prices[j] - prices[i];
                if( profit > maxProf) maxProf = profit;
            }
        }
        return maxProf;
    }

    // Better one pass O(n)
    public int onePass(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i < prices.length; i++) {
            if(prices[i] < minPrice) minPrice = prices[i];
            else if ( prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

}
