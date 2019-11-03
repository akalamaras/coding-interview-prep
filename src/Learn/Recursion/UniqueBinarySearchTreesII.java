package Learn.Recursion;

import Support.TreeNode;
import java.util.*;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new LinkedList<>();
        if(start > end) {
            trees.add(null);
            return trees;
        }

        // pick a root
        for(int i = start; i <= end; i++) {

            // all possible left subtrees
            List<TreeNode> left = generateTrees(start,i-1);

            // all possible right subtrees
            List<TreeNode> right = generateTrees(i+1,end);

            // connect left and right to root
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    // root
                    TreeNode current = new TreeNode(i);
                    current.left = l;
                    current.right = r;
                    trees.add(current);
                }
            }
        }
        return trees;

    }
}
