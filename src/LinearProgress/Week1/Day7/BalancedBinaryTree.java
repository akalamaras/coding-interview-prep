package LinearProgress.Week1.Day7;

import Support.*;

// NOT COMPLETE
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int levelDiff = helper(root.left,0) - helper(root.right,0);
        return ( Math.abs(levelDiff) <= 1);
    }

    private int helper(TreeNode node, int level) {
        if(node==null) return level;
        if(node.left == null && node.right == null) return level+1;
        int leftLevel = level,rightLevel = level;
        if(node.left != null) leftLevel = helper(node.left,level+1);
        if(node.right != null) rightLevel = helper(node.right,level+1);
        return (leftLevel > rightLevel) ? leftLevel : rightLevel;
    }

    // NEXT TRY
    private boolean balanced(TreeNode root) {
        if(root==null) return true;
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if(node == null) return 0;
        int heightL = height(node.left);
        if(heightL == -1) return -1;
        int heightR = height(node.right);
        if(heightR == -1) return -1;
        if(heightL - heightR < -1 || heightL - heightR > 1) return -1;
        return Math.max(heightL,heightR)+1;
    }

}
