package TopInterviewQuestions.Strings.Easy;

public class ReverseString {

    public void reverse(char[] s) {

        int left = 0;
        int right = s.length-1;

        while(left < right) {

            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
