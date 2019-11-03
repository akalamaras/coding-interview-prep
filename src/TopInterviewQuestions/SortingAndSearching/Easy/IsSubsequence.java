package TopInterviewQuestions.SortingAndSearching.Easy;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if(s.isEmpty())
            return true;

        int sPointer = 0;
        for(int tPointer = 0; tPointer < t.length(); tPointer++) {

            if(t.charAt(tPointer) == s.charAt(sPointer)) {
                sPointer++;

                if(sPointer == s.length())
                    return true;
            }
        }
        return false;
    }
}
