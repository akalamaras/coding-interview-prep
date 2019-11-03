package TopInterviewQuestions.Backtracking.Hard;

public class WildcardMatching {


    public boolean twoPointer(String s, String p) {

        int sPointer = 0, pPointer = 0, match = 0, startIndx = -1;
        while(sPointer < s.length()) {

            if(pPointer < p.length() && p.charAt(pPointer) == '?' || s.charAt(sPointer) == p.charAt(pPointer)) {
                sPointer++;
                pPointer++;
            }
            else if(pPointer < p.length() && p.charAt(pPointer) == '*') {
                startIndx = pPointer;
                match = sPointer;
                pPointer++;
            }
            else if(startIndx != -1) {

                pPointer = startIndx + 1;
                match++;
                sPointer = match;
            }
            else
                return false;
        }

        while(pPointer < p.length() && p.charAt(pPointer) == '*')
            pPointer++;

        return pPointer == p.length();
    }

    public static void main(String[] args) {

        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch("", "*"));
    }


    public boolean isMatch(String s, String p) {

        // Base case 1
        if(s.equals(p))
            return true;

        if(s.isEmpty())
            return checkRemaining(p);
        else if(p.isEmpty())
            return false;

        // Branching
        char current = s.charAt(0);
        char comp = p.charAt(0);

        if(comp == '?') {
            return isMatch(s.substring(1), p.substring(1));

        } else if(comp == '*'){

            boolean f = false;
            for(int i = 0; i <= s.length(); i++)
                f = f || isMatch(s.substring(i), p.substring(1));
            return f ;

        } else {

            if(current == comp)
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }
    }

    private boolean checkRemaining(String p) {

        if(p.isEmpty())
            return true;

        for(char c : p.toCharArray()) {
            if (c != '*')
                return false;
        }
        return true;
    }
}

class Solution {

    public boolean isMatch(String s, String p) {

        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < sLen) {

            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
                ++sIdx;
                ++pIdx;
            }
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                ++pIdx;
            }
            else if (starIdx == -1) {
                return false;
            }
            else {
                pIdx = starIdx + 1;
                sIdx = sTmpIdx + 1;
                sTmpIdx = sIdx;
            }
        }
        for(int i = pIdx; i < pLen; i++)
            if (p.charAt(i) != '*') return false;
        return true;
    }
}