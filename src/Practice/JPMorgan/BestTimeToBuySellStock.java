package Practice.JPMorgan;

public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {

        int maxProf = 0;
        for(int i = 0; i < prices.length - 1; i++) {
                if(prices[i + 1] > prices[i])
                    maxProf += prices[i + 1] - prices[i];
        }
        return maxProf;
    }
}
