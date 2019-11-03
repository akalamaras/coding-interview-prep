package Learn.RecursionII.RecursionToIteration;


import Support.TreeNode;

import java.util.ArrayDeque;

public class SameTree {

    class Recursive {

        public boolean isSame(TreeNode p, TreeNode q) {

            if(p == null && q == null)
                return true;

            if(p == null || q == null)
                return false;

            return p.val == q.val
                    && isSame(p.left,q.left) && isSame(p.right, q.right);
        }
    }

    class Iterative {

        private boolean check(TreeNode p, TreeNode q) {

            if(p == null && q == null)
                return true;

            if(p == null || q == null)
                return false;

            return(p.val == q.val);
        }

        public boolean isSame(TreeNode p, TreeNode q) {

            if(p == null && q == null)
                return true;

            if(!check(p,q))
                return false;

            ArrayDeque<TreeNode> deqP = new ArrayDeque<>();
            ArrayDeque<TreeNode> deqQ = new ArrayDeque<>();

            deqP.addLast(p);
            deqQ.addLast(q);

            while(!deqP.isEmpty()) {

                p = deqP.removeFirst();
                q = deqQ.removeFirst();

                if(!check(p,q))
                    return false;


                if(!check(p.left,q.left))
                    return false;

                if(p.left != null) {

                    deqP.add(p.left);
                    deqQ.add(q.left);
                }

                if(!check(p.right,q.right))
                    return false;

                if(p.right != null) {

                    deqP.add(p.right);
                    deqQ.add(q.right);
                }
            }
            return true;
        }
    }
}
