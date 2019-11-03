package Learn.BinarySearchTrees;

import Support.TreeNode;

public class KthSmallestBST {



    private int number = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        helper(root);
        return this.number;
    }

    private void helper(TreeNode node) {

        if(node.left != null)
            helper(node.left);
        count--;

        if(count == 0) {
            number = node.val;
            return;
        }

        if(node.right != null)
            helper(node.right);
    }


}
