package Learn.BinaryTrees;

import Support.TreeNode;

public class ConstructTreeFromPreorderInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0)
            return null;

        if(inorder == null || inorder.length == 0)
            return null;

        if(preorder.length != inorder.length)
            return null;

        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {

        if(preStart >= preorder.length || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0; // Index of current root in inorder
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val)
                inIndex = i;
        }

        root.left = helper(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        root.right = helper(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd);
        return root;
    }
}

