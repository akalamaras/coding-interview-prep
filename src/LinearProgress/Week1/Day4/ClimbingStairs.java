package LinearProgress.Week1.Day4;

public class ClimbingStairs {

    // basically fibonacci
    private int stairs(int n) {
        if(n==1) return n;
        if(n<=0) return 0;
        int first = 1;
        int second = 2;
        for(int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {

        ClimbingStairs cl = new ClimbingStairs();
        System.out.println(cl.stairs(15));
    }
}
