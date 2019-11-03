package Learn.BinaryTrees;

import Support.*;

public class SumOfLeftLeaves {

    int sum;

    public SumOfLeftLeaves() {
        sum = 0;
    }

    private int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return sum;

    }

    private void helper(TreeNode node) {
        if(node == null) return;
        if(node.left == null) helper(node.right);
        if(node.right == null) helper(node.left);
        if(node.left == null) return;
        if(node.left.left == null && node.left.right == null) sum+= node.left.val;
    }
}

