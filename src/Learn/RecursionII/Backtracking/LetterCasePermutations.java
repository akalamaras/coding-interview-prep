package Learn.RecursionII.Backtracking;

import java.util.*;

public class LetterCasePermutations {

    public List<String> letterCaseBacktracking(String s) {

        List<String> ans = new ArrayList<>();
        backtrack(ans, 0, s.toCharArray());
        return ans;
     }

     private void backtrack(List<String> ans, int i, char[] s) {

        // Base case
        if(i == s.length) {
            ans.add(new String(s));
            return;
        }

        // If the character is a letter, branch out
        if(Character.isLetter(s[i])) {

            // Upper Case Branch
            s[i] = Character.toUpperCase(s[i]);
            backtrack(ans, i + 1, s);

            // Lower Case Branch
            s[i] = Character.toLowerCase(s[i]);
            backtrack(ans, i + 1, s);

        } else
            // otherwise, continue without branching
            backtrack(ans, i + 1, s);
     }

    public List<String> letterCaseBitShifting(String s) {

        List<String> ans = new ArrayList<>(Arrays.asList(s));

        for(int i = 0; i < s.length(); i++) {

            for(int j = ans.size() - 1; j >= 0 && Character.isLetter(i); j--) {

                char[] characters = ans.get(j).toCharArray();

                characters[i] ^= 1 << 5;
                /*
                    Explanation :

                       'a' - 'A' = 97 - 65 = 32 = 2 ^ 5
                       char ^ (1 << 5) means to swap the 6th bit, which also means to +/-32
                       when the 6th bit is 0/1
                        In other words
                            if the char is lowercase (6th bit is 1), we subtract 32 to the char value
                                to make it uppercase.
                            if the char is uppercase (6th bit is 0), we add 32 to the char value
                                to make it lowercase.
                 */
                ans.add(String.valueOf(characters));
            }
        }
        return ans;







    }

    public List<String> letterCase(String s) {

        List<String> ans = new ArrayList<>();
        ans.add(s);
        /* List<String> ans = new ArrayList<>(Arrays.asList(s)); */


        for(int i = 0; i < s.length(); i++) {
            for(int j = ans.size() - 1; j >= 0; j--) {

                if(Character.isLetter(s.charAt(i))) {

                    char[] characters = ans.get(j).toCharArray();
                    // Toggles the case of the character
                    characters[i] += characters[i] < 'a' ? 'a' - 'A' : 'A' - 'a';

                    ans.add(String.valueOf(characters));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        LetterCasePermutations lcp = new LetterCasePermutations();
        lcp.letterCase("a1b2");
    }
}
