package Learn.BinarySearch;

public class FindTheDuplicate {

    // Pigeonhole principle
    public int findDuplicate(int[] nums) {

        int left = 0, right = nums.length - 1;

        while(left < right) {

            int mid = left + (right - left) / 2;

            int count = 0;
            for(int n : nums) {
                if(n <= mid)
                    count++;
            }

            if(count <= mid)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
