package Companies.Apple.TreesAndGraphs;

import Support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public boolean sameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null)
            return true;

        if(p == null || q == null || p.val != q.val)
            return false;

        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }


    











    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()) {

            TreeNode one = queue.poll();
            TreeNode other = queue.poll();

            if(one == null && other == null)
                continue;
            else if(one == null || other == null || one.val != other.val)
                return false;

            queue.offer(one.left);
            queue.offer(one.right);

            queue.offer(other.left);
            queue.offer(other.right);
        }
        return true;
    }
}

