package Learn.ArrayAndString.Array;

public class ValidPalindromeII {

    public boolean isValidPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        boolean foundDiff = false;
        while(left < right) {

            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {

                if(foundDiff)
                    return false;
                else {

                    if(s.charAt(left + 1) == s.charAt(right))
                        left++;
                    else if(s.charAt(right - 1) == s.charAt(left))
                        right--;
                    else
                        return false;

                    foundDiff = true;
                }
                left++;

            }
        }
        return true;
    }
}
