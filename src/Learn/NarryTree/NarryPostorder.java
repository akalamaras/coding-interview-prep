package Learn.NarryTree;

import java.util.*;

public class NarryPostorder {

    class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> postorder(Node root) {

        List<Integer> output = new ArrayList<>();

        if(root == null)
            return output;

        helper(root,output);
        return output;
    }

    private void helper(Node root, List<Integer> output) {

        if(root == null)
            return;

        for(Node n: root.children)
            helper(n,output);
        output.add(root.val);
    }
}
