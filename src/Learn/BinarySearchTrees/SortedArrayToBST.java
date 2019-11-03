package Learn.BinarySearchTrees;

import Support.TreeNode;

public class SortedArrayToBST {

    public TreeNode arrayToBST(int[] nums) {

        if(nums == null || nums.length == 0)
            return null;

        TreeNode root = helper(nums,0,nums.length-1);
        return root;
    }

    private TreeNode helper(int[] nums, int left, int right) {

        if(left > right)
            return null;

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums,left,mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
