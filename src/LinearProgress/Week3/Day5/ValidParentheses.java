package LinearProgress.Week3.Day5;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    private HashMap<Character,Character> map;


    public void ValidParentheses() {

        map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
    }
    private boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char t = stack.empty() ? '#' : stack.pop();
                if( map.get(c) != t) return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("(((((((("));
    }
}
