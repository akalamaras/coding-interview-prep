package Companies.Goldman;

public class MyAtoi {

    public static void main(String[] args) {

        String s = "-205 My Atoi";
        MyAtoi ma = new MyAtoi();
        System.out.println(ma.myAtoi(s));
    }

    public int myAtoi(String s) {

        if(s == null || s.length() == 0)
            return 0;

        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ')
            i++;

        if(i == s.length())
            return 0;

        int sign = 1;
        if(s.charAt(i) == '+' || s.charAt(i) == '-')
            sign = (s.charAt(i++) == '+') ? 1 : -1;

        int num = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))) {

            // Overflow check
            if(num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' >= 8) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }

            num = num * 10 + s.charAt(i++) - '0';
        }
        return sign * num;
    }
}
