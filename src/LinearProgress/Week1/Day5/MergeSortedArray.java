package LinearProgress.Week1.Day5;

public class MergeSortedArray {

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while( i >= 0 && j >= 0 )
        {
            if( nums1[ i ] > nums2[ j ] )
                nums1[ k-- ] = nums1[ i-- ];
            else
                nums1[ k-- ] = nums2[ j-- ];
        }

        while( j >= 0 )
            nums1[ k-- ] = nums2[ j-- ];
    }


    private void oneLiner(int[] A, int m, int[] B, int n) {
        while(n>0) A[m+n-1] = (m==0||B[n-1] > A[m-1]) ? B[--n] : A[--m];
        /*  explained

        while(n>0) {
            if( m == 0 || B[n-1] > A[m-1]) {
                A[m+n-1] = B[n];
                n--;
            } else {
                A[m+n-1] = A[m];
                m--;
            }
        }
         */
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,5,6,0,0,0,0}, nums2 = {2,5,7,8};
        MergeSortedArray m = new MergeSortedArray();
        m.merge(nums1,5,nums2,4);
        for(int num: nums1) System.out.println(num);


    }
}
