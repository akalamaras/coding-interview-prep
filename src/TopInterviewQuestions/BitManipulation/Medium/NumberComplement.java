package TopInterviewQuestions.BitManipulation.Medium;

public class NumberComplement {

    public int findComplement(int n) {

        int ret = 0;

        // Create a mask of 1's -> 1111111111
        while(ret < n) {
            ret = (ret << 1) | 1;
        }
        // return the mask - the number to find the complement
        return ret - n;
    }

    public static void main(String[] args) {

        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplement(5));
    }
}
