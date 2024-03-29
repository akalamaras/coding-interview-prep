package Learn.BinarySearchTrees;

import Support.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {

        if(root == null)
            return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
