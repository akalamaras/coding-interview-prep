package Learn.BinaryTrees;

import Support.TreeNode;

public class MaxDepth {

    private int maxDepth(TreeNode root) {
        if( root == null) return 0;
        int level = 1;
        return helper(root,level);
    }

    private int helper(TreeNode root, int level) {
        if( root == null ) return level;
        int leftSub = (root.left == null) ? level : helper(root.left,level+1);
        int rightSub = (root.right == null) ? level : helper(root.right,level+1);
        return Math.max(leftSub,rightSub);
    }

    public int maxDepth2(TreeNode root) {
        if(root==null)
            return 0;

        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;

        return Math.max(left,right);

    }
}
