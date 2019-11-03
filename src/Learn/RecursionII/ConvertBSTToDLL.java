package Learn.RecursionII;

import Support.TreeNode;

public class ConvertBSTToDLL {

    class Node {

        int val;
        Node left;
        Node right;

        Node() {}

        Node(int _val, Node _left, Node _right) {

            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node prev;

    public Node treeToDoublyList(Node root) {

        if(root == null)
            return null;

        Node dummy = new Node(0,null,null);
        prev = dummy;

        helper(root);

        // Connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(Node node) {

        if(node == null)
            return;

        helper(node.left);

        prev.right = node;
        node.left = prev;

        prev = node;

        helper(node.right);
    }
}
