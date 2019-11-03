package Learn.DynamicProgramming;

public class ClimbingStairs {

    public int climbStairs(int n) {

        if(n < 1)
            return 0;

        if(n == 1)
            return 1;

        int[] container = new int[n + 1];
        container[0] = 0;
        container[1] = 1;

        for(int i = 2; i <= n; i++)
            container[i] = container[i - 1] + container[i - 2];

        return container[n];
    }
}
