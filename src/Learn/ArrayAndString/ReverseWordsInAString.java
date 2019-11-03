package Learn.ArrayAndString;

import Learn.ArrayAndString.TwoPointer.ReverseString;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String ret = "";
        // split the string
        String[] split = s.split(" ");

        // trim every word
        for(int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }

        for(int i = split.length-1; i >= 0; i--) {

            // a 'word' in split could be "   " so we want to avoid those
            if(split[i].equals("")) continue;
            ret += split[i].trim() + " ";

        }
        return ret.trim();
    }

    public static void main(String[] args) {

        ReverseWordsInAString rwias = new ReverseWordsInAString();
        System.out.println(rwias.reverseWords("a good   example"));
    }
}
