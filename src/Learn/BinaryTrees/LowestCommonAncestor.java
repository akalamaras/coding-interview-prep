package Learn.BinaryTrees;

import Support.TreeNode;

public class LowestCommonAncestor {

    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if(root == null || root == p || root == q)
                return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left == null)
                return right;

            if(right == null)
                return left;

            return root;
        }
    }

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        recurseTree(root, p, q);
        return ans;
    }

    private boolean recurseTree(TreeNode node, TreeNode p, TreeNode q) {

        if(node == null)
            return false;

        int left = recurseTree(node.left, p ,q) ? 1 : 0;

        int right = recurseTree(node.right, p, q) ? 1 : 0;

        int mid = (node == p || node == q) ? 1 : 0;

        if(left + right + mid >= 2)
            ans = node;

        return left + right + mid > 0;
    }
}
