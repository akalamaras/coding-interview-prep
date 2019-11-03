package Learn.DynamicProgramming;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0)
            return "";

        int[] maxPalindromeStart = new int[1];
        int[] maxPalindromeEnd = new int[1];

        for(int i = 0; i < s.length(); i++) {

            // Assume odd length
            extend(s, i, i, maxPalindromeStart, maxPalindromeEnd);
            // Assume even length
            extend(s, i, i + 1, maxPalindromeStart, maxPalindromeEnd);
        }
        return s.substring(maxPalindromeStart[0], maxPalindromeEnd[0] + 1);

    }

    private void extend(String s, int left, int right, int[] maxPalindromeStart, int[] maxPalindromeEnd) {

        // Loop until invalid match
        while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Go back to valid match
        left++;
        right--;

        if(right - left + 1 > maxPalindromeEnd[0] - maxPalindromeStart[0]) {
            maxPalindromeEnd[0] = right;
            maxPalindromeStart[0] = left;
        }
    }
}
