package Learn.NarryTree;

import java.util.*;

public class NarryPreorder {

    class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Recursive {

        public List<Integer> preorder(Node root) {


            List<Integer> output = new ArrayList<>();

            if(root == null)
                return output;

            helper(root, output);
            return output;
        }

        private void helper(Node node, List<Integer> output) {

            output.add(node.val);
            for(Node n: node.children)
                helper(n, output);
        }
    }


    class Iterative {

        public List<Integer> preorder(Node root) {

            Stack<Node> stack = new Stack<>();
            List<Integer> output = new ArrayList<>();

            if (root == null)
                return output;

            stack.add(root);
            while (!stack.isEmpty()) {

                Node node = stack.pop();
                output.add(node.val);

                Collections.reverse(node.children);
                for (Node item : node.children)
                    stack.add(item);
            }
            return output;
        }
    }
}
