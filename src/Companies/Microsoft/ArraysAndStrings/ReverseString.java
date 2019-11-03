package Companies.Microsoft.ArraysAndStrings;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {

        char[] array = {'h','e','l','l','o'};
        ReverseString rev = new ReverseString();
        rev.reverse(array);
        System.out.println(Arrays.toString(array));
    }

    public void reverse(char[] s) {

        int left = 0, right = s.length -1;
        while(left < right)
            swap(s, left++, right--);

    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
