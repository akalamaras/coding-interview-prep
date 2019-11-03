package LinearProgress.Week1.Day2;

public class RemoveDuplicates {

    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {

        RemoveDuplicates rem = new RemoveDuplicates();
        int[] array = {1,2,2,3,3,4,5,6,6};
        System.out.println(rem.removeDuplicates(array));
    }
}
