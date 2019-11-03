package Companies.Cisco.SecondGo.Trees;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorder {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode node) {

        if(node == null)
            return;

        list.add(node.val);
        helper(list, node.left);
        helper(list, node.right);
    }
}
