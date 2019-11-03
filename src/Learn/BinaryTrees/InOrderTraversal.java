package Learn.BinaryTrees;

import java.util.*;
import Support.*;

public class InOrderTraversal {

    private List<Integer> inorderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;

    }

    private void helper(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left != null) helper(node.left,list);
        list.add(node.val);
        if(node.right != null) helper(node.right,list);
    }

    private List<Integer> inorderIterative(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;

        while( current != null || !stack.isEmpty()) {
            while(current != null) { // Travel to the node's left child until the left leaf
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }
}
