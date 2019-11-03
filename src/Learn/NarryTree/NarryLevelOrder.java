package Learn.NarryTree;

import java.util.*;

public class NarryLevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> output = new ArrayList<>();

        if(root == null)
            return output;

        int level = 0;
        helper(root,output,0);
        return output;
    }

    private void helper(Node root, List<List<Integer>> output, int level) {

        if(root == null)
            return;

        if(output.size() == level)
            output.add(new ArrayList<>());

        output.get(level).add(root.val);
        for(Node n: root.children)
            helper(n, output, level + 1);

    }
}
