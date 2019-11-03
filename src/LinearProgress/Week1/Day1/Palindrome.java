package LinearProgress.Week1.Day1;

public class Palindrome {

    private boolean isPalindrome(int x) {
        // special cases first
        // when x<0 its not a palindrome
        // if last digit is 0 then first digit has to be 0 -> Only 0 satisfies this
        if( x < 0 || x%10 == 0 && x != 0) {
            return false;
        }
        // now to build up the palindrome
        int reverted = 0;
        while(x > reverted) {
            reverted = reverted * 10 + x%10;
            x /= 10;
        }

        // When the length is odd we don't care about the middle digit
        // i.e in 12321, at the end of the while loop we have x = 12, reverted = 123
        return x == reverted || x == reverted/10;

    }

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(12321));
        System.out.println(palindrome.isPalindrome(1232123));

    }
}
