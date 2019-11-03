package Companies.Cisco.ThirdGo;

public class ReverseInteger {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int reverse(int x) {

        int res = 0;
        while(x != 0) {

            int toAdd = x % 10;

            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && toAdd > 7))
                return 0;

            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && toAdd < -8))
                return 0;

            res = res * 10 + toAdd;
            x = x / 10;
        }
        return res;
    }
}
