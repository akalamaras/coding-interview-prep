package LinearProgress.Week1.Day6;

import java.util.*;
import Support.*;

public class SymmetricTree {


    // Recursive solution
    private boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return checkMirror(root,root);

    }

    private boolean checkMirror(TreeNode p,TreeNode q) {

        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val == q.val && checkMirror(q.left,p.right) && checkMirror(p.left,q.right));

    }

    // Iterative solution
    private boolean iterativeSolution(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null) return true;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
