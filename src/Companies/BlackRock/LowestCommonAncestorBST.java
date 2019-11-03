package Companies.BlackRock;

public class LowestCommonAncestorBST {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Recursive {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root.val > q.val && root.val > p.val)
                return lowestCommonAncestor(root.left, p, q);
            else if (root.val < q.val && root.val < p.val)
                return lowestCommonAncestor(root.right, p, q);
            else
                return root;
        }
    }

    class Iterative {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            TreeNode current = root;

            while(current != null) {

                if(root.val > q.val && root.val > p.val)
                    current = current.left;
                else if(root.val < q.val && root.val < p.val)
                    current = current.right;
                else
                    return current;

            }
            return null;
        }
    }
}
