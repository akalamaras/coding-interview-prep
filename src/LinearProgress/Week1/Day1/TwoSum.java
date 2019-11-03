package LinearProgress.Week1.Day1;

import java.util.*;

/*
    Simple two sum problem
 */
class TwoSum {
    /*
        Brute force approach... works, I guess
        Time Complexity : O(n^2)
        Space Complexity : O(1)
     */
    private int[] bruteForce(int[] nums, int target) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                }
            }

        }
        throw new IllegalArgumentException("No two sum solution");

    }
    /*
        Using a Hash Map to improve runtime
        We reduce the lookup time from O(n) to O(1) by trading space for speed.
        In the first iteration we add each element's value and index to the table.
        In the second iteration we check if each element's complement exists in the table
     */
    private int[] twoPassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
        Turns out it can be done in one pass.
        While we iterate and inserting elements into the table,
        we also look back to check if current element's complement already exists in the table.
        If it exists, we have found a solution and return immediately.
     */
    private int[] onePassHashTable(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] { i, map.get(complement)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,6,8,3,23,6};
        int target = 26;
        TwoSum solution = new TwoSum();

        // Brute Force approach
        int[] bruteForceArray = solution.bruteForce(array,target);
        System.out.println(bruteForceArray[0]+" "+bruteForceArray[1]);

        // Two pass hash map approach
        int[] twoPassHashArray = solution.twoPassHashTable(array,target);
        System.out.println(twoPassHashArray[0]+" "+twoPassHashArray[1]);
        
        // One pass hash map approach
        int[] onePassArray = solution.onePassHashTable(array,target);
        System.out.println(onePassArray[0]+" "+onePassArray[1]);

    }
}