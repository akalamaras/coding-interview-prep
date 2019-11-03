package Learn.BinarySearchTrees;

import Support.TreeNode;

public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;
        else
            return (val < root.val) ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode searchBSTIterative(TreeNode root, int target) {
        TreeNode cur = root;
        while (cur != null && cur.val != target) {
            if (target < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }
}
