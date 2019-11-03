package Companies.Cisco.FirstGo;

public class RotateArray {

    /**
     * Given an array, rotate it to the right by k steps, where k is a non negative integer
     * e.g Input : [1,2,3,4,5,6,7] and k = 3
     *     Output : [5,6,7,1,2,3,4]
     */


    // Approach #1 Brute Force (Time Limit Exceeded, O(n*k) time complexity, O(1) space complexity)
    public void rotate(int[] nums, int k) {
        if( nums.length < 2) return;
        for(int i = 0; i < k; i++) {
            int temp = 0, temp2;
            for(int j = 0 ; j < nums.length; j++) {
                if( j+1 == nums.length) {
                   nums[0] = temp;
                } else if ( j == 0 ){
                    temp = nums[j + 1];
                    nums[j+1] = nums[j];
                } else {
                    temp2 = nums[j+1];
                    nums[j+1] = temp;
                    temp = temp2;
                }
            }
        }
        for(int n : nums) {
            System.out.println(n);
        }
    }

    // Approach #2 Using Extra Array (Accepted, O(n) time complexity, O(n) space complexity)
    public void rotateExtra(int[] nums, int k) {
        int[] a = new int[nums.length];
        // make the correct array using the extra one
        for(int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        // change the original to the correct one
        for(int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }

    }

    // Approach #3 Using Reverse (Accepted, O(n) time complexity, O(1) space complexity)
    public void rotateReverse(int[] nums, int k) {
        /* In this approach, we firstly reverse all n elements of the array. Then, reversing the
         k elements of the array followed by reversing the rest n-k elements gives us the
         required result */

        /*
            Example:  Original List                    :   1 2 3 4 5 6 7
                      After reversing all numbers      :   7 6 5 4 3 2 1
                      After reversing first k numbers  :   5 6 7 4 3 2 1
                      After reversing last n-k numbers :   5 6 7 1 2 3 4
         */


        k %= nums.length; // We only need the effective steps ( E.g [1,2,3] & k = 4)


        reverse(nums,0, nums.length-1); // Step 1
        reverse(nums,0,k-1); // Step 2
        reverse(nums,k,nums.length-1); // Step 3

    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }

    public static void main(String[] args) {

        RotateArray rot = new RotateArray();
        int[] array = {-1,-100,3,99};
        rot.rotate(array,2);
    }
}
