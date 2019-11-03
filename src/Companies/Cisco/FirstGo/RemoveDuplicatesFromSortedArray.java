package Companies.Cisco.FirstGo;

public class RemoveDuplicatesFromSortedArray {


    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element
     * appears only once and return the new length
     * Do not allocate extra space for another array, you must do this by modifying
     * the input array in-place with O(1) extra memory
     *
     * E.g : Given nums [1,1,2]
     *
     *      Your function should return length = 2, with the first  two elements of
     *       nums being 1 and 2 respectively.
     *      It doesnt matter what you leave beyond the returned length.
     */


    // Approach #1 Mine (Accepted, O(n) Time Complexity, O(1) space complexity)
    public int removeDuplicates(int[] nums) {
        if( nums.length < 2) return nums.length;
        // correctArrayIndex keeps track of the final length to be returned
        // temp keeps track of the duplicates that should be skipped
        int correctArrayIndex = 1, temp = 0;
        for(int current = 1; current < nums.length; current++) {

            if(nums[current-1] == nums[current]) {
                temp++;
            } else {
                correctArrayIndex++;
                if(temp == 0) continue;
                nums[current-temp] = nums[current];
            }
        }
        return correctArrayIndex;
    }

    // Approach #2 Cleaner Version (Accepted, O(n) Time Complexity, O(1) space complexity)
    public int removeDuplicatesClean(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
