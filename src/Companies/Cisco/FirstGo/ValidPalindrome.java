package Companies.Cisco.FirstGo;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0, right = s.length()-1;
        while(left <= right) {
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    public boolean isIt(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverse = new StringBuffer(s).reverse().toString();
        return s.equals(reverse);
    }

    public static void main(String[] args) {

         ValidPalindrome vp = new ValidPalindrome();
         System.out.println(vp.isPalindrome("ma"));
    }
}
