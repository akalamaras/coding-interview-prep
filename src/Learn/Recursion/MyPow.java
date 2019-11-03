package Learn.Recursion;

public class MyPow {

    private double myPow(double x, int n) {
        if(n==0) return 1;
        if(n== Integer.MIN_VALUE) return 1/x* myPow(x,n+1);
        if(n<0) {
            x = 1/x;
            n = -n;
        }
        return (n%2 == 0) ? myPow(x*x,n/2) : x*myPow(x*x,n/2);
    }

    public static void main(String[] args) {

        MyPow mp = new MyPow();
        System.out.println(mp.myPow(2.1000,3));
    }
}
