package Companies.Bloomberg.ArraysAndStrings;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {

        MoveZeroes mz = new MoveZeroes();
        int[] array = {1, 0, 0, 0, 0, 0, 0, 0, 0};
        mz.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes(int[] nums) {

        int zeroPointer = 0;
        int otherPointer = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[zeroPointer] == 0 && nums[otherPointer] == 0)
                otherPointer++;
            else if(nums[zeroPointer] == 0 && nums[otherPointer] != 0) {
                swap(nums, zeroPointer, otherPointer);
                zeroPointer++;
                otherPointer++;
            }
            else {
                zeroPointer++;
                otherPointer++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
