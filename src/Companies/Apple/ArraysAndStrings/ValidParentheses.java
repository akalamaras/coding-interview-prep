package Companies.Apple.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>() {{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(!map.containsKey(c))
                stack.push(c);
            else {

                if(stack.isEmpty())
                    return false;

                char expected = stack.pop();
                char actual = map.get(c);
                if(expected != actual)
                    return false;
            }
        }
        return stack.isEmpty();
     }
}
