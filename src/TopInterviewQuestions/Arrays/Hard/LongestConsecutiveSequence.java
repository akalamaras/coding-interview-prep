package TopInterviewQuestions.Arrays.Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] array = {};
        System.out.println(lcs.longestConsecutive(array));
    }

    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int currentLength = 0, maxLength = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] + 1 == nums[i])
                currentLength++;
            else if(nums[i - 1] == nums[i])
                continue;
            else {
                maxLength = Math.max(maxLength, currentLength + 1);
                currentLength = 0;
            }
        }
        maxLength = Math.max(maxLength, currentLength + 1);
        return maxLength;
    }


    public int longestConsecutiveSubsequence(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);

        int longest = 0;
        for(int n : set) {

            if(!set.contains(n - 1)) {
                int current = n;
                int currentStreak = 1;

                while(set.contains(current + 1)) {
                    current++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}
