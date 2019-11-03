package Companies.Cisco.FirstGo;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     *  Given a string, find the length of the longest substring without
     *  repeating characters
     *
     *  Example 1. Input:        "abcabcabc"
     *             Output:       3
     *             Explanation:  The answer is "abc", with a length of 3
     *
     *  Example 2. Input:        "bbbbb"
     *             Output:       1
     *             Explanation:  The answer is "b", with a length of 1
     *
     *  Example 3. Input:        "pwwkew"
     *             Output:       3
     *             Explanation:  The answer is "wke", with a length of 3.
     *
     *  Note: The answer MUST be a substring,
     *        "pwke" is not a substring but a sub sequence of the input
     */

    // Approach #1 Sliding window HashSet
    //      (Accepted, O(n) time complexity, O(n) space complexity)

    /*
     * Use a hash set to track the longest substring without repeating characters
     * thus far, use a fast pointer j to see if character j is in the hash set or not,
     * if not, add it to the hash set, move j forward and update the max length,
     * otherwise, delete from the head using the slow pointer i until we can put
     * character j to the hash set.
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else
                set.remove(s.charAt(i++));
        }
        return max;
    }

    // Approach #2 Sliding window optimized HashMap
    //      (Accepted, O(n) time complexity, O(n) space complexity
    public int lengthOfLongestSubstringOptimized(String s) {
        int max = 0, i = 0;
        Map<Character,Integer> map = new HashMap<>(); // current index of character
        // try to extend to the range [i,j]
        for(int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)),i);
            max = Math.max(max,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return max;
    }
}
