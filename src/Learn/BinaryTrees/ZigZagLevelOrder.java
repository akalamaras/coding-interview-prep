package Learn.BinaryTrees;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        recurse(root, 0, ans);
        return ans;
    }

    private void recurse(TreeNode node, int level, List<List<Integer>> ans) {

        if(node == null)
            return;

        if(level == ans.size())
            ans.add(new ArrayList<>());

        List<Integer> currentLevel = ans.get(level);

        if(level % 2 == 0)
            currentLevel.add(node.val);
        else
            currentLevel.add(0, node.val);

        recurse(node.left, level + 1, ans);
        recurse(node.right, level + 1, ans);
    }
}
