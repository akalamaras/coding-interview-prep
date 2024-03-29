package Companies.Microsoft.ArraysAndStrings;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if(s == null || s.length() == 0)
            return true;

        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left < right) {

            if(!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            else if(!Character.isLetterOrDigit(s.charAt(right)))
                right--;
            else {
                if(s.charAt(left) != s.charAt(right))
                    return false;

                left++;
                right--;
            }
        }
        return true;
    }
}
