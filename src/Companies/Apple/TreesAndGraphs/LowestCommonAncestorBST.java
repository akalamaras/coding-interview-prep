package Companies.Apple.TreesAndGraphs;

import Support.TreeNode;

public class LowestCommonAncestorBST {

    public TreeNode lowerCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;

        if(root.val > p.val && root.val > q.val)
            return lowerCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return lowerCommonAncestor(root.right, p, q);
        else
            return root;
    }
}
