package TopInterviewQuestions.DynamicProgramming.Hard;

public class BestTimeToBuySellStockCooldown {

    public int maxProfit(int[] prices) {

        int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy;
        for(int p : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - p, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + p, prevSell);
        }
        return sell;
    }

    public int maxProfit2(int[] prices) {

        if(prices.length == 0)
            return 0;

        int N = prices.length;

        int[] buy = new int[N];
        int[] sell = new int[N];
        int[] s1 = new int[N];
        int[] s2 = new int[N];

        buy[0] = s1[0] = - prices[0];
        sell[0] = s2[0] = 0;

        for(int i = 1; i < prices.length; i++) {

            buy[i] = s2[i - 1] - prices[i];
            s1[i] = Math.max(s1[i - 1], buy[i - 1]);
            sell[i] = Math.max(s1[i - 1], buy[i - 1]) + prices[i];
            s2[i] = Math.max(s2[i - 1], sell[i - 1]);
        }
        return Math.max(s2[N - 1], sell[N - 1]);
    }
}
