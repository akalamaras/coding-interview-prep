package Companies.Cisco.SecondGo.ArraysAndStrings;

public class ValidPalindrome {

    public static void main(String[] args) {

        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {

            char[] array = s.toCharArray();
            int left = 0, right = array.length - 1;

            while(left < right) {

                while(left < right && !Character.isLetterOrDigit(array[left]))
                    left++;

                while(left < right && !Character.isLetterOrDigit(array[right]))
                    right--;

                if(Character.toLowerCase(array[left++]) != Character.toLowerCase(array[right--]))
                    return false;
            }
            return true;
    }
}
