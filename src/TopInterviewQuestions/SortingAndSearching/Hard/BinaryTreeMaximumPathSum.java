package TopInterviewQuestions.SortingAndSearching.Hard;

import Support.TreeNode;

public class BinaryTreeMaximumPathSum {

    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {

        if(node == null)
            return 0;

        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));

        maxValue = Math.max(maxValue, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
