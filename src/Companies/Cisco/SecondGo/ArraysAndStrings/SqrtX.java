package Companies.Cisco.SecondGo.ArraysAndStrings;

public class SqrtX {

    public int mySqrt(int x) {

        if(x < 2)
            return x;

        int left = (int) Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;

        return (long) right * right > x ? left : right;
    }

    public int mySqrt2(int x) {

        if(x < 2)
            return x;

        int left = 2, right = x / 2;
        while(left <= right) {

            int mid = left + (right - left) / 2;
            long num = (long) mid * mid;

            if(num == x)
                return mid;
            else if(num < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}
