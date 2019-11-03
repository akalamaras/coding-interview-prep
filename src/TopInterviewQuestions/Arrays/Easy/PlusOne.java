package TopInterviewQuestions.Arrays.Easy;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        for(int i = digits.length-1; i >= 0; i--) {

            if(i == digits.length-1)
                digits[i]++;

            if(i > 0 && digits[i] == 10) {
                digits[i] = 0;
                digits[i-1]++;
            }

            if(i == 0 && digits[i] == 10) {
                digits[i] = 0;

                int[] array = new int[digits.length+1];
                array[0] = 1;
                System.arraycopy(digits,0,array,1,digits.length);
                return array;
            }
        }
        return digits;
    }

}
