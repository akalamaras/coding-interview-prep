package Learn.BinarySearchTrees;

import Support.*;

import java.util.Stack;

public class ValidateBST {


    class Iterative {
        // doesnt work for duplicates
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (pre != null && root.val <= pre.val) return false;
                pre = root;
                root = root.right;
            }
            return true;
        }
    }

    class Recursive {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode node, long minVal, long maxVal) {

            if(node == null)
                return true;

            if(node.val >= maxVal || node.val <= minVal)
                return false;

            return isValidBST(node.left,minVal,node.val) && isValidBST(node.right,node.val,maxVal);
        }
    }
}
