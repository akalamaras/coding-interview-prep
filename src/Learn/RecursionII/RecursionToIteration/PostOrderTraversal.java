package Learn.RecursionII.RecursionToIteration;

import Support.TreeNode;
import java.util.*;

public class PostOrderTraversal {

    class Recursive {

        public List<Integer> postOrderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            postOrder(root, list);
            return list;

        }

        private void postOrder(TreeNode node, List<Integer> list) {

            if(node == null)
                return;

            postOrder(node.left,list);
            postOrder(node.right,list);
            list.add(node.val);
        }
    }

    class Iterative {

        public List<Integer> postOrderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            if (root == null)
                return list;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while(!stack.isEmpty()) {

                root = stack.pop();
                list.add(0,root.val);

                if(root.left != null)
                    stack.push(root.left);

                if(root.right != null)
                    stack.push(root.right);
            }
            return list;
        }
    }
}
