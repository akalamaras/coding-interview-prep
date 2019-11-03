package Learn.NarryTree;

import java.util.List;

public class MaximumDepthNarry {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int max = 0;

    public int maxDepth(Node root) {

        if(root == null)
            return 0;

        helper(root,1);
        return max;
    }

    private void helper(Node node, int level) {

        if(node == null)
            return;

        max = Math.max(max, level);

        for(Node n: node.children)
            helper(n,level+1);
    }
}
