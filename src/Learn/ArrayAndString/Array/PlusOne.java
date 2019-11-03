package Learn.ArrayAndString.Array;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        for(int i = digits.length-1; i >= 0; i--) {

            if(i == digits.length-1)
                digits[i]++;

            if(i == 0 && digits[i] == 10) {
                digits[i] = 0;
                int[] ret = new int[digits.length+1];
                ret[0] = 1;
                System.arraycopy(digits,0,ret,1,digits.length);
                return ret;

            }

            if(i > 0 && digits[i] == 10) {
                digits[i] = 0;
                digits[i-1]++;
            }
        }

        return digits;

    }
}
