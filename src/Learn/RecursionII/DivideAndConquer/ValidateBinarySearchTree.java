package Learn.RecursionII.DivideAndConquer;

import Support.*;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minVal, long maxVal) {

        if(node == null)
            return true;

        if(node.val >= maxVal || node.val <= minVal)
            return false;

        return isValidBST(node.left,minVal,node.val) && isValidBST(node.right,node.val,maxVal);
    }
}
