package Companies.Apple.ArraysAndStrings;

public class StringToInteger {

    public int myAtoi(String s) {

        if(s.length() == 0)
            return 0;

        char[] array = s.toCharArray();
        int i = 0;
        while(i < array.length && array[i] == ' ')
            i++;

        if(i == array.length - 1)
            return 0;

        int sign = 1;
        if(array[i] == '+' || array[i] == '-')
            sign = array[i++] == '+' ? 1 : -1;

        int total = 0;
        while(i < array.length) {

            int digit = array[i] - '0';

            if(digit < 0 || digit > 9)
                break;

            // Overflow check
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            i++;
        }
        return sign * total;
    }
}
