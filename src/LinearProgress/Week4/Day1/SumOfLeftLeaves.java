package LinearProgress.Week4.Day1;

import Support.*;

import java.util.Stack;

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


    private int iterative(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if(node.left.left == null && node.left.right == null) {
                    ans += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if(node.right != null) {
                if(node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }
}
