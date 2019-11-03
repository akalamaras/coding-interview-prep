package Companies.Cisco.FirstGo;

public class ReverseInteger {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer
     * Example 1: Input  123
     *            Output 321
     * Example 2: Input  -123
     *            Output -321
     * Example 3: Input  120
     *            Output 21
     */


    // Approach #1 Pop & Push Digits & Check before Overflow
    //           (Accepted, O(logx) Time Complexity , O(1) Space Complexity)
    // Youtube video: https://www.youtube.com/watch?v=ThdOYKsFSK0
    public int reverse(int x) {
        // We can build up the reversed integer one digit at a time. While doing so, we can
        // check beforehand whether or not appending another digit would cause overflow.
        // The only tricky part about this is the overflows
        int rev = 0;
        while (x != 0) {
            int pop = x%10;
            x /= 10;

            /* Integer.MAX_VALUE/10 is used because on this iteration of the
              while loop, rev is not the same length as Integer.MAX_VALUE.
              It is going to be 1 digit less than that.
              So we divide Integer.MAX_VALUE by 10 */

            /* 7 is used because the highest number we can have is
                (2^31) - 1 = 2147483647  (!We were told the number is 32-bit!)
             */
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7))
                return 0;
            /*
               -8 is used because the lowest number we can have is
               -(2^31) = -2147483648    (!We were told the number is 32-bit!)
             */
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;

    }

    // Cleaner version if we are allowed to use long
    public int reverseInt(int x) {

        long res = 0;
        while(x != 0) {
            res = res*10 + x%10;
            x = x/10;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        else
            return (int)res;
    }
}
