package Companies.SAP;

import java.util.*;


public class BinaryTreeLevelOrderTraversal {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Recursive {

        private List<List<Integer>> list = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {

            helper(root, 1);
            return list;

        }

        private void helper(TreeNode root, int level) {

            if (root == null)
                return;

            if (list.size() < level)
                list.add(new ArrayList<>());

            List<Integer> currentList = list.get(level - 1);
            currentList.add(root.val);

            helper(root.left, level + 1);
            helper(root.right, level + 1);
        }
    }

    class Iterative {

        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> list = new ArrayList<>();

            if(root == null)
                return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int level = 0;

            while(!queue.isEmpty()) {

                list.add(new ArrayList<>());

                for(int i = 0; i < queue.size(); i++) {
                    TreeNode node = queue.poll();

                    list.get(level).add(node.val);

                    if(node.left != null)
                        queue.add(node.left);

                    if(node.right != null)
                        queue.add(node.right);
                }
                level++;
            }
            return list;
        }
    }
}
