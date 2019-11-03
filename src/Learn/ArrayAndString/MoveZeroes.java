package Learn.ArrayAndString;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;

        int insertPos = 0;
        for(int n: nums) {
            if(n != 0)
                nums[insertPos++] = n;
        }

        while(insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }


}
