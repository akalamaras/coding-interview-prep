package Learn.ArrayAndString;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {6, 7, 8, 9, 10};
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        System.out.println(m.findMedian(nums1,nums2));
    }

    public double findMedian(int[] nums1, int[] nums2) {

        if(nums1 == null || nums1.length == 0)
            return findMedian(nums2);

        if(nums2 == null || nums2.length == 0)
            return findMedian(nums1);

        int pointer1 = 0;
        int pointer2 = 0;
        int[] array = new int[nums1.length + nums2.length];

        for(int i = 0; i < array.length; i++) {

            if(pointer1 == nums1.length) {
                array[i] = nums2[pointer2++];
                continue;
            }

            if(pointer2 == nums2.length) {
                array[i] = nums1[pointer1++];
                continue;
            }

            if(nums1[pointer1] < nums2[pointer2])
                array[i] = nums1[pointer1++];
            else
                array[i] = nums2[pointer2++];
        }
        return findMedian(array);
    }

    private double findMedian(int[] nums) {

        if(nums.length%2 == 0)
            return ((double) nums[nums.length / 2] + (double) nums[nums.length / 2 - 1]) / 2;
        else
            return (double) nums[nums.length / 2];
    }
}
