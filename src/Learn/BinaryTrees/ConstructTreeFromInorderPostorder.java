package Learn.BinaryTrees;

import Support.TreeNode;

import java.util.HashMap;

public class ConstructTreeFromInorderPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || inorder.length == 0)
            return null;

        if(postorder == null || postorder.length == 0)
            return null;

        if(inorder.length != postorder.length)
            return null;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i],i);

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

    }

    private TreeNode helper(int[] inorder, int inorderStart, int inorderEnd,
                            int[] postorder, int postorderStart, int postorderEnd,
                            HashMap<Integer,Integer> map) {


        if(inorderStart > inorderEnd)
            return null;

        if(postorderStart > postorderEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int rootIndex = map.get(postorder[postorderEnd]);

        TreeNode leftChild = helper(inorder, inorderStart, rootIndex - 1,
                                    postorder, postorderStart, postorderStart + rootIndex - inorderStart - 1, map);

        TreeNode rightChild = helper(inorder, rootIndex + 1, inorderEnd,
                                    postorder, postorderStart + rootIndex - inorderStart, postorderEnd - 1, map);

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
