package Companies.Cisco.SecondGo.Trees;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }

    private void helper(TreeNode node, List<List<Integer>> list, int level) {

        if(node == null)
            return;

        if(list.size() == level)
            list.add(new ArrayList<>());

        list.get(level).add(node.val);

        helper(node.left, list, level + 1);
        helper(node.right, list, level + 1);
    }
}
