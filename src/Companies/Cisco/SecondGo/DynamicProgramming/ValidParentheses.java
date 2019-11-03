package Companies.Cisco.SecondGo.DynamicProgramming;

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

            if(map.containsKey(c)) {

                if(stack.isEmpty())
                    return false;

                int expected = map.get(c);
                int actual = stack.pop();

                if(expected != actual)
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty();

    }
}
