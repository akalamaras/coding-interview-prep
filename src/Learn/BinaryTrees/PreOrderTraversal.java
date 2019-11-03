package Learn.BinaryTrees;

import java.util.*;
import Support.TreeNode;

public class PreOrderTraversal {

    // Recursive solution
    private List<Integer> preorderRecursive (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }


    private void helper(TreeNode node,List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        if(node.left != null) helper(node.left,list);
        if(node.right != null) helper(node.right,list);
    }

    // Iterative solution
    private List<Integer> preorderIterative(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null) {
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            node = node.left;
            if (node == null && !stack.isEmpty()) {
                node = stack.pop();
            }
        }
        return list;
    }
}
