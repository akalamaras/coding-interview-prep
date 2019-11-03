package Learn.QueueAndStack.Stack;

import java.util.*;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        HashMap<Character,Character> map = new HashMap<Character, Character>() {{
            put('}','{');
            put(']','[');
            put(')','(');
        }};

        for(char c : s.toCharArray()) {

            if(map.containsKey(c)) {
                char top = (stack.isEmpty()) ?   '@'   : stack.pop();
                if( top != map.get(c))
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
