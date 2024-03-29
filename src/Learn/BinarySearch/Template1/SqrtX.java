package Learn.BinarySearch.Template1;

public class SqrtX {

    public int newton(int x) {

        long r = x;
        while(r * r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }


    public int mySqrt(int x) {

        if(x == 0)
            return 0;

        int left = 1;
        int right = x / 2;

        while(true) {

            int mid = left + (right - left) / 2;

            if(mid > x / mid)
                right = mid - 1;
            else if(mid + 1 > x/(mid + 1))
                return mid;
            else
                left = mid + 1;
        }
    }
}
