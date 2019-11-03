package Companies.Cisco.ThirdGo;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BnaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        int level = 0;

        helper(root, level, list);
        return list;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> list) {

        if(node == null)
            return;

        if(level == list.size())
            list.add(new ArrayList<>());

        list.get(level).add(node.val);

        helper(node.left, level + 1, list);
        helper(node.right, level + 1, list);
    }
}
