package LinearProgress.Week2.Day10;

import java.util.*;

public class TwoSumII {

    private int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++) {
            if(numbers[i] > target) return new int[] {0,0};
            int complement = target - numbers[i];
            if(map.containsKey(complement)) return new int[] {map.get(complement)+1,i+1};
            map.put(numbers[i],i);
        }
        return new int[] {0,0};
    }

    private int[] pointers(int[] numbers,int target) {
        int[] returnArray = new int[2];
        if (numbers == null || numbers.length < 2) return returnArray;
        int left = 0, right = numbers.length -1;
        while(left < right) {
            long v = numbers[left] + numbers[right]; // long instead of int to prevent integer overflow
            if(v == target) {
                returnArray[0] = left + 1;
                returnArray[1] = right + 1;
                break;
            } else if (v > target) {
                right--; // since the array is sorted
            } else {
                left++;
            }
        }
        return returnArray;
    }

    private int[] betterPointers(int[] numbers,int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) r--;
            else l++;
        }
        return new int[] {l + 1, r + 1};

    }
}
