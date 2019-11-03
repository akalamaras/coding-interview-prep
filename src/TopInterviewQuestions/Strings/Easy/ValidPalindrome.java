package TopInterviewQuestions.Strings.Easy;

import java.util.ArrayList;

public class ValidPalindrome {

    public boolean isValid(String s) {

        s = s.toLowerCase();
        ArrayList<Character> list = new ArrayList<>();

        for(char c: s.toCharArray()) {
            if(Character.isAlphabetic(c) || Character.isDigit(c))
                list.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = list.size()-1; i >= 0; i--)
            sb.append(list.get(i--));


        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < list.size(); i++)
            sb2.append(list.get(i++));

        System.out.println(sb.toString());
        System.out.println(sb2.toString());
        return sb.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {

         ValidPalindrome vp = new ValidPalindrome();
         System.out.println(vp.isValid("HEkSPsqs\"?\"3\"?\"rqrPSkEH"));
    }
}
