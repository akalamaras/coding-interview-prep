package LinearProgress.Week1.Day6;

import Support.*;

public class SameTree {

    private boolean isSameTree(TreeNode p, TreeNode q) {
        return checkNode(p,q);
    }

    private boolean checkNode(TreeNode p,TreeNode q) {
        try {
            if (!(p.val == q.val)) return false;
        } catch (NullPointerException e) {
            return (p == null && q == null);
        }
        if (p.left == null && q.left == null && p.right == null && q.right == null)
            return true;
        else if (p.left == null && q.left == null)
            return checkNode(p.right,q.right);
        else if (p.right == null && q.right == null)
            return checkNode(p.left,q.left);
        else {
            boolean bool1 = checkNode(p.left, q.left);
            boolean bool2 = checkNode(p.right, q.right);
            return (bool1 && bool2);
        }
    }
}
