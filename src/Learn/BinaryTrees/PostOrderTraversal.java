package Learn.BinaryTrees;

import java.util.*;
import Support.TreeNode;


public class PostOrderTraversal {

    private List<Integer> postorderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;

    }

    private void helper(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left != null) helper(node.left,list);
        if(node.right != null) helper(node.right,list);
        list.add(node.val);
    }

    private List<Integer> postorderIterative(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(node==null) return list;
        stack.push(node);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if(current.left != null) stack.push(current.left);
            if(current.right != null) stack.push(current.right);
        }
        return list;

    }
}
