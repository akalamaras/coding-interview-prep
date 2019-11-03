package LinearProgress.Week1.Day3;

public class PlusOne {

    private int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        return checkDigit(digits,digits.length-1);
    }

    private int[] checkDigit(int[] digits,int currentDigit) {
        try {
            if (digits[currentDigit] == 10) {
                digits[currentDigit] = 0;
                digits[currentDigit - 1]++;
                return checkDigit(digits,currentDigit-1);
            }
            return digits;
        } catch (ArrayIndexOutOfBoundsException e) {
            int[] array = new int[digits.length+1];
            array[0] = 1;
            return array;
        }
    }

    public static void main(String[] args) {

        PlusOne po = new PlusOne();
        int[] array = {8,9,9,9};
        int[] newArray = po.plusOne(array);
        for(int num: newArray) System.out.print(num);
    }
}
