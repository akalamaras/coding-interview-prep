package LinearProgress.Week3.Day2;

public class RangeSumQuery {

    // brute force -> Time Limit Exceeded
    public int sumRange(int i, int j, int[] nums) {
        int total = 0;
        for(int k = i;k <= j;k++) {
            total += nums[k];
        }
        return total;
    }

    // caching -> ?
    private int sumRangeCache(int i, int j, int[] nums) {
        int[] sum  = new int[nums.length+1];
        for(int k = 0; k <nums.length; k++) {
            sum[k+1] = sum[k] + nums[k];

        }
        return sum[j+1] - sum[i];

    }

    public static void main(String[] args) {
        RangeSumQuery rsq = new RangeSumQuery();
        int[] array = {-2,0,3,-5,2,-1};
        System.out.println(rsq.sumRange(0,5,array));
    }
}
