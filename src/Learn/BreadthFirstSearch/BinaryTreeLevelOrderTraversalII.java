package Learn.BreadthFirstSearch;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return list;

        queue.offer(root);
        while(!queue.isEmpty()) {

            int level = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < level; i++) {

                TreeNode current = queue.poll();

                if(current.left != null)
                    queue.offer(current.left);

                if(current.right != null)
                    queue.offer(current.right);

                levelList.add(current.val);
            }
            list.add(0, levelList);
        }
        return list;
    }
}
