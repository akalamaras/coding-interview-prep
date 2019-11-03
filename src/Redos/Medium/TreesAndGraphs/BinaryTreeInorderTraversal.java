package Redos.Medium.TreesAndGraphs;

import Support.ListNode;
import Support.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()) {

            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {

        if(node == null)
            return;

        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}
