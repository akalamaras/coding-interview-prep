package Learn.BreadthFirstSearch;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagOrderTraversal {

    public List<List<Integer>> zigzagOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if(root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int level = queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < level; i++) {

                TreeNode tempNode = queue.poll();
                temp.add(tempNode.val);

                if(tempNode.left != null)
                    queue.add(tempNode.left);

                if(tempNode.right != null)
                    queue.add(tempNode.right);
            }

            if(level % 2 == 1)
                list.add(0, temp);
            else
                list.add(temp);

        }
        return list;
    }
}
