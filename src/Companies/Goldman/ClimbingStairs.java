package Companies.Goldman;

public class ClimbingStairs {

    /** O(n) time O(n) space */
    class Recurisve {

        public int climbStairs(int n) {
            int[] memoization = new int[n+1];
            return climbStairs(0,n,memoization);
        }

        private int climbStairs(int i, int n, int[] memoization) {

            if(n < i)
                return 0;

            if(n == i)
                return 1;

            if(memoization[i] > 0)
                return memoization[i];

            memoization[i] = climbStairs(i+1,n,memoization) + climbStairs(i+2,n,memoization);
            return memoization[i];
        }
    }

    /** O(n) time O(n) space */
    class DynamicProgramming {

        public int climbStairs(int n) {

            if(n < 1)
                return 0;

            if(n == 1)
                return 1;

            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i <= n; i++)
                dp[i] = dp[i-1] + dp[i-2];

            return dp[n];
        }
    }

    /** O(n) time O(1) space */
    class Fibonacci {

        public int climbStairs(int n) {

            if(n < 1)
                return 0;

            if(n == 1)
                return 1;

            int first = 1;
            int second = 2;
            for(int i = 3; i <= n; i++) {

                int third = first + second;
                first = second;
                second = third;

            }
            return second;
        }
    }
 }
