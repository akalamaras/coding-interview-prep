package LinearProgress.Week2.Day11;


public class HappyNumbers {

    // doesnt work
    private boolean isHappy(int n) {
        int number = n;
        if(number == 0) return false;
        int[] digits = digify(n);
        if (number < 10) number = (int) Math.pow(number,2);
        while(number%10 != 0) {
            number = 0;
            for(int digit: digits) {
                number += Math.pow(digit,2);
            }
            digits = digify(number);
        }
        return(digits[0]==1);
    }


    private int[] digify(int n) {
        String temp = Integer.toString(n);
        int[] digits = new int[temp.length()];
        for(int i=0;i < temp.length(); i++) {
            digits[i] = temp.charAt(i) - '0';
        }
        return digits;
    }

    private boolean works(int n) {
        int x = n, y = n;
        while(x > 1) {
            x = calculate(x);
            if( x == 1) return true;
            y = calculate(calculate(y));
            if( y == 1) return true;
            if( x == y) return false;
        }
        return true;
    }

    private int calculate(int n) {
        int x = n, s = 0;
        while(x > 0) {
            s += Math.pow((x%10),2); // s = s + (x%10)*(x%10);
            x = x/10;
        }
        return s;
    }

    public static void main(String[] args) {

        HappyNumbers h = new HappyNumbers();
        System.out.println(h.isHappy(167));
    }
}
