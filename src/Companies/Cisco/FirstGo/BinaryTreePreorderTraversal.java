package Companies.Cisco.FirstGo;

import Support.TreeNode;
import java.util.*;

public class BinaryTreePreorderTraversal {

    /**
     * Given a binary tree, return the preorder traversal of its nodes' values
     * E.g : Input [1,null,2,3]
     *
     *         1
     *          \
     *           2
     *          /
     *         3
     *
     *       Output [1,2,3]
     *
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */


    // Approach #1 Recursive (Accepted, O(n) time complexity, O(n) space complexity)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    public void helper(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        helper(node.left,list);
        helper(node.right,list);
    }

    // Approach #2 Iterative (Accepted, O(n) time complexity, O(n) space complexity)
    public List<Integer> preorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;


        /* Start from the root. At each iteration pop the current node out of the stack and
           push its child nodes. We push nodes into the output list following the order
           Top -> Bottom & Left -> Right that naturally reproduces preorder traversal */
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return list;
    }

    // Approach #3 Morris Traversal (Accepted, O(n) time complexity, O(n)* space complexity)
    // *we use no additional memory for the computation itself, but output list contains n
    //  elements, and thus space complexity is O(n)

    // Based on https://www.sciencedirect.com/science/article/pii/0020019079900681
    public List<Integer> preorderMorris(TreeNode root) {

        LinkedList<Integer> list = new LinkedList<>();

        /*
         *  This approach is based on Morris' article which is intended to optimize
         * space complexity. The algorithm does not use additional space for the computation,
         * and the memory is only used to keep the output list. If one prints the output
         * directly after computation, the space complexity would be O(1).
         *
         *
         *  The idea is to go down from the node to its predecessor, and each predecessor will
         * be visited twice. For this, go one step left if possible and then always go right til
         * the end. When we visit a leaf node first time, we update output and establish the
         * pseudo link predecessor.right = root to mark the fact that the predecessor is visited.
         * When we visit the same predecessor the second time, it already points to the current
         * node, so we remove the pseudo link and move right to the next node.
         * If the first one step is impossible, update output and move right to the next node.
         */
        TreeNode node = root;
        while(node != null) {

            if(node.left != null) {
                list.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while(predecessor.right != null && predecessor.right != node)
                    predecessor = predecessor.right;
                if(predecessor.right == null) {
                    list.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return list;
    }




}
