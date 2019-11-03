package TopInterviewQuestions.Arrays.Medium;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0)
            return "";

        // Use arrays in order to pass by reference
        int[] maxStart = new int[1];
        int[] maxEnd = new int[1];

        for(int i = 0; i < s.length() - 1; i++) {

            // Assume odd length
            extend(s, i, i, maxStart, maxEnd);
            // Assume even length
            extend(s, i, i + 1, maxStart, maxEnd);
        }

        return s.substring(maxStart[0], maxEnd[0] + 1);
    }

    private void extend(String s, int i, int j, int[] maxStart, int[] maxEnd) {

        // Loop until we find an invalid match (expands outwards)
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        // Go back to our last valid match
        i++;
        j--;

        // Only change the value in our arrays if we found a bigger substring
        if(j - i + 1 > maxEnd[0] - maxStart[0] + 1) {
            maxEnd[0] = j;
            maxStart[0] = i;
        }
    }
}
