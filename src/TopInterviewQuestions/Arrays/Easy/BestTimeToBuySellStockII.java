package TopInterviewQuestions.Arrays.Easy;

public class BestTimeToBuySellStockII {

    public int maxprofit(int[] prices) {

        int profit = 0;
        int valley;
        int peak;

        int i = 0;
        while(i < prices.length) {

            while(i < prices.length && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];

            while(i < prices.length && prices[i] <= prices[i+1])
                i++;
            peak = prices[i];

            profit += peak - valley;
        }
        return profit;
    }
}
