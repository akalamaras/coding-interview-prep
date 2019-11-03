package Companies.Tesla;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {


    public boolean isValid(String s) {

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i), topElement;
            if(map.containsKey(current)) {
                if(stack.isEmpty())
                    return false;
                else
                    topElement = stack.pop();
                if(topElement != map.get(current))
                    return false;
            } else
                stack.push(current);
        }
        return stack.isEmpty();
    }
}
