package TopInterviewQuestions.SortingAndSearching.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerAfterSelf {

    public List<Integer> countSmaller(int[] nums) {

        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {

            int index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

    private int findIndex(List<Integer> sorted, int target) {

        if(sorted.size() == 0)
            return 0;

        int left = 0, right = sorted.size() - 1;

        if(sorted.get(right) < target)
            return right + 1;

        if(sorted.get(left) >= target)
            return 0;

        while(left + 1 < right) {

            int mid = left + (right - left) / 2;

            if(sorted.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }

        if(sorted.get(left) >= target)
            return left;
        else
            return right;
    }

    public static void main(String[] args) {

        int[] array = {5,2,6,1};
        CountOfSmallerAfterSelf c = new CountOfSmallerAfterSelf();
        System.out.println(c.countSmaller(array));
    }
}
