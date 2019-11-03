package LinearProgress.Week1.Day4;

public class Sqrt {

    private int mySqrt(int x) {
        return (int) Math.sqrt((double) x);
    }

    private int binarySearch(int x) {
        if(x==0) return 0;
        int start = 1, end = x;
        while(start<end) {
            int mid = start + (end - start) / 2;
            if( (mid <= x / mid) && (mid+1)> x/(mid+1)) return mid; // found the number
            if( mid > x / mid) end = mid; // keep checking the left part
            else start = mid+1; //keep checking the right part
        }
        return start;
    }

    private int newton(int x) {
        if(x==0) return 0;
        long i =x;
        while(i>x/i) { i = (i+x/i)/2; }
        return (int)i;
    }

    public static void main(String[] args) {
        Sqrt root = new Sqrt();
        System.out.println(root.mySqrt(8));
        System.out.println(root.binarySearch(8));
        System.out.println(root.newton(8));
    }
}
