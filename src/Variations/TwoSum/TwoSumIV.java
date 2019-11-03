package Variations.TwoSum;


import java.util.*;

/** Two Sum IV Input is a Binary Search Tree */
public class TwoSumIV {

    /** Definition of a Binary Tree Node */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /** Approach #1 HashSet
     *
     * This method works for all trees, not just BSTs
     *
     * O(n) time and O(n) space */
    public boolean findTarget(TreeNode root, int target) {
        Set<Integer> set = new HashSet<>();
        return find(root,target,set);
    }

    private boolean find(TreeNode root, int target, Set<Integer> set) {

        if(root == null)
            return false;

        int complement = target - root.val;
        if(set.contains(complement))
            return true;

        set.add(root.val);
        return find(root.left,target,set) || find(root.right,target,set);
    }

    /** Approach #2 BFS & HashSet
     *
     * Traverse the tree level by level
     *
     * O(n) time and O(n) space */
    public boolean findTarget2(TreeNode root, int target) {

        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            if(queue.peek() != null) {
                TreeNode node = queue.poll();
                int complement = target - node.val;

                if(set.contains(complement))
                    return true;

                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }

    /** Approach #3 Inorder Traversal
     *
     * By using inorder traversal, we can create a sorted array of the BST.
     * Then we just use a two pointer approach to find the answer
     *
     * O(n) time and O(n) space */
     public boolean findTarget3(TreeNode root, int target) {

         List<Integer> list = new ArrayList<>();
         inorder(root,list);

         int left = 0;
         int right = list.size()-1;

         while(left < right) {
             long sum = list.get(left) + list.get(right);
             if(sum == target)
                 return true;
             else if (sum < target)
                 left++;
             else
                 right--;
         }
         return false;



     }

     private void inorder(TreeNode root, List<Integer> list) {

         if(root == null)
             return;

         inorder(root.left,list);
         list.add(root.val);
         inorder(root.right,list);
     }
}
