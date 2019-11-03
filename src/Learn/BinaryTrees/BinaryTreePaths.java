package Learn.BinaryTrees;

import Support.TreeNode;
import java.util.*;

public class BinaryTreePaths {

    // Recursive
    public List<String> binaryTreePathsRecursive(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        if(root.left == null && root.right == null) {
            list.add(Integer.toString(root.val));
            return list;
        }
        for(String s: binaryTreePathsRecursive(root.left)) {
            list.add(root.val+"->"+s);
        }
        for(String s: binaryTreePathsRecursive(root.right)){
            list.add(root.val+"->"+s);
        }
        return list;
    }

    // BFS
    public List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<String> queueStr = new LinkedList<>();
        if(root == null) return list;
        queueNode.add(root);
        queueStr.add("");
        while(!queueNode.isEmpty()) {
            TreeNode currentNode = queueNode.remove();
            String currentString = queueStr.remove();
            if(currentNode.left == null && currentNode.right == null) {
                list.add(currentString+currentNode.val);
            }
            if(currentNode.left != null) {
                queueNode.add(currentNode.left);
                queueStr.add(currentString+currentNode.val+"->");
            }
            if(currentNode.right != null) {
                queueNode.add(currentNode.right);
                queueStr.add(currentString+currentNode.val+"->");
            }
        }
        return list;
    }

    // DFS
    public List<String> binaryTreePathsDFS(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        if(root==null) return list;
        stackNode.push(root);
        stackStr.push("");
        while(!stackNode.isEmpty()) {
            TreeNode currentNode = stackNode.pop();
            String currentString = stackStr.pop();
            if(currentNode.left == null && currentNode.right == null) {
                list.add(currentString+currentNode.val);
            }
            if(currentNode.right != null) {
                stackNode.push(currentNode.right);
                stackStr.push(currentString+currentNode.val+"->");
            }
            if(currentNode.left != null) {
                stackNode.push(currentNode.left);
                stackStr.push(currentString+currentNode.val+"->");
            }

        }
        return list;

    }
}
