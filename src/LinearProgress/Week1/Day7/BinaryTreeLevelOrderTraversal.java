package LinearProgress.Week1.Day7;

import Support.*;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    private List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> counts = new ArrayList<>();

        visit(root,counts,0);
        Collections.reverse(counts);
        return counts;
    }

    private void visit(TreeNode node,List<List<Integer>> counts, int level) {
        if(node == null)  return;
        if(counts.size() < level+1) counts.add(new ArrayList<>());
        counts.get(level).add(node.val);

        visit(node.left, counts, level+1);
        visit(node.right, counts, level+1);
    }
}
