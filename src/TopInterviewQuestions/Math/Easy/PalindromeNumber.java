package TopInterviewQuestions.Math.Easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber pm = new PalindromeNumber();
        System.out.println(pm.isPalindrome(0));
    }

    public boolean isPalindrome(int x) {

        if(x < 0)
            return false;

        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while(left < right) {

            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
