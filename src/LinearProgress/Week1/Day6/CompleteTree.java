package LinearProgress.Week1.Day6;

import Support.*;

public class CompleteTree {

    private boolean isComplete(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;
        return (isComplete(root.left) && isComplete(root.right));
    }
}
