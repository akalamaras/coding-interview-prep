package LinearProgress.Week1.Day7;

import Support.*;

public class ConvertArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0,nums.length-1);
    }

    private TreeNode makeTree(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = low + (high-low)/2; // avoids integer overflow
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums, low, mid-1);
        node.right = makeTree(nums,mid+1,high);
        return node;
    }
}
