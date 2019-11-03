package Learn.Recursion;

import java.util.*;

public class ReverseString {

    // Double pointer, faster but more memory
    public void reverseString(char[] s) {
        int pointer1 = 0, pointer2 = s.length-1;
        while(pointer1 < pointer2) {
            char temp = s[pointer1];
            s[pointer1] = s[pointer2];
            s[pointer2] = temp;
            pointer1++;
            pointer2--;
        }
    }

    // MyStack, slow but less memory usage
    public void reverseStringStack(char[] s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s) stack.push(c);
        for(int i=0;i<s.length;i++) s[i] = stack.pop();
    }
}
