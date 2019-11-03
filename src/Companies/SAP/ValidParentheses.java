package Companies.SAP;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        for(char c : s.toCharArray()) {

            if(map.containsKey(c)) {

                if(stack.isEmpty())
                    return false;

                char temp = stack.pop();
                if(temp != map.get(c))
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
