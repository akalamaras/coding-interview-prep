package Learn.BinarySearchTrees;

import Support.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;

        if(root.val > q.val && root.val > p.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(root.val < q.val && root.val < p.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }
}
