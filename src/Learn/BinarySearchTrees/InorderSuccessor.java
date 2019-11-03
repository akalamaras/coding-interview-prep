package Learn.BinarySearchTrees;

import Support.TreeNode;

public class InorderSuccessor {

    class Recursive {

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            if (root == null)
                return null;

            if (root.val <= p.val)
                return inorderSuccessor(root.left, p);
            else {
                TreeNode left = inorderSuccessor(root.left, p);
                return (left != null) ? left : root;
            }
        }
    }

    class Iterative1 {


        public TreeNode successor(TreeNode root, TreeNode p) {

            TreeNode res = null;
            while(root != null) {
                if(root.val > p.val) {
                    res = root;
                    root = root.left;
                } else
                    root = root.right;
            }
            return res;
        }
    }
}
