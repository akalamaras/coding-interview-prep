package Companies.Apple.DynamicProgramming;

public class BestTimeToBuySellStock {

    public int maxProfit(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int n : nums) {

            if(n < min)
                min = n;

            int current = n - min;
            if(current < max)
                max = current;
        }
        return max;
    }
}
