package Practice.JPMorgan;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean validParenthesis(String s) {


        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<Character, Character>() {{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {

                if(stack.isEmpty())
                    return false;

                char expected = stack.pop();
                if(expected != map.get(c))
                    return false;

            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
