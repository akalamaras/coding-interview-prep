package Learn.RecursionII.RecursionToIteration;

import java.util.*;
import Support.TreeNode;

public class InOrderTraversal {

    class Recursive {

        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list;

        }

        private void inOrder(TreeNode root, List<Integer> list) {

            if(root == null)
                return;

            inOrder(root.left,list);
            list.add(root.val);
            inOrder(root.right,list);
        }
    }

    class Iterative {

        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            TreeNode current = root;
            while(current != null || !stack.isEmpty()) {

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
