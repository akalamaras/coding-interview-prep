package TopInterviewQuestions.Arrays.Medium;

import java.util.Arrays;

public class ReverseWordsInStringII {

    public static void main(String[] args) {

        ReverseWordsInStringII rev = new ReverseWordsInStringII();
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        rev.reverseWords(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseWords(char[] s) {

        int left = 0, right = s.length - 1;
        while(left < right) {
            swap(s, left, right);
            left++; right--;
        }

        int i = 0;
        while(i < s.length) {

            if(s[i] != ' ') {
                int index = findWordEnd(s, i + 1);
                int lo = i, hi = index;
                while(lo < hi) {
                    swap(s, lo, hi);
                    lo++; hi--;
                }
                i = index + 1;
            } else
                i++;
        }
    }

    private int findWordEnd(char[] s, int start) {
        int i = start;
        while(i < s.length && s[i] != ' ')
            i++;
        return i - 1;

    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
