package Companies.SAP;

import java.util.*;

public class BinaryTreeInorderTraversal {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Recursive {

        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            return list;

        }

        private void inorder(TreeNode root, List<Integer> list) {

            if (root == null)
                return;

            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    class Iterative {

        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            if(root == null)
                return list;

            TreeNode current = root;

            while(current != null || !stack.isEmpty()) {

                // go to the bottom left
                while(current != null) {
                    stack.push(current);
                    current = current.left;
                }

                current = stack.pop();
                list.add(current.val);
                current = current.right;




            }
            return list;
        }
    }
}
