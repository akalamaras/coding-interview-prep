package Learn.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PopulateRightPointerInEachNode {

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {

            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // Dunno why this no work

    public Node connect(Node root) {

        List<List<Node>> levels = levelOrder(root);

        if(levels == null || levels.size() == 0)
            return root;

        for(List<Node> level : levels) {

            if(level.size() < 2)
                continue;

            for(int i = 0; i < level.size() - 2; i++)
                level.get(i).next = level.get(i + 1);
            level.get(levels.size()-1).next = null;
        }
        return root;

    }

    public List<List<Node>> levelOrder(Node root) {

        List<List<Node>> levels = new ArrayList<>();

        if(root == null)
            return null;

        helper(root, levels, 0);
        return levels;
    }

    private void helper(Node node, List<List<Node>> levels, int currentLevel) {

        if(node == null)
            return;

        if(levels.size() == currentLevel)
            levels.add(new ArrayList<>());

        levels.get(currentLevel).add(node);

        helper(node.left, levels, currentLevel + 1);
        helper(node.right, levels, currentLevel + 1);

    }

    class NoExtraSpace {


        // Recursive stack does not count as extra space for this problem

        public Node connect(Node root) {

            for (Node head = root; head != null; ) {

                Node nextHead = new Node(0);
                Node nextTail = nextHead;

                for (Node node = head; node != null; node = node.next) {
                    if (node.left != null) {
                        nextTail.next = node.left;
                        nextTail = node.left;
                    }
                    if (node.right != null) {
                        nextTail.next = node.right;
                        nextTail = node.right;
                    }
                }
                head = nextHead.next;
            }
            return root;
        }
    }
}
