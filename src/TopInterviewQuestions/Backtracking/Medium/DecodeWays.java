package TopInterviewQuestions.Backtracking.Medium;

public class DecodeWays {

    public static void main(String[] args) {

        DecodeWays dw = new DecodeWays();
        dw.numEncodings("226");
    }


    class DP {

        public int numDecodings(String s) {

            if(s == null || s.length() == 0)
                return 0;

            int[] table = new int[s.length() + 1];
            table[0] = 1;
            table[1] = (s.charAt(0) == '0') ? 0 : 1;
            for(int i = 2; i <= s.length(); i++) {

                int first = Integer.valueOf(s.substring(i - 1, i));
                int second = Integer.valueOf(s.substring(i - 2, i));

                if(first >= 1 && first <= 9)
                    table[i] += table[i - 1];

                if(second >= 10 && second <= 26)
                    table[i] += table[i - 2];
            }
            return table[s.length()];
        }
    }

    private int number;

    public int numEncodings(String s) {

        number = 0;
        if(Integer.parseInt(s) == 0)
            return number;

        backtrack(s, 0, new StringBuilder());
        return number;
    }

    private void backtrack(String s, int index, StringBuilder sb) {

        // Base case
        if(sb.length() == s.length()) {
            number++;
            return;
        }

        if(Character.getNumericValue(s.charAt(index)) == 0)
            return;

        // Branching
        sb.append(s.charAt(index));
        backtrack(s, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        if(index < s.length() - 1) {
            long potential = Long.parseLong(s.substring(index, index + 2));
            System.out.println(potential);
            if(potential <= 26) {

                sb.append(s.charAt(index));
                sb.append(s.charAt(index + 1));
                backtrack(s, index + 2, sb);
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}




