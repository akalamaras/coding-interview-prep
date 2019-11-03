package TopInterviewQuestions.Arrays.Hard;

import java.util.Stack;

public class BasicCalculatorII {

    public static void main(String[] args) {

         BasicCalculatorII bc2 = new BasicCalculatorII();
         System.out.println(bc2.calculate("3+2*2"));
    }

    public int noStack(String s) {

        long result = 0, current = 0;

        int number = 0;
        char sign = '+';

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c >= '0' && c <= '9')
                number = 10 * number + c - '0';

            if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {

                switch(sign) {

                    case '+' :
                        current += number;
                        break;
                    case '-' :
                        current -= number;
                        break;
                    case '*' :
                        current *= number;
                        break;
                    case '/' :
                        current /= number;
                        break;
                }

                if(c == '+' || c == '-' || i == s.length() - 1) {
                    result += current;
                    current = 0;
                }
                sign = c;
                number = 0;
            }
        }
        return (int) result;
    }

    public int calculate(String s) {

        if(s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i)))
                number = number * 10 + s.charAt(i) - '0';

            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {

                if(sign == '-')
                    stack.push(-number);

                else if(sign == '+')
                    stack.push(number);

                else if(sign == '*')
                    stack.push(stack.pop() * number);

                else if(sign == '/')
                    stack.push(stack.pop() / number);

                sign = s.charAt(i);
                number = 0;
            }
        }

        int answer = 0;
        for(int n : stack)
            answer += n;

        return answer;
    }
}
