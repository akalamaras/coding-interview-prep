package Learn.RecursionII.RecursionToIteration;

import Support.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    class Recursive {

        List<List<Integer>> list = new ArrayList<>();

        public List<List<Integer>> levelOrderTraversal(TreeNode root) {

            if(root == null)
                return list;
            levelOrder(root,0);
            return list;
        }

        private void levelOrder(TreeNode root, int level) {

            if(list.size() == level)
                list.add(new ArrayList<>());

            list.get(level).add(root.val);

            if(root.left != null)
                levelOrder(root.left,level + 1);

            if(root.right != null)
                levelOrder(root.right,level + 1);
        }

    }

    class Iterative {

        public List<List<Integer>> levelOrderTraversal(TreeNode root) {

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

