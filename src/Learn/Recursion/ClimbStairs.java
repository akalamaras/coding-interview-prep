package Learn.Recursion;

public class ClimbStairs {

    private int stairs(int n) {

        if(n==1) return n;
        if(n<1) return 0;
        int first = 1, second = 2;
        for(int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;

    }
}
