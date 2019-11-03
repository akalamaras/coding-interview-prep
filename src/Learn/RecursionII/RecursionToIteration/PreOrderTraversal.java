package Learn.RecursionII.RecursionToIteration;

import Support.TreeNode;
import java.util.*;

public class PreOrderTraversal {

    class Recursive {

        public List<Integer> preOrderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            preOrder(root, list);
            return list;
        }

        private void preOrder(TreeNode root, List<Integer> list) {

            if(root == null)
                return;

            list.add(root.val);
            preOrder(root.left,list);
            preOrder(root.right,list);
        }
    }

    class Iterative {


        public List<Integer> preOrderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            if(root == null)
                return list;

            stack.add(root);
            while(!stack.isEmpty()) {

                TreeNode node = stack.pop();
                list.add(node.val);

                if(node.right != null)
                    stack.push(node.right);

                if(node.left != null)
                    stack.push(node.left);
            }
            return list;
        }
     }
}
