package LinearProgress.Week2.Day14;

import Support.TreeNode;

public class TreePathSum {

    private boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left == null && root.right == null) return (root.val==sum);
        return(hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));
    }
}
