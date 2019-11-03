package LinearProgress.Week1.Day1;

/*
    https://www.youtube.com/watch?v=ThdOYKsFSK0
 */
public class ReverseInteger {

    private int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int temp = x%10;
            x /= 10;
            if((res > Integer.MAX_VALUE/10) || (res==Integer.MAX_VALUE/10
                    && temp > 7)) return 0;
            if((res < Integer.MIN_VALUE/10) || (res==Integer.MAX_VALUE/10
                    && temp < -8))return 0;
            res = res * 10 + temp;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseInteger rev = new ReverseInteger();
        System.out.println(rev.reverse(432345670));
    }
}
