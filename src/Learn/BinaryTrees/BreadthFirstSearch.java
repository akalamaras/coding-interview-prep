package Learn.BinaryTrees;

import Support.*;


import java.util.*;


public class BreadthFirstSearch {

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;

        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<levelNum;i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                level.add(queue.poll().val);
            }
            list.add(level);
        }
        return list;


    }
}
