package Companies.Goldman;

public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {


        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int n : prices) {

            if(n < min)
                min = n;

            maxProfit = Math.max(maxProfit, n - min);
        }
        return maxProfit;
    }


}
