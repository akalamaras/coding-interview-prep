package Redos.Medium.ArraysAndStrings;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {

        if(s.isEmpty()) return "";

        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {

            int lengthEven = expandAroundCentre(s, i, i);
            int lengthOdd  = expandAroundCentre(s, i, i + 1);

            int length = Math.max(lengthEven, lengthOdd);
            if(length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCentre(String s, int left, int right) {

        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L + 1;
    }
}
