package TopInterviewQuestions.Math.Easy;

public class PowerOfThree {

    public boolean isPower(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }

    public boolean isPowerOfThree(int n) {
        if(n > 1)
            while(n % 3 == 0)
                n /= 3;
        return n == 1;
    }
}
