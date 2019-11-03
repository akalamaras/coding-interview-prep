package Learn.BinaryTrees;

import Support.*;

public class CountUnivalueSubtrees {

    private int count;

    public CountUnivalueSubtrees() {
        count = 0;
    }

    public boolean all(TreeNode root,int val) {

        if(root == null)
            return true;


        //  "|" ensures that the recursion will do both sides instead of "||" which
        //  might only do the left side if it is false, and will thus not increment 'count'
        if(!all(root.left,root.val) | !all(root.right, root.val))
            return false;

        count++;

        return root.val == val;

    }

    public int countUnivalSubtrees(TreeNode root) {
        all(root,0);
        return count;
    }
}


