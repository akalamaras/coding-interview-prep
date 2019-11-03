package Companies.Apple.TreesAndGraphs;

import Support.TreeNode;

public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        return helper(root, 1);
    }

    private int helper(TreeNode root, int level) {

        if(root == null)
            return level;

        if(root.left != null && root.right != null)
            return Math.max(helper(root.left, level + 1), helper(root.right, level + 1));
        else if(root.left != null)
            return helper(root.left, level + 1);
        else if(root.right != null)
            return helper(root.right, level + 1);
        else
            return level + 1;
    }
}
