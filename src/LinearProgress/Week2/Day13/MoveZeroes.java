package LinearProgress.Week2.Day13;

public class MoveZeroes {

    private void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int insertPosition = 0;
        for(int n : nums) {
            if ( n != 0) {
                nums[insertPosition] = n;
                insertPosition++;
            }

        }
        while(insertPosition < nums.length) {
            nums[insertPosition] = 0;
            insertPosition++;
        }
    }

    public static void main(String[] args) {

        int[] array = {1,2,0,3,0,0,4,0};
        MoveZeroes m = new MoveZeroes();
        m.moveZeroes(array);
        for(int num: array) System.out.print(num+" ");
    }
}
