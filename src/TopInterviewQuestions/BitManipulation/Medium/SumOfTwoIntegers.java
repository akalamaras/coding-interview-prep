package TopInterviewQuestions.BitManipulation.Medium;

public class SumOfTwoIntegers {

    // Return the sum of two integers without using the '+' sign

    public int getSum(int a, int b) {

        if(b == 0)
            return a;
        else
            return getSum(a ^ b, (a & b) << 1);
    }

    public int getSumIterative(int a, int b) {

        int carry = 0;
        while(b != 0) {

            carry = a & b;

            a = a ^ b;

            b = carry << 1;
        }
        return a;
    }
}
