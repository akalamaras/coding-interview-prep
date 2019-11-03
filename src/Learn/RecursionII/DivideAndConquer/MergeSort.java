package Learn.RecursionII.DivideAndConquer;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] nums) {

        if(nums.length <= 1)
            return nums;

        int pivot = nums.length / 2;

        int[] leftList = mergeSort(Arrays.copyOfRange(nums,0,pivot));
        int[] rightList = mergeSort(Arrays.copyOfRange(nums,pivot,nums.length));
        return merge(leftList , rightList);
    }

    public int[] merge(int[] leftList, int[] rightList) {

        int[] res = new int[leftList.length + rightList.length];

        int leftP = 0;
        int rightP = 0;
        int resP = 0;

        while(leftP < leftList.length && rightP < rightList.length) {

            if(leftList[leftP] < rightList[rightP])
                res[resP++] = leftList[leftP++];
            else
                res[resP++] = rightList[rightP++];

        }

        // Append the remaining elements to the list
        while(leftP < leftList.length)
            res[resP++] = leftList[leftP++];

        while(rightP < rightList.length)
            res[resP++] = rightList[rightP++];

        return res;
    }
}
