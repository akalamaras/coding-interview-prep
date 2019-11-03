package Learn.BinaryTrees;

import Support.TreeNode;

public class Symmetric {

    private boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return checkMirror(root,root);

    }

    private boolean checkMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return(left.val == right.val && checkMirror(right.left,left.right)
                                    && checkMirror(left.left,right.right));
    }


}
