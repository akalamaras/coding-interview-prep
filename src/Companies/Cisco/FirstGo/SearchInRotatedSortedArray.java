package Companies.Cisco.FirstGo;

public class SearchInRotatedSortedArray {

    /**
     *  Suppose an array sorted in ascending order is rotated at some pivot unknown to you.
     *  (i.e. [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2])
     *  You are given a target value to search for. If found in the array, return its index.
     *  Otherwise return -1.
     *  You may assume no duplicate exists in the array.
     *
     *  Your algorithm MUST be in the order of O(logn)
     */

    // Best (and only)* Approach. Binary Search
    //           (Accepted, O(logn) time complexity, O(1) space complexity)
    // *I think

    /*
     *  As long as we know the rotation index, we can use binary search to find the target
     *  in O(logn).
     *  So we need a way to find the rotation index in O(logn) or faster
     *
     */


    private int[] nums;
    private int target;


     public int search(int[] nums, int target) {
         this.nums = nums;
         this.target = target;

         if(nums.length == 0)
             return -1;
         if(nums.length == 1)
             return (this.nums[0] == target) ? 0 : -1;

         int rotationIndex = findRotationIndex(0,nums.length-1);

         // if the target is the smallest element
         if(nums[rotationIndex] == target)
             return rotationIndex;
         // if array is not rotated, search in the entire array
         if(rotationIndex == 0)
             return binarySearch(0,nums.length-1);
         if(target < nums[0])
             // search the right side
             return binarySearch(rotationIndex,nums.length-1);
         // search the left side
         return binarySearch(0,rotationIndex);
     }

     // Basic binary search
     public int binarySearch(int left, int right) {
         while(left <= right) {
             int pivot = (left + right) / 2;
             if( nums[pivot] == target)
                 return pivot;
             else {
                 if(nums[pivot] > target)
                     right = pivot -1;
                 else
                     left = pivot+1;
             }

         }
         return -1;
     }

     public int findRotationIndex(int left, int right) {
         if(nums[left] < nums[right])
             return 0;
         while( left <= right) {
             int pivot = (left + right) / 2;
             if(nums[pivot] > nums[pivot+1])
                 return pivot+1;
             else {
                 if(nums[pivot] < nums[left])
                     right = pivot-1;
                 else
                     left = pivot+1;
             }
         }
         return 0;
     }

     public static void main(String[] args) {

         SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
         sirsa.nums = new int[] {2,4,5,6,7,0,1};
         System.out.println(sirsa.findRotationIndex(0,sirsa.nums.length-1));

     }



}

