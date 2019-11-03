package LinearProgress.Week2.Day9;

public class MaximumXOR {

    // naive n^2 version
    private int findMax(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++)
                if (i < j && (nums[i]^nums[j]) > max) {
                    max = nums[i] ^ nums[j];
                }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] array = {3,10,2,8,50,25};
        MaximumXOR max = new MaximumXOR();
        System.out.println(max.findMax(array));

    }
}
