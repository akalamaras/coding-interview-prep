package Learn.BinarySearchTrees;

import Support.TreeNode;

public class InsertBST {

    public TreeNode insert(TreeNode root,int val) {

        if (root == null) {
            return new TreeNode(val);   // return a new node if root is null
        }
        if (root.val < val) {           // insert to the right subtree if val > root->val
            root.right = insert(root.right, val);
        } else {                        // insert to the left subtree if val <= root->val
            root.left = insert(root.left, val);
        }
        return root;
    }
}
