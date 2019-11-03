package Learn.DepthFirstSearch;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }

    private void helper(TreeNode node, List<List<Integer>> list, int level) {

        if(node == null)
            return;

        if(level >= list.size())
            list.add(0, new ArrayList<>());

        helper(node.left, list, level + 1);
        helper(node.right, list, level + 1);
    }
}
