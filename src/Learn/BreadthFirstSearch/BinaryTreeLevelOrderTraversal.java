package Learn.BreadthFirstSearch;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if(root == null)
            return list;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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
