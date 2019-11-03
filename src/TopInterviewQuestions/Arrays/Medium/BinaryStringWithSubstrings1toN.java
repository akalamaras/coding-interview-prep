package TopInterviewQuestions.Arrays.Medium;

public class BinaryStringWithSubstrings1toN {

    public boolean queryString(String S, int N) {

        for(int i = N; i > N / 2; i--)
            if(S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}
