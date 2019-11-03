package Redos.Medium.TreesAndGraphs;

import Support.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigZagOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        helper(root, 0, levels);

        int index = 1;
        while(index < levels.size()) {

            Collections.reverse(levels.get(index));
            index = index + 2;
        }
        return levels;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> levels) {

        if(node == null)
            return;

        if(levels.size() == level)
            levels.add(new ArrayList<>());

        levels.get(level).add(node.val);

        helper(node.left, level + 1, levels);
        helper(node.right, level + 1, levels);
    }

    public List<List<Integer>> zigzagOrderTraversal(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        travel(root, 0, list);
        return list;
    }

    private void travel(TreeNode node, int level, List<List<Integer>> list) {

        if(node == null)
            return;

        if(list.size() == level)
            list.add(new ArrayList<>());

        if(level % 2 == 0)
            list.get(level).add(node.val);
        else
            list.get(level).add(0, node.val);

        travel(node.left, level + 1, list);
        travel(node.right, level + 1, list);
    }
}
