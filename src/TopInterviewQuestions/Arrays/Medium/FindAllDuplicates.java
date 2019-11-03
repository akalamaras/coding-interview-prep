package TopInterviewQuestions.Arrays.Medium;

import java.util.*;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            if(!set.add(n))
                list.add(n);
        }
        return list;
    }

    public List<Integer> findDuplicatesII(int[] nums) {

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1])
                list.add(nums[i]);
        }
        return list;
    }

    public List<Integer> findDuplicatesIII(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                list.add(Math.abs(index + 1));
            nums[index] = - nums[index];
        }
        return list;
    }
}
