package TopInterviewQuestions.SortingAndSearching.Hard;

public class MedianOfTwoSortedArrays {

    public double findMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null || nums1.length == 0)
            return findMedian(nums1);

        if(nums2 == null || nums2.length == 0)
            return findMedian(nums2);

        int[] array = new int[nums1.length + nums2.length];
        int pointer1 = 0, pointer2 = 0;

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

    private double findMedian(int[] array) {

        if(array.length % 2 != 0)
            return (double) array[array.length / 2];
        else
            return ((double) array[(array.length / 2) - 1] + (double) array[array.length / 2]) / 2;
    }
}
