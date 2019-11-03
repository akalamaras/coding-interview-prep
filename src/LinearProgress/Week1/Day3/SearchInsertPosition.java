package LinearProgress.Week1.Day3;

public class SearchInsertPosition {

    private int searchInsert(int[] nums,int target) {
        for(int i=0;i<nums.length;i++)
            if(nums[i] >= target)  return i;
        return nums.length;
    }


    public static void main(String[] args) {

        int[] array = {0,0,1,2,3};
        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println(sip.searchInsert(array,-1));

    }
}
