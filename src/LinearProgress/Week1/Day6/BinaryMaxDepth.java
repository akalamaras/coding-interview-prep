package LinearProgress.Week1.Day6;

import java.util.*;
import Support.*;

public class BinaryMaxDepth {

    // Recursive
    private int maxDepth(TreeNode root) {
        int depth = 0;
        return checkSubtree(depth,root);
    }

    private int checkSubtree(int depth,TreeNode p) {
        if(p == null) return depth;
        int leftDepth = checkSubtree(depth+1,p.left);
        int rightDepth = checkSubtree(depth+1,p.right);
        return  leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    // Iterative, DFS
    private int DepthFirstSolution(TreeNode root) {
        if(root==null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = value.pop();
            max = Math.max(depth,max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(depth+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(depth+1);
            }
        }
        return max;
    }

    private int BreadthFirstSolution(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        // .offer inserts the specified element into the queue
        // if it is possible to do so immediately without violating
        // capacity restrictions. This method is preferable to add() method
        // since this method does not throws an exception when the capacity
        // of the container is full since it returns false.
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                // .poll  returns and removes the element at the front the container.
                // It deletes the element in the container. The method does not
                // throw an exception when the MyQueue is empty, it returns null instead.
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            count++;
        }
        return count;

    }

}
