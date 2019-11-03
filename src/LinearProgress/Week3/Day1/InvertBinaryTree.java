package LinearProgress.Week3.Day1;

import Support.TreeNode;
import java.util.*;

public class InvertBinaryTree {

    private TreeNode invertTreeRecursive(TreeNode root) {
        if(root == null) return null;
        TreeNode right = invertTreeRecursive(root.right);
        TreeNode left = invertTreeRecursive(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    private TreeNode invertTreeIterative(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return root;
    }
}
