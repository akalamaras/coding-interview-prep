package LinearProgress.Week2.Day8;

import java.util.*;


public class SubarrayProductLessThanK {


    private int numSubarrayProductLessThanK(int[] nums, int k) {
        int num = 0, pass =0;
        while(pass<nums.length-1) {
            num = this.singlePass(nums,k,pass,num);
            pass++;
        }
        return num;
    }

    private int singlePass(int[] nums, int k, int pass, int number) {
        int currentStart = 0;
        for(int endOfSubarray = pass; endOfSubarray<nums.length;endOfSubarray++) {
            int[] subarray = Arrays.copyOfRange(nums,currentStart,endOfSubarray);
            if(Arrays.stream(subarray).sum() < k){
                number++;
                for(int j=0;j<subarray.length;j++) System.out.print(subarray[j]+" ");
                System.out.println();
            }

            currentStart += pass+1;
            if(currentStart > endOfSubarray) continue;
        }
        return number;
    }

    public static void main(String[] args) {
        int[] array = {10,5,2,6};
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
        System.out.println(s.numSubarrayProductLessThanK(array,100));
    }
}
