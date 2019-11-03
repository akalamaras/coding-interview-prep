package LinearProgress.Week1.Day2;

public class RemoveElement {

    public int inPlace(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int i=0;
        for(int j=0;j<nums.length;j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;

            }
        }
        return i;
    }

    public static void main(String[] args) {

        RemoveElement rem = new RemoveElement();
        int[] nums = {3,2,2,2,2,2,2,3};
        System.out.println(rem.inPlace(nums,2));
    }
}
