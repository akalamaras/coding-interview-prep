package Companies.SAP;

import java.util.*;

public class MaximumBinaryTreeDepth {

    private int maximumDepth = 0;

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Recursive {

        public int maxDepth(TreeNode root) {
            helper(root, 1);
            return maximumDepth;
        }

        private void helper(TreeNode root, int currentDepth) {

            if (root == null)
                return;

            if (root.left == null && root.right == null) {
                maximumDepth = Math.max(maximumDepth, currentDepth);
                return;
            }

            helper(root.left, currentDepth + 1);
            helper(root.right, currentDepth + 1);
        }
    }

    class Iterative {

        public int maxDepth(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> depths = new LinkedList<>();

            if(root == null)
                return 0;

            queue.add(root);
            depths.add(1);


            int depth = 0;
            int currentDepth = 0;

            while(!queue.isEmpty())  {

                root = queue.poll();
                currentDepth = depths.poll();

                if(root != null) {

                    depth = Math.max(depth,currentDepth);

                    queue.add(root.left);
                    depths.add(currentDepth + 1);

                    queue.add(root.right);
                    depths.add(currentDepth + 1);
                }
            }
            return depth;
        }

    }
}
