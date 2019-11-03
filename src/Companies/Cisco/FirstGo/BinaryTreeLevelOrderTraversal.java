package Companies.Cisco.FirstGo;

import java.util.*;
import Support.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    // Approach #1 Recursive (Accepted, O(n) time complexity, O(n) space complexity)

    private List<List<Integer>> levels = new ArrayList<>();



    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels; // edge case
        helper(root,0);
        return levels;
    }

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level) // if the level already exists we dont want to start a new one
            levels.add(new ArrayList<>());

        // add the value to the level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }


    // Approach #2 Iterative (Accepted, O(n) time complexity, O(n) space complexity to
    // keep the output structure which contains n node values)
    public List<List<Integer>> levelOrderIterative(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return levels; // edge case

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            // start the current level
            levels.add(new ArrayList<>());

            // number of elements in the current level
            int levelLength = queue.size();
            for(int i = 0; i < levelLength; i++) {
                TreeNode node = queue.remove();

                // fill the current level
                levels.get(level).add(node.val);

                // add child nodes to the queue
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

            }
            // go to the next level
            level++;
        }
        return levels;
    }
}
