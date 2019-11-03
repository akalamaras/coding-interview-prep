package TopInterviewQuestions.Arrays.Easy;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int insertPosition = 0;
        for(int n: nums) {
            if(n != 0)
                nums[insertPosition++] = n;
        }

        while(insertPosition < nums.length)
            nums[insertPosition++] = 0;
    }
}
