package TopInterviewQuestions.SortingAndSearching.Medium;

public class DutchNationalFlag {

    public static void main(String[] args) {

        DutchNationalFlag c = new DutchNationalFlag();
        int[] array = {2, 1};
        c.sortColors(array);
        for(int n : array)
            System.out.print(n + " ");
    }

    public void sortColors(int[] nums) {

        int pointer = 0;

        // Forward pass
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] < 1) {
                swap(nums,pointer,i);
                pointer++;
            }
        }

        // Backward pass
        pointer = nums.length - 1;
        for(int i = nums.length - 1; i >= 0 && nums[i] != 0; i--) {

            if(nums[i] > 1) {
                swap(nums, pointer, i);
                pointer--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
