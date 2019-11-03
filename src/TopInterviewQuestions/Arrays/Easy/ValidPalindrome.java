package TopInterviewQuestions.Arrays.Easy;

import Companies.Cisco.FirstGo.ThreeSum;

public class ValidPalindrome {

    public static void main(String[] args) {

        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[] {1,2,3,-2,-1,0}));
    }

    public boolean isPalindrome(String s) {

        if(s == null || s.length() == 0)
            return true;

        int left = 0;
        int right = s.length() - 1;

        while(left <= right) {

            char cL = s.charAt(left);
            char cR = s.charAt(right);

            // Skip non alphanumerics
            if(!Character.isLetterOrDigit(cL))
                left++;
            else if(!Character.isLetterOrDigit(cR))
                right--;
            else {

                if(Character.toLowerCase(cL) != Character.toLowerCase(cR))
                    return false;

                left++;
                right--;
            }
        }
        return true;
    }
}
