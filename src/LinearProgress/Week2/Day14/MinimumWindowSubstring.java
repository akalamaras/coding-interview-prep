package LinearProgress.Week2.Day14;

import java.util.*;

public class MinimumWindowSubstring {

    private String minWindow(String s,String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        // Dictionary to keep count of all the unique characters in t.
        Map<Character,Integer> dictT = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            int count = dictT.getOrDefault(t.charAt(i),0);
            dictT.put(t.charAt(i),count+1);
        }
        // Number of unique characters in t, which needs to be present in our desired window
        int required = dictT.size();
        // left and right pointers
        int left = 0, right = 0;
        // formed is used to keep track of how many unique characters in t are present in our
        // current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have 2 'A's, 1 'B' and one 'C'
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;
        // Dictionary which keeps count of all the unique characters in the current window
        Map<Character,Integer> windowCount = new HashMap<>();
        // ans list of the form (window length, left, right)
        int[] ans = {-1,0,0};
        while(right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            int count = windowCount.getOrDefault(c,0);
            windowCount.put(c,count+1);
            // If the frequency of the current character added equals the desired
            // count in t then increment the formed count by 1
            if(dictT.containsKey(c) && windowCount.get(c).intValue() == dictT.get(c).intValue())
                formed++;
            // Try and contract the window until it ceases to be desirable
            while(left <= right && formed == required) {
                c = s.charAt(left);
                // Save the smallest window up until now
                if( ans[0] == -1 || right-left+1< ans[0]) {
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }
                // The character at the position pointed by the left pointer
                // is no longer part of the window
                windowCount.put(c,windowCount.get(c)-1);
                if(dictT.containsKey(c) && windowCount.get(c).intValue() < dictT.get(c).intValue())
                    formed--;
                // Move the left pointer ahead, this would help to look for a new window.
                left++;
            }
            // Keep expanding the window once we are done contracting.
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2]+1);
    }
}
