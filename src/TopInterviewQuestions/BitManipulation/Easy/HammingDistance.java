package TopInterviewQuestions.BitManipulation.Easy;

public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int xor = x ^ y, count = 0;

        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }

    private int oneLiner(int x, int y) {

        return Integer.bitCount(x ^ y);
    }
}
