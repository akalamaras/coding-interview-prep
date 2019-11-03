package Companies.Bloomberg.ArraysAndStrings;

public class MergeSortedArray {

    public static void main(String[] args) {

        MergeSortedArray ms = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        ms.merge(nums1,3,nums2,3);

        for(int n : nums1)
            System.out.print(n + " ");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int insertPointer = nums1.length - 1;
        int onePointer = m - 1;
        int twoPointer = n - 1;


        while(onePointer >= 0 && twoPointer >= 0) {

            if(nums1[onePointer] > nums2[twoPointer]) {
                nums1[insertPointer] = nums1[onePointer];
                insertPointer--;
                onePointer--;
            } else {
                nums1[insertPointer] = nums2[twoPointer];
                insertPointer--;
                twoPointer--;
            }
        }
        while(twoPointer >= 0) {
            nums1[insertPointer] = nums2[twoPointer];
            insertPointer--;
            twoPointer--;
        }
    }
}
